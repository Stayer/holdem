package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ru.innopolis.university.summerbootcamp.java.project.ai.AIEngine;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.*;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;
import ru.innopolis.university.summerbootcamp.java.project.ui.util.ViewUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {

    @FXML
    private Label roundBet;

    @FXML
    private ImageView firstCard;
    @FXML
    private ImageView secondCard;
    @FXML
    private ImageView thirdCard;
    @FXML
    private ImageView fourthCard;
    @FXML
    private ImageView fithCard;
    @FXML
    private ImageView userCard2;

    @FXML
    private ImageView player2card2;
    @FXML
    private ImageView player2card1;

    @FXML
    private ImageView player1card2;
    @FXML
    private ImageView player1card1;

    @FXML
    private ImageView userCard1;

    private List<ImageView> userCardIView;

    @FXML
    private Button confirm;
    @FXML
    private Button fold;

    @FXML
    private Button call;

    @FXML
    private Button test;
    @FXML
    private Button back;

    @FXML
    private Button check;

    @FXML
    private Label callLabel;

    @FXML
    private Slider rateSlider;
    @FXML
    private ImageView chip0;
    @FXML
    private ImageView chip1;
    @FXML
    private ImageView chip2;

    @FXML
    private Label bet0;

    @FXML
    private Label bet1;

    @FXML
    private Label lbBot1;
    @FXML
    private Label lbBot2;
    @FXML
    private Label lbUserName;
    @FXML
    private Label CashBot1;
    @FXML
    private Label CashBot2;
    @FXML
    private Label CashMe;
    @FXML
    private Button nextRound;

    @FXML
    private Label bet2;

    private List<ImageView> chips;
    private List<ImageView> cards;
    private List<Label> bets;
    private List<Label> names;
    private List<Label> cashes;

    private AIEngine aiEngine = new AIEngine();

    private List<List<ImageView>> playersHandCards;

    // Game logics 22.07.2016
    public Game game = new Game();
    public int gameStage = GameStage.Start.getValue();
    public int dealerIndex;

    private SettingsServices settingsServices = SettingsServices.getInstance();
    // end of Game logics

    @FXML
    private void initialize() {
        Image image = new Image(getClass().getClassLoader().getResource("card_place_holder_background.png").toExternalForm());
        firstCard.setImage(image);
        secondCard.setImage(image);
        thirdCard.setImage(image);
        fourthCard.setImage(image);
        fithCard.setImage(image);
        callLabel.setText("0");
        chips = new ArrayList<>();
        chips.add(chip0);
        chips.add(chip1);
        chips.add(chip2);

        cards = new ArrayList<>();
        cards.add(firstCard);
        cards.add(secondCard);
        cards.add(thirdCard);
        cards.add(fourthCard);
        cards.add(fithCard);

        bets = new ArrayList<>();
        bets.add(bet0);
        bets.add(bet1);
        bets.add(bet2);

        names = new ArrayList<>();
        names.add(lbUserName);
        names.add(lbBot1);
        names.add(lbBot2);

        cashes = new ArrayList<>();
        cashes.add(CashMe);
        cashes.add(CashBot1);
        cashes.add(CashBot2);

        playersHandCards = new ArrayList<>();

        userCardIView = new ArrayList<>();
        userCardIView.add(userCard1);
        userCardIView.add(userCard2);


        List<ImageView> firstUserCardView = new ArrayList<>();
        firstUserCardView.add(player1card1);
        firstUserCardView.add(player1card2);

        List<ImageView> secondUserCardView = new ArrayList<>();
        secondUserCardView.add(player2card1);
        secondUserCardView.add(player2card2);


        playersHandCards.add(userCardIView);
        playersHandCards.add(firstUserCardView);
        playersHandCards.add(secondUserCardView);


        fold.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                buttonClick = 1;
                roundGenerator();
            }
        });

        confirm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int value = (int) rateSlider.getValue();
                game.getUser().setBet(value);
                buttonClick = 2;
                roundGenerator();

   //             makeBet(user, value);
   //             game.setCurrentBet(user.getBet());
   //             game.setCurrentCash(user.getCash());
   //             showBets();
   //             displayCashes();
   //             step();
            }
        });

        nextRound.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                roundGenerator();
    //            nextRound.setDisable(true);
    //            resetRound();
    //            nextRound();
    //            game.setGameStage(nextGameStage(game.getGameStage()));
    //            step();
            }
        });

        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
                Parent roott = null;
                Stage stage = (Stage) back.getScene().getWindow();

                try {
                    roott = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainMenuController personController = loader.getController();
                personController.setTextToLabel();
                ui.Cash = settingsServices.findOne(game.getUser().getLogin()).getCash();
                personController.setCashToLabel();
                //        create a new scene with root and set the stage
                Scene scene = new Scene(roott);
                stage.setScene(scene);
                stage.show();
            }
        });


        call.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int value = (int) rateSlider.getValue();
                int diff = game.getCurrentBet() - game.getUser().getBet();
                game.getUser().setBet(diff);
                buttonClick = 2;
                roundGenerator();
            }
        });

        check.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingsServices.findOne(game.getUser().getLogin()).setCash((int)game.getUser().getCash());
                buttonClick = 3;
                roundGenerator();
            }
        });
        // Game Logics 22.07.2016

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

        // END OF GAME LOGICS

    }

    // dalv666

    private void showPlayerCard(int id, double opacity) {
        HoldemPlayer holdemPlayer = game.getHoldemPlayers().get(id);
        for (int j = 0; j < 2; j++) {
            PlayingCard card = holdemPlayer.getPlayingCards().get(j);
            playersHandCards.get(id).get(j).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getPlayingCardImageUrlByValue(card)).toExternalForm()));
            playersHandCards.get(id).get(j).setStyle("-fx-opacity: " + opacity + ";");

        }
    }

    private void hidePlayerCard(int id, double opacity) {
        for (int j = 0; j < 2; j++) {
            playersHandCards.get(id).get(j).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getBackCardImage()).toExternalForm()));
            playersHandCards.get(id).get(j).setStyle("-fx-opacity: " + opacity + ";");

        }
    }
    private void showPlayerCard(int id) {
        showPlayerCard(id, 1.0);
    }


    private void hidePlayerCard(int id) {
        hidePlayerCard(id, 1.0);
    }

    private int showWinner() {
        int winner = GameEngine.winnerPicker(game.getHoldemPlayers());
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            if (i != winner) {
                showPlayerCard(i, 0.1);
                continue;
            }
            showPlayerCard(i);
        }
        return winner;
    }
    private void showBets() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            bets.get(i).setText(game.getHoldemPlayers().get(i).getBet() + "");
        }
    }

    private void displayCashes() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            cashes.get(i).setText(game.getHoldemPlayers().get(i).getCash() + "");
        }
    }

    private void displayNames() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            names.get(i).setText(game.getHoldemPlayers().get(i).getLogin() + "");
        }
    }

    private void cleanTableCards() {
        for (int i = 0; i < game.getTableCards().size(); i++) {
            PlayingCard playingCard = game.getTableCards().get(i);
            cards.get(i).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getBackCardImage()).toExternalForm()));
        }
    }


    private void displayRoundBet() {
        roundBet.setText(game.getTotalRoundBet() + "");
    }

    // end dalv666

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
    public HoldemPlayer getSmallBlindPlayer() {return game.getHoldemPlayers().stream().filter((p) -> Objects.equals(p.isSmallBlind(), true)).findFirst().orElse(null);}
    public HoldemPlayer getBigBlindPlayer() {return game.getHoldemPlayers().stream().filter((p) -> Objects.equals(p.isBigBlind(), true)).findFirst().orElse(null);}
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
        gameStage = 0;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        return Integer.parseInt(scanner.nextLine());
    }
    public int buttonClick;
    public int debate(int buttonClick, int value) {
        int roundBet = 0;
        int index = dealerIndex + 1;
        AIEngine ai = new AIEngine();
        for (HoldemPlayer p: game.getHoldemPlayers()) {
            if (!p.isBot() && p.isInGame()) {
                switch (buttonClick) {
                    case 1: // выводим бота из игры до следующего раунда
                        System.out.println("EXIT");
                        p.setInGame(false);
                        break;

                    case 2: // подняли ставку и обновиди данные игрока и стола
                        int bet = scan("укажите ставку");

                        game.setTableCash(game.getTableCash() + bet);
                        p.setCash(p.getCash() - bet);
                        game.setCurrentBet(bet);
                        break;

                    case 3: // поддержали и обновили данные стола
                        game.setTableCash(game.getTableCash() + game.getCurrentBet());
                        p.setCash(p.getCash() - game.getCurrentBet());
                        break;
                }
            } else if (p.isInGame()) {
                List<PlayingCard> cards = Stream.concat(p.getPlayingCards().stream(), game.getTableCards().stream()).collect(Collectors.toList());

                AiDecision aiDecision = ai.getDecision(cards, p.getCash(), game.getCurrentBet());
                reactToDecision(aiDecision, game.getHoldemPlayers().indexOf(p));

                System.out.println(aiDecision.getCommand().toString());
            }

            if (roundBet == 0 && roundBet < game.getCurrentBet()) {
                roundBet = game.getCurrentBet();
            }
        }

        if (roundBet < game.getCurrentBet()) {
            return -1;
        } else {
            return 1;
        }
    }
    public void roundGenerator() {
        GameEngine ge = new GameEngine();
        List<PlayingCard> tableCards = new LinkedList<>();
        switch (gameStage) {
            case 0:
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
                System.out.println("прошел старт игры");
                gameStage++;
                break;
            case 1:
                // раунд переговоров 2
                if(debate(buttonClick, game.getUser().getBet()) > 0) {
                    System.out.println("прошел первый раунд дебатов");
                    gameStage++;
                }
                break;
            case 2:
                // флоп 3  - добавление карт на стол
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                game.setTableCards(tableCards);
                System.out.println("флоп");
                gameStage++;
                break;
            case 3:
                // раунд переговоров 4
                if(debate(buttonClick, game.getUser().getBet()) > 0) {
                    System.out.println("прошел второй раунд дебатов");
                    gameStage++;
                }
                break;
            case 4:
                // turn 5
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                game.setTableCards(tableCards);
                System.out.println("тёрн");
                gameStage++;
                break;
            case 5:
                // раунд переговоров 6
                if(debate(buttonClick, game.getUser().getBet()) > 0) {
                    System.out.println("прошел третий раунд дебатов");
                    gameStage++;
                }
                break;
            case 6: // river 7
                tableCards.add(game.getDeck().get(0));
                game.getDeck().remove(0);
                game.setTableCards(tableCards);
                System.out.println("ривер");
                gameStage++;
                break;
            case 7:
                // раунд переговоров 8
                if(debate(buttonClick, game.getUser().getBet()) > 0) {
                    System.out.println("финальные ставки");
                    gameStage++;
                }
                break;
            case 8:
                int winnerId = ge.winnerPicker(game.getHoldemPlayers(), game.getTableCards());
                recalculateScores(winnerId, game.getTableCash());
                System.out.println("winner is " + game.getHoldemPlayers().get(winnerId).getLogin());
                break;
            case 9:
                clearGame();
                break;
            default:
                break;
        }
        if(Controller.emptyGame(game.getHoldemPlayers()))
            gameStage = 8;
            roundGenerator();
    }
    // end of Game Logics 22.07.2016
}


















































