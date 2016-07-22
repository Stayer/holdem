package ru.innopolis.university.summerbootcamp.java.project.contoller;

import ru.innopolis.university.summerbootcamp.java.project.ai.AIEngine;
import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.*;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;
import ru.innopolis.university.summerbootcamp.java.project.ui.ui;

import java.io.Console;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by iskandar on 22/07/16.
 */
public class GameController {

    public Game game = new Game();
    public int gameStage = GameStage.Start.getValue();
    public int dealerIndex;

    private SettingsServices settingsServices = SettingsServices.getInstance();

    private Scanner scanner = new Scanner(System.in);
    private Settings currentSettings;

    /**
     * change dealer, sb, bb
     */
    public void changeRoles() {
        dealerIndex = (dealerIndex + 1) % game.getHoldemPlayers().size();
        for(int i = 0; i < game.getHoldemPlayers().size(); i++)
        {
            if(i == (dealerIndex) % game.getHoldemPlayers().size()) {
                game.getHoldemPlayers().get(i).setDealer(true);
            } else {
                game.getHoldemPlayers().get(i).setDealer(false);
            }
            if(i == (dealerIndex + 1) % game.getHoldemPlayers().size()) {
                game.getHoldemPlayers().get(i).setSmallBlind(true);
            } else {
                game.getHoldemPlayers().get(i).setSmallBlind(false);
            }
            if(i == (dealerIndex + 2) % game.getHoldemPlayers().size()) {
                game.getHoldemPlayers().get(i).setBigBlind(true);
            } else {
                game.getHoldemPlayers().get(i).setBigBlind(false);
            }
        }
    }

    public HoldemPlayer getSmallBlindPlayer()
    {
        return game.getHoldemPlayers().stream().filter((p) -> Objects.equals(p.isSmallBlind(), true)).findFirst().orElse(null);
    }
    public HoldemPlayer getBigBlindPlayer()
    {
        return game.getHoldemPlayers().stream().filter((p) -> Objects.equals(p.isBigBlind(), true)).findFirst().orElse(null);
    }

    public static boolean emptyGame(List<HoldemPlayer> players) {

        int playerCounter = 0;
        for (HoldemPlayer p: players) {
            if (p.isInGame()) playerCounter++;
        }

        return playerCounter <= 1;
    }

    public void clearGame() {
        game.setTableCards(null);
        game.setDeck(null);
        changeRoles();
        for (HoldemPlayer p: game.getHoldemPlayers()) {
            if (p.getCash() < game.getLowestBet()) p.setInGame(false);
            p.setPlayingCards(null);
        }
    }

    public void recalculateScores(int userId, int cash) {
        game.getHoldemPlayers().get(userId).setCash(game.getHoldemPlayers().get(userId).getCash() + cash);
    }

    public void reactToDecision(AiDecision dec, int botId) {
        HoldemPlayer player = game.getHoldemPlayers().get(botId);

        switch (dec.getCommand()) {
            case Fold: // выводим бота из игры до следующего раунда
                player.setInGame(false);
                break;

            case Bet: // поддержали и обновили данные стола
                game.setTableCash(game.getTableCash() + game.getCurrentBet());
                player.setCash(player.getCash() - game.getCurrentBet());
                break;

            case Rise: // подняли ставку и обновиди данные игрока и стола
                game.setTableCash(game.getTableCash() + dec.getValue());
                player.setCash(player.getCash() - dec.getValue());
                game.setCurrentBet(dec.getValue());
                break;

            default:
                break;
        }
    }

    public int scan(String mess) {
        System.out.println(mess);
        return Integer.parseInt(scanner.nextLine());
    }

