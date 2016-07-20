package ru.innopolis.university.summerbootcamp.java.project.engine;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.utils.Constants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameEngineTest {
    @Test
    public void winnerPickerTest() {
        GameEngine ge = new GameEngine();

        HoldemPlayer player1 = new HoldemPlayer();
        player1.setPlayingCards(Constants.getFlushRoyal());

        HoldemPlayer player2 = new HoldemPlayer();
        player2.setPlayingCards(Constants.getOnePair());

        HoldemPlayer player3 = new HoldemPlayer();
        player3.setPlayingCards(Constants.getFlush());

        HoldemPlayer player4 = new HoldemPlayer();
        player4.setPlayingCards(Constants.getFourOfKind());

        HoldemPlayer player5 = new HoldemPlayer();
        player5.setPlayingCards(Constants.getHighestCard());

        LinkedList<HoldemPlayer> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);
        int winner = ge.winnerPicker(playerList);

        Assert.assertEquals("Winner picker function return rwong value", winner, 0);

        playerList = new LinkedList<>();
        playerList.add(player2);
        playerList.add(player1);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);
        winner = ge.winnerPicker(playerList);

        Assert.assertEquals("Winner picker function return rwong value", winner, 1);

        playerList = new LinkedList<>();
        playerList.add(player3);
        playerList.add(player2);
        playerList.add(player1);
        playerList.add(player4);
        playerList.add(player5);
        winner = ge.winnerPicker(playerList);

        Assert.assertEquals("Winner picker function return rwong value", winner, 2);

        playerList = new LinkedList<>();
        playerList.add(player4);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player1);
        playerList.add(player5);
        winner = ge.winnerPicker(playerList);

        Assert.assertEquals("Winner picker function return rwong value", winner, 3);

        playerList = new LinkedList<>();
        playerList.add(player5);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player1);
        winner = ge.winnerPicker(playerList);

        Assert.assertEquals("Winner picker function return rwong value", winner, 4);

    }

//
//    public void deckEmptinessTest(List<PlayingCard> deck) {
//        Assert.assertTrue("Created deck is zero sized", deck.size() > 0);
//    }
//
//    @Test
//    public void changeDealer(){
//        // test
//    }
//
//    public boolean areDecksSame(List<PlayingCard> deck1, List<PlayingCard> deck2) {
//        if (deck1.size() != deck2.size())
//            return false;
//
//        for (int i = 0; i < deck1.size(); i++) {
//            if (deck1.get(i).getSuit() != deck2.get(i).getSuit() ||
//                deck1.get(i).getRank() != deck2.get(i).getRank()
//            ) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Test
//    public void createShuffledDeck() {
//        GameEngine engine = new GameEngine();
//        List<PlayingCard> cards = engine.createAndShuffleDeck();
//        Assert.assertFalse("Created deck is zero sized", cards.size() == 0);
//
//        LinkedList<List<PlayingCard>> decks = new LinkedList<>();
//
//        for (int i = 0; i < 5; i++) {
//            decks.add(engine.createAndShuffleDeck());
//        }
//        Assert.assertFalse("All 5 random generated decks are equal", decks.stream().allMatch((p)-> areDecksSame(p, cards)));
//    }
//
//    @Test
//    /**
//     * create games with different number of players
//     */
//    public void createGameTest() {
//        List<HoldemPlayer> players = new ArrayList<>();
//        GameEngine ge = new GameEngine();
//
//        for (int i = 3; i < 8; i++) {
//            Game game = ge.createGame(players, i);
//            List<HoldemPlayer> returnedPlayers = game.getHoldemPlayers();
//            Assert.assertEquals("wrong number of players during game creation", returnedPlayers.size(), i);
//            List<PlayingCard> returnedCards = game.getPlayingCards();
//            deckEmptinessTest(returnedCards);
//        }
//
//    }
}
