package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.innopolis.university.summerbootcamp.java.project.ai.AIEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;
import ru.innopolis.university.summerbootcamp.java.project.ui.util.ViewUtil;

import java.util.*;

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
    private ImageView userCard1;

    @FXML
    private Button confirm;
    @FXML
    private Button fold;

    @FXML
    private Button call;

    @FXML
    private Button test;

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
    private Label bet2;

    private List<ImageView> chips;
    private List<ImageView> cards;
    private List<Label> bets;

    private Math mainApp;

    private AIEngine aiEngine = new AIEngine();


    public void setMainApp(Math mainApp) {
        this.mainApp = mainApp;
    }


    Game game = createGame(new HoldemPlayer(), 3);

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


        test.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changeRoles(game);
            }
        });


        fold.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nextRound();
            }
        });

        confirm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double value = rateSlider.getValue();
                HoldemPlayer user = game.getHoldemPlayers().get(0);
                user.setBet(user.getBet() + value);
            }
        });


        call.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double diff = game.getCurrentBet() - game.getUser().getBet();
                callBet(game.getUser(), diff);
                displayBets();
                disableControl();
                step();
            }
        });

        disableControl();

        rateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                callLabel.setText(String.format("%.2f", new_val));
            }
        });

        initGame();
        //startGame();

    }

    private void disableControl() {
        confirm.setDisable(true);
        check.setDisable(true);
        call.setDisable(true);
        fold.setDisable(true);
        rateSlider.setDisable(true);
    }


    public Game createGame(HoldemPlayer user, int needPlayers) {
        int botCounter = 0;
        List<HoldemPlayer> players = new ArrayList<>();
        players.add(user);
        while (players.size() < needPlayers) {
            botCounter++;
            HoldemPlayer holdemPlayer = new HoldemPlayer();
            holdemPlayer.setLogin("Bot" + botCounter);
            holdemPlayer.setBot(true);
            players.add(holdemPlayer);
        }

        game = new Game();
        game.setLowestBet(100);
        game.setHoldemPlayers(players);
        game.setCurrentBet(100);
        game.setRoundBet(0);

        //Setting dealer and blinds
        game.getHoldemPlayers().get(0).setDealer(true);
        game.getHoldemPlayers().get(1).setSmallBlind(true);
        game.getHoldemPlayers().get(2).setBigBlind(true);
        game.setCurrentPlayer(2 + 1);

        return game;
    }


    public List<PlayingCard> createAndShuffleDeck() {
        LinkedList<PlayingCard> playingCards = new LinkedList<>();
        final Random random = new Random();
        int counter = random.nextInt(40);
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 13; j++)
                playingCards.add(new PlayingCard(i, j));
        for (int i = 0; i < counter; i++)
            Collections.shuffle(playingCards);
        return playingCards;
    }


    public void initGame() {
        //TODO: check num of players
        settingDeck();
        distributePlayingCards();
        showUserCard();
        settingBets();
        displayBets();
        step();
    }

    private void step() {
        HoldemPlayer p;
        do {
            p = game.nextPlayer();
            if (p.isBot()) {
                if (game.getCurrentBet() > p.getBet()) {
                    //если текущая ставка больше чем его, то добавляем
                    double count = game.getCurrentBet() - p.getBet();
                    callBet(p, count);
                    displayBets();
                }
            } else {
                // передаем управление пользователю
                enableUserControl();
                break;
            }
            if (p.isBigBlind() && p.getBet() == game.getCurrentBet()) {
                //обнуляем ставки
                countRoundBets();
                resetBets();
                displayBets();

                setCurrentPlayer();
                flop();
                //заканчиваем раунд
                break;
            }
        } while (true);
    }

    private void setCurrentPlayer() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            if (game.getHoldemPlayers().get(i).isBigBlind()) {
                game.setCurrentPlayer(i + 1);
            }
        }
    }

    private void countRoundBets() {
        int roundTotalBet = 0;
        for (HoldemPlayer player : game.getHoldemPlayers()) {
            roundTotalBet += player.getBet();
        }
        game.setRoundBet(game.getRoundBet() + roundTotalBet);
    }

    private void flop() {
        game.setTableCards(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            //3 карты для флопа
            game.getTableCards().add(takeCard());
            showTableCard();
        }
        step();
    }

    private void showTableCard() {
        for (int i = 0; i < game.getTableCards().size(); i++) {
            PlayingCard playingCard = game.getTableCards().get(i);
            cards.get(i).setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getPlayingCardImageUrlByValue(playingCard)).toExternalForm()));
        }
    }

    private void callBet(HoldemPlayer p, double count) {
        p.setBet(p.getBet() + count);
        p.setCash(p.getCash() - count);
    }


    public void settingBets() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            HoldemPlayer holdemPlayer = game.getHoldemPlayers().get(i);
            if (holdemPlayer.isSmallBlind()) {
                holdemPlayer.setBet(game.getLowestBet() / 2.0);
            } else if (holdemPlayer.isBigBlind()) {
                holdemPlayer.setBet(game.getLowestBet());
            }
        }
    }


    //TODO: refactor it
    public void changeDealer(List<HoldemPlayer> holdemPlayers, int number, boolean value) {
        holdemPlayers.get(number).setDealer(value);
        if (value) {
            chips.get(number).setImage(new Image(getClass().getClassLoader().getResource("ui/d.jpeg").toExternalForm()));
        } else {
            chips.get(number).setImage(null);
        }
    }

    public void changeBigBlind(List<HoldemPlayer> holdemPlayers, int number, boolean value) {
        holdemPlayers.get(number).setBigBlind(value);
        if (value) {
            chips.get(number).setImage(new Image(getClass().getClassLoader().getResource("ui/bb.jpg").toExternalForm()));
        } else {
            chips.get(number).setImage(null);
        }
    }

    public void changeSmallBlind(List<HoldemPlayer> holdemPlayers, int number, boolean value) {
        holdemPlayers.get(number).setSmallBlind(value);
        if (value) {
            chips.get(number).setImage(new Image(getClass().getClassLoader().getResource("ui/sb.jpg").toExternalForm()));
        } else {
            chips.get(number).setImage(null);
        }
    }

    /**
     * Change dealer and blinds actors in a game
     *
     * @param game
     */
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
            //Giveaway cards

            for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
                HoldemPlayer user = game.getHoldemPlayers().get(i);
                PlayingCard playingCard = takeCard();
                user.getPlayingCards().add(playingCard);
                playingCard = takeCard();
                user.getPlayingCards().add(playingCard);
            }
            showUserCard();

            //Bet round
            bettingRound(2);


            //TODO: STOP HERE


        }
        showUserCard();

    }


    private void bettingRound(int startPlayer) {
        if (startPlayer == game.getHoldemPlayers().size() - 1) {
            startPlayer = 0;
        }
        for (int i = startPlayer; i < game.getHoldemPlayers().size(); i++) {
            if (game.getHoldemPlayers().get(i).isBot()) {
                // FIXME: 19.07.2016 Bet sum and cash
                CommandType decision = aiEngine.getDecision(game.getHoldemPlayers().get(i).getPlayingCards(), 0, 0);
                //AI engine
                if (game.getCurrentBet() > game.getHoldemPlayers().get(i).getBet()) {
                    double diff = game.getCurrentBet() - game.getHoldemPlayers().get(i).getBet();
                    game.getHoldemPlayers().get(i).setBet(game.getHoldemPlayers().get(i).getBet() + diff);
                    game.getHoldemPlayers().get(i).setCash(game.getHoldemPlayers().get(i).getCash() - diff);
                    refreshBet(i, game.getHoldemPlayers().get(i).getBet());
                }
            } else {
                //Give control to user
                enableUserControl();
            }
        }


    }

    private void showUserCard() {
        HoldemPlayer user = game.getHoldemPlayers().get(0);
        PlayingCard card1 = user.getPlayingCards().get(0);
        PlayingCard card2 = user.getPlayingCards().get(1);
        userCard1.setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getPlayingCardImageUrlByValue(card1)).toExternalForm()));
        userCard2.setImage(new Image(getClass().getClassLoader().getResource(ViewUtil.getPlayingCardImageUrlByValue(card2)).toExternalForm()));
    }


    private PlayingCard takeCard() {
        return game.getDeck().remove(0);
    }

    private void refreshBet(int userNumber, double value) {
        bets.get(userNumber).setText(value + "");
    }

    private void enableUserControl() {
        //если сумма не ровна то добираем или увеличиваем ставку
        if (game.getCurrentBet() == game.getUser().getBet()) {
            check.setDisable(false);
        } else {
            call.setDisable(false);
        }
        confirm.setDisable(false);
        fold.setDisable(false);
        rateSlider.setDisable(false);
    }

    public void nextRound() {
        changeRoles(game);
        resetBets();
        settingBets();
        removeCards();
        settingDeck();
        startGame();
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


    private void afterUserAction() {

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

    private void displayBets() {
        for (int i = 0; i < game.getHoldemPlayers().size(); i++) {
            bets.get(i).setText(game.getHoldemPlayers().get(i).getBet() + "");
        }
        roundBet.setText(game.getRoundBet() + "");
    }
}
