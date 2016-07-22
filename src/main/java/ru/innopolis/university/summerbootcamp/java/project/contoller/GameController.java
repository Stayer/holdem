package ru.innopolis.university.summerbootcamp.java.project.contoller;

import ru.innopolis.university.summerbootcamp.java.project.ai.AIEngine;
import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.*;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;
import ru.innopolis.university.summerbootcamp.java.project.ui.ui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iskandar on 22/07/16.
 */
public class GameController {
    public Game game = new Game();
    public int gameStage = GameStage.Start.getValue();
    public int dealerIndex;

    private SettingsServices settingsServices = SettingsServices.getInstance();


    /**
     * change dealer, sb, bb
     */
    public void changeRoles() {
        dealerIndex = (dealerIndex + 1) % game.getHoldemPlayers().size();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        return Integer.parseInt(scanner.nextLine());
    }

    public void debate() {
        int roundBet = 0;
        int index = dealerIndex + 1;
        AIEngine ai = new AIEngine();

        do {
            for (HoldemPlayer p: game.getHoldemPlayers()) {
                if (!p.isBot()) {
                    switch (scan("введите команду")) {
                        case 1: // выводим бота из игры до следующего раунда
                            p.setInGame(false);
                            break;

                        case 3: // поддержали и обновили данные стола
                            game.setTableCash(game.getTableCash() + game.getCurrentBet());
                            p.setCash(p.getCash() - game.getCurrentBet());
                            break;

                        case 2: // подняли ставку и обновиди данные игрока и стола
                            int bet = scan("укажите ставку");

                            game.setTableCash(game.getTableCash() + bet);
                            p.setCash(p.getCash() - bet);
                            game.setCurrentBet(bet);
                            break;
                    }
                } else if (p.isInGame()) {
                    AiDecision aiDecision = ai.getDecision(p.getPlayingCards(), p.getCash(), p.getBet());
                    reactToDecision(aiDecision, game.getHoldemPlayers().indexOf(p));
                }
            }

            if (roundBet < game.getCurrentBet()) {
                roundBet = game.getCurrentBet();
            } else {
                break;
            }
        } while(true);
    }

    public void initialize() {
        GameEngine ge = new GameEngine();

        Settings settings = settingsServices.findOne(ui.Name);

        HoldemPlayer player = new HoldemPlayer();
        player.setCash(settings.getCash());

        player.setBet(settings.getBet());
        int playerCount = settings.getPlayerCount() > 0 ? settings.getPlayerCount() : 3;

        int botCounter = 0;
        List<HoldemPlayer> players = new ArrayList<>();
        players.add(player);
        while (players.size() < playerCount) {
            botCounter++;
            HoldemPlayer holdemPlayer = new HoldemPlayer();
            holdemPlayer.setLogin("Bot" + botCounter);
            holdemPlayer.setBot(true);
            holdemPlayer.setCash(7000);
            players.add(holdemPlayer);
        }

        game.setHoldemPlayers(players);

        game.setLowestBet(settings.getBet());
        game.setHoldemPlayers(players);
        game.setCurrentBet(settings.getBet());
        game.setTotalRoundBet(settings.getBet());


        while (true) {

            // старт игры 1
            game.setDeck(ge.createAndShuffleDeck());

            for (HoldemPlayer p: game.getHoldemPlayers()) {
                List<PlayingCard> cards = new LinkedList<>();
                cards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                cards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
            }

            // раунд переговоров 2
            debate();

            // флоп 3  - добавление карт на стол
            List<PlayingCard> tableCards = new LinkedList<>();
            tableCards.add(game.getDeck().get(0));
            game.getDeck().remove(0);
            tableCards.add(game.getDeck().get(0));
            game.getDeck().remove(0);
            tableCards.add(game.getDeck().get(0));
            game.getDeck().remove(0);

            game.setTableCards(tableCards);

            // раунд переговоров 4
            debate();

            // turn 5
            tableCards.add(game.getDeck().get(0));
            game.getDeck().remove(0);

            game.setTableCards(tableCards);

            // раунд переговоров 6
            debate();

            // reiver 7
            tableCards.add(game.getDeck().get(0));
            game.getDeck().remove(0);

            game.setTableCards(tableCards);

            // финальные раунд переговоров 8
            debate();

            int winnerId = ge.winnerPicker(game.getHoldemPlayers(), game.getTableCards());

            System.out.println("winner is " + game.getHoldemPlayers().get(winnerId).getLogin());
        }
    }

    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.initialize();
    }
}