    public void debate() {
        int roundBet = 0;
        int index = dealerIndex + 1;
        AIEngine ai = new AIEngine();

        do {
            for (HoldemPlayer p: game.getHoldemPlayers()) {
                if (!p.isBot() && p.isInGame()) {
                    System.out.println("Your cash: " + p.getCash());
                    switch (scan("Enter your command (1-Fold; 2-Rise; 3-Call):")) {
                        case 1: // выводим бота из игры до следующего раунда
                            p.setInGame(false);
                            break;

                        case 3: // поддержали и обновили данные стола
                            game.setTableCash(game.getTableCash() + game.getCurrentBet());
                            p.setCash(p.getCash() - game.getCurrentBet());
                            break;

                        case 2: // подняли ставку и обновиди данные игрока и стола
                            int bet = scan("Enter your bet:");

                            game.setTableCash(game.getTableCash() + bet);
                            p.setCash(p.getCash() - bet);
                            game.setCurrentBet(bet);
                            break;
                    }
                } else if (p.isInGame()) {
                    List<PlayingCard> cards = Stream.concat(p.getPlayingCards().stream(), game.getTableCards().stream()).collect(Collectors.toList());

                    AiDecision aiDecision = ai.getDecision(cards, p.getCash(), game.getCurrentBet());
                    reactToDecision(aiDecision, game.getHoldemPlayers().indexOf(p));

                    System.out.print(p.getLogin() + ": ");
                    System.out.println(aiDecision.getCommand().toString());
                }

                if (roundBet == 0 && roundBet < game.getCurrentBet()) {
                    roundBet = game.getCurrentBet();
                }
            }

            if (roundBet < game.getCurrentBet()) {
                roundBet = game.getCurrentBet();
            } else {
                game.setCurrentBet(0);
                break;
            }


        } while(true);
    }

    public void initialize() {
        GameEngine ge = new GameEngine();

        HoldemPlayer player = login();
        System.out.println("Welcome, "+player.getLogin());
        int botCounter = 0;
        List<HoldemPlayer> players = new ArrayList<>();
        players.add(player);
        int playersCount = currentSettings.getPlayerCount();
        while (players.size() < playersCount) {
            botCounter++;
            HoldemPlayer holdemPlayer = new HoldemPlayer();
            holdemPlayer.setLogin("Bot" + botCounter);
            holdemPlayer.setBot(true);
            holdemPlayer.setCash(7000);
            players.add(holdemPlayer);
        }
        System.out.println("Game with " + playersCount + " players");


        game.setHoldemPlayers(players);
        game.setLowestBet(currentSettings.getBet());
        game.setCurrentBet(currentSettings.getBet());
        game.setTotalRoundBet(currentSettings.getBet());


        while (true) {
            // старт игры 1
            game.setDeck(ge.createAndShuffleDeck());

            for (HoldemPlayer p: game.getHoldemPlayers()) {
                List<PlayingCard> cards = new LinkedList<>();
                cards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                cards.add(game.getDeck().get(0));
                game.getDeck().remove(0);

                p.setPlayingCards(cards);
            }

            System.out.println("Game started.\nYour cards:");
            for (PlayingCard card: player.getPlayingCards()) {
                System.out.print(PlayingCard.getString(card));
                System.out.print(' ');
            }
            System.out.println();
            // раунд переговоров 1
            debate();

            System.out.println("first debates round");

            if (!emptyGame(game.getHoldemPlayers())) {

                // флоп 3  - добавление карт на стол
                List<PlayingCard> tableCards = new LinkedList<>();
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);

                game.setTableCards(tableCards);

                System.out.println("flop");

                // раунд переговоров 4
                debate();

                System.out.println("second debates round");

                if (!emptyGame(game.getHoldemPlayers())) {
                    // turn 5
                    tableCards.add(game.getDeck().get(0));
                    game.getDeck().remove(0);

                    game.setTableCards(tableCards);

                    System.out.println("turn");

                    // раунд переговоров 6
                    debate();

                    System.out.println("third debates round");

                    if (!emptyGame(game.getHoldemPlayers())) {

                        // reiver 7
                        tableCards.add(game.getDeck().get(0));
                        game.getDeck().remove(0);

                        game.setTableCards(tableCards);

                        System.out.println("riever");

                        // финальные раунд переговоров 8
                        debate();

                        if (!emptyGame(game.getHoldemPlayers())) {
                            System.out.println("final bets");


                            int winnerId = ge.winnerPicker(game.getHoldemPlayers(), game.getTableCards());
                            recalculateScores(winnerId, game.getTableCash());


                            System.out.println("winner is " + game.getHoldemPlayers().get(winnerId).getLogin());
                        }
                    }
                }
            }
            if (scan("Repeat? 1- yes, 2 - no") == 2) {
                break;
            }

            clearGame();
        }
    }

    /**
     * Gets user login and changes currentSetting
     * @return current player
     */
    public HoldemPlayer login() {
        System.out.print("Enter your login: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        currentSettings = settingsServices.findOne(input);

        HoldemPlayer player = new HoldemPlayer();
        player.setCash(currentSettings.getCash());

        player.setBet(currentSettings.getBet());
        player.setLogin(currentSettings.getUserName());
        return player;
    }

    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.initialize();
    }
}