/*

    private void disableControl() {
        confirm.setDisable(true);
        check.setDisable(true);
        call.setDisable(true);
        fold.setDisable(true);
        rateSlider.setDisable(true);
    }


    public void initGame() {
        game.setGameStage(GameStage.Start);
    //    TODO: check num of players
        settingDeck();
        distributePlayingCards();
        game.setGameStage(GameStage.Preflop);
        showUserCard();
        settingBets();
        showBets();
        displayNames();
        displayCashes();
        nextRound.setDisable(true);
        game.setGameStage(GameStage.Round1);
        step();
    }

    private void step() {
        HoldemPlayer p;
        do {
            p = game.nextPlayer();
            if (p.isBot()) {
                if (game.getCurrentBet() > p.getBet()) {
             //       если текущая ставка больше чем его, то добавляем
                    int count = game.getCurrentBet() - p.getBet();
                    makeBet(p, count);
                    showBets();
                }
            } else {
              //  передаем управление пользователю
                enableUserControl();
                break;
            }
            if (p.isBigBlind() && p.getBet() == game.getCurrentBet()) {
            //    следующий кон
           //     обнуляем ставки
                runNextRound();
           //    заканчиваем раунд
                break;
            }
        } while (true);
    }

    private void runNextRound() {
        GameStage gameStage = nextGameStage(game.getGameStage());
        game.setGameStage(gameStage);


        countAndDisplayRoundBets();
        resetBets();
        showBets();

        setCurrentPlayer();

        switch (game.getGameStage()) {
            case Flop:
                flop();
                break;
            case Tern:
                tern();
                break;
            case Riever:
                riever();
                break;
            case Final:
                int winner = showWinner();
                getPrize(winner);

                enableNextGame();
        }


        Settings settings = settingsServices.findOne(ui.Name);
        settings.setCash(ui.Cash);
        settingsServices.save(settings);
    }

    private void enableNextGame() {
        disableControl();
        nextRound.setDisable(false);

    }


    private void resetRound() {
        game.setGameStage(GameStage.Preflop);
        game.setWinPoint(0);
        game.setCurrentBet(0);
    }

    private void getPrize(int winner) {
        HoldemPlayer win = game.getHoldemPlayers().get(winner);
        win.setCash(win.getCash() + game.getWinPoint());
    }

    private int showWinner() {
        int winner = GameEngine.winnerPicker(game.getHoldemPlayers());
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            if (i != winner) {
                showPlayerCard(i, 0.1);
                continue;
            }
            showPlayerCard(i);
        }
        return winner;
    }


    private void showPlayerCard(int id) {
        showPlayerCard(id, 1.0);
    }


    private void hidePlayerCard(int id) {
        hidePlayerCard(id, 1.0);
    }


    private void showPlayerCard(int id, double opacity) {
        HoldemPlayer holdemPlayer = game.getHoldemPlayers().get(id);
        for (int j = 0; j < 2; j++) {
            PlayingCard card = holdemPlayer.getPlayingCards().get(j);
            playersHandCards.get(id).get(j).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getPlayingCardImageUrlByValue(card)).toExternalForm()));
            playersHandCards.get(id).get(j).setStyle("-fx-opacity: " + opacity + ";");

        }
    }

    private void hidePlayerCard(int id, double opacity) {
        for (int j = 0; j < 2; j++) {
            playersHandCards.get(id).get(j).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getBackCardImage()).toExternalForm()));
            playersHandCards.get(id).get(j).setStyle("-fx-opacity: " + opacity + ";");

        }
    }


    private GameStage nextGameStage(GameStage start) {
        for (GameStage st : GameStage.values()) {
            if (st.compareTo(start) > 0) {
                return st;
            }
        }
        return GameStage.Start;
    }

    private void tern() {
   //     1 карта для терна
        game.getTableCards().add(takeCard());
        showTableCard();
   //     ставим ставки
        settingBets();
        showBets();
        game.setGameStage(nextGameStage(game.getGameStage()));
        step();
    }


    private void riever() {
     //   1 карта для ривера
        game.getTableCards().add(takeCard());
        showTableCard();
     //   ставим ставки
        settingBets();
        showBets();
        game.setGameStage(nextGameStage(game.getGameStage()));
        step();
    }

    private void setCurrentPlayer() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            if (game.getHoldemPlayers().get(i).isBigBlind()) {
                game.setCurrentPlayer(i + 1);
            }
        }
    }

    private void countAndDisplayRoundBets() {
        int roundTotalBet = 0;
        for (HoldemPlayer player : game.getHoldemPlayers()) {
            roundTotalBet += player.getBet();
        }
        roundBet.setText(game.getWinPoint() + roundTotalBet + " ");
        game.setWinPoint(game.getWinPoint() + roundTotalBet);
    }

    private void flop() {
        game.setTableCards(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
  //          3 карты для флопа
            game.getTableCards().add(takeCard());
            showTableCard();
        }
   //     ставим ставки
        settingBets();
        showBets();
        game.setGameStage(nextGameStage(game.getGameStage()));
        step();
    }

    private void showTableCard() {
        for (int i = 0; i < game.getTableCards().size(); i++) {
            PlayingCard playingCard = game.getTableCards().get(i);
            cards.get(i).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getPlayingCardImageUrlByValue(playingCard)).toExternalForm()));
        }
    }

    private void makeBet(HoldemPlayer p, int count) {
        p.setBet(p.getBet() + count);
        p.setCash(p.getCash() - count);

        Settings settings =  settingsServices.findOne(game.getUser().getLogin());
        settings.setCash(game.getUser().getCash());
        settingsServices.save(settings);
    }


    public void settingBets() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            HoldemPlayer holdemPlayer = game.getHoldemPlayers().get(i);
            if (holdemPlayer.isSmallBlind()) {
                holdemPlayer.setBet((int) (game.getLowestBet() / 2.0));
            } else if (holdemPlayer.isBigBlind()) {
                holdemPlayer.setBet(game.getLowestBet());
            }
        }
        game.setCurrentBet(game.getLowestBet());
    }


   // TODO: refactor it
    public void changeDealer(List<HoldemPlayer> holdemPlayers, int number, boolean value) {
        holdemPlayers.get(number).setDealer(value);
        if (value) {
            chips.get(number).setImage(new Image(getClass().getClassLoader().getResource("ui/dealerChip.png").toExternalForm()));
        } else {
            chips.get(number).setImage(null);
        }
    }

    public void changeBigBlind(List<HoldemPlayer> holdemPlayers, int number, boolean value) {
        holdemPlayers.get(number).setBigBlind(value);
        if (value) {
            chips.get(number).setImage(new Image(getClass().getClassLoader().getResource("ui/bigBlindChip.png").toExternalForm()));
        } else {
            chips.get(number).setImage(null);
        }
    }

    public void changeSmallBlind(List<HoldemPlayer> holdemPlayers, int number, boolean value) {
        holdemPlayers.get(number).setSmallBlind(value);
        if (value) {
            chips.get(number).setImage(new Image(getClass().getClassLoader().getResource("ui/smallBlindChip.png").toExternalForm()));
        } else {
            chips.get(number).setImage(null);
        }
    }

    *//**
     * Change dealer and blinds actors in a game
     *
     * @param game
     *//*
    public void changeRoles(Game game) {
        List<HoldemPlayer> holdemPlayers = game.getHoldemPlayers();
        int nDealer = 0;
        int nSB = 0;
        int nBB = 0;


        for (int i = 0; i < holdemPlayers.size(); i++) {
            HoldemPlayer holdemPlayer = holdemPlayers.get(i);


            if (holdemPlayer.isBigBlind()) {
                changeBigBlind(holdemPlayers, i, false);
                if (i != holdemPlayers.size() - 1) {
                    nBB = i + 1;
                }
            } else if (holdemPlayer.isSmallBlind()) {
                changeSmallBlind(holdemPlayers, i, false);
                if (i != holdemPlayers.size() - 1) {
                    nSB = i + 1;
                }
            } else if (holdemPlayer.isDealer()) {
                changeDealer(holdemPlayers, i, false);
                if (i != holdemPlayers.size() - 1) {
                    nDealer = i + 1;
                }
            }


        }
        changeBigBlind(holdemPlayers, nBB, true);
        changeSmallBlind(holdemPlayers, nSB, true);
        changeDealer(holdemPlayers, nDealer, true);
        game.setCurrentPlayer(nBB + 1);
    }

    public void startGame() {
        game.setGameStage(GameStage.Start);
        if (game.getGameStage() == GameStage.Start) {
            game.setGameStage(GameStage.Preflop);
       //     Giveaway cards

            for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
                HoldemPlayer user = game.getHoldemPlayers().get(i);
                PlayingCard playingCard = takeCard();
                user.getPlayingCards().add(playingCard);
                playingCard = takeCard();
                user.getPlayingCards().add(playingCard);
            }
            showUserCard();

        //    Bet round
            bettingRound(2);


     //       TODO: STOP HERE


        }
        showUserCard();

    }

    private void bettingRound(int startPlayer) {
        if (startPlayer == game.getHoldemPlayers().size() - 1) {
            startPlayer = 0;
        }
        for (int i = startPlayer; i < game.getHoldemPlayers().size(); i++) {
            if (game.getHoldemPlayers().get(i).isBot()) {
            //    FIXME: 19.07.2016 Bet sum and cash
           //     CommandType decision = aiEngine.getDecision(game.getHoldemPlayers().get(i).getPlayingCards(), 0, 0);
             //   AI engine
                if (game.getCurrentBet() > game.getHoldemPlayers().get(i).getBet()) {
                    int diff = game.getCurrentBet() - game.getHoldemPlayers().get(i).getBet();
                    game.getHoldemPlayers().get(i).setBet(game.getHoldemPlayers().get(i).getBet() + diff);
                    game.getHoldemPlayers().get(i).setCash(game.getHoldemPlayers().get(i).getCash() - diff);
                    refreshBet(i, game.getHoldemPlayers().get(i).getBet());
                }
            } else {
               // Give control to user
                enableUserControl();
            }
        }
    }

    private void showUserCard() {
        showPlayerCard(0);
    }

    private PlayingCard takeCard() {
        return game.getDeck().remove(0);
    }

    private void refreshBet(int userNumber, int value) {
        bets.get(userNumber).setText(value + "");
    }

    private void enableUserControl() {
      //  если сумма не ровна то добираем или увеличиваем ставку
        if (game.getCurrentBet() == game.getUser().getBet()) {
            check.setDisable(false);
        } else {
            call.setDisable(false);
        }
        confirm.setDisable(false);
        fold.setDisable(false);
        rateSlider.setDisable(false);


        // устанавливаем слайдер в минимальную ставку
        rateSlider.setMin(game.getTotalRoundBet());
        rateSlider.setMax(game.getUser().getCash());


    }

    public void nextRound() {
        Settings settings =  settingsServices.findOne(game.getUser().getLogin());
        settings.setCash((int)game.getUser().getCash());
        settingsServices.save(settings);

        changeRoles(game);
        resetBets();
        settingBets();
        showBets();
        removeCards();
        settingDeck();
        cleanTableCards();
        hidePlayersCards();
        distributePlayingCards();
        showUserCard();
    }

    private void hidePlayersCards() {
        for (int i = 1; i < game.getHoldemPlayers().size(); i++) {
            hidePlayerCard(i);
        }
    }

    private void settingDeck() {
        List<PlayingCard> deck = createAndShuffleDeck();
        game.setDeck(deck);
    }

    private void removeCards() {
        for (HoldemPlayer holdemPlayer : game.getHoldemPlayers()) {
            holdemPlayer.setPlayingCards(new ArrayList<>());
        }
    }

    private void resetBets() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            game.getHoldemPlayers().get(i).setBet(0);
        }
    }

    public void distributePlayingCards() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            HoldemPlayer user = game.getHoldemPlayers().get(i);
            PlayingCard playingCard = takeCard();
            user.getPlayingCards().add(playingCard);
            playingCard = takeCard();
            user.getPlayingCards().add(playingCard);
        }
    }

    private void showBets() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            bets.get(i).setText(game.getHoldemPlayers().get(i).getBet() + "");
        }
    }

    private void displayCashes() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            cashes.get(i).setText(game.getHoldemPlayers().get(i).getCash() + "");
        }
    }

    private void displayNames() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            names.get(i).setText(game.getHoldemPlayers().get(i).getLogin() + "");
        }
    }

    private void cleanTableCards() {
        for (int i = 0; i < game.getTableCards().size(); i++) {
            PlayingCard playingCard = game.getTableCards().get(i);
            cards.get(i).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getBackCardImage()).toExternalForm()));
        }
    }


    private void displayRoundBet() {
        roundBet.setText(game.getTotalRoundBet() + "");
    }

}*/
