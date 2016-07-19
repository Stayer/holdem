package ru.innopolis.university.summerbootcamp.java.project.engine;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.Player;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameEngineTest {

    public void deckEmptinessTest(List<PlayingCard> deck) {
        Assert.assertTrue("Created deck is zero sized", deck.size() > 0);
    }

    @Test
    public void changeDealer(){

    }

    public boolean areDecksSame(List<PlayingCard> deck1, List<PlayingCard> deck2) {
        if (deck1.size() != deck2.size())
            return false;

        for (int i = 0; i < deck1.size(); i++) {
            if (deck1.get(i).getSuit() != deck2.get(i).getSuit() ||
                deck1.get(i).getRank() != deck2.get(i).getRank()
            ) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void createShuffledDeck() {
        GameEngine engine = new GameEngine();
        List<PlayingCard> cards = engine.createAndShuffleDeck();
        Assert.assertFalse("Created deck is zero sized", cards.size() == 0);

        LinkedList<List<PlayingCard>> decks = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            decks.add(engine.createAndShuffleDeck());
        }
        Assert.assertFalse("All 5 random generated decks are equal", decks.stream().allMatch((p)-> areDecksSame(p, cards)));
    }

    /**
     * create games with different number of players
     */
    @Test
    public void createGameTest() {
        List<HoldemPlayer> players = new ArrayList<>();
        GameEngine ge = new GameEngine();

        for (int i = 3; i < 8; i++) {
            Game game = ge.createGame(players, i);
            List<HoldemPlayer> returnedPlayers = game.getHoldemPlayers();
            Assert.assertEquals("wrong number of players during game creation", returnedPlayers.size(), i);
            List<PlayingCard> returnedCards = game.getPlayingCards();
            deckEmptinessTest(returnedCards);
        }
    }

    /**
     * Creates test game and checks if dealer and blind are set correctly.
     */
    @Test
    public void gameInitTest() {
        GameEngine engine = new GameEngine();
        Game game = new Game();
        game.setGameStage(GameStage.Round1);
        game.setPlayingCards(engine.createAndShuffleDeck());
        LinkedList<HoldemPlayer> players = new LinkedList<>();
        HoldemPlayer p1 = new HoldemPlayer();
        HoldemPlayer p2 = new HoldemPlayer();
        HoldemPlayer p3 = new HoldemPlayer();
        HoldemPlayer p4 = new HoldemPlayer();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        game.setHoldemPlayers(players);
        engine.initGame(game);

        Assert.assertTrue(game.getHoldemPlayers().get(0).isDealer());
        Assert.assertTrue(game.getHoldemPlayers().get(1).isSmallBlind());
        Assert.assertTrue(game.getHoldemPlayers().get(2).isBigBlind());
    }
}
