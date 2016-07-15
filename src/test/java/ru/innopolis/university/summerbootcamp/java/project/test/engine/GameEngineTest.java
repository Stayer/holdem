package ru.innopolis.university.summerbootcamp.java.project.test.engine;

import org.junit.Test;
import org.junit.Assert;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class GameEngineTest {
    public void deckEmptynessTest(List<PlayingCard> deck) {
        Assert.assertTrue("deck is empty", deck.size() > 0);
    }

    @Test
    public void changeDealer(){
        // test
    }

    @Test
    /**
     * create games with different number of players
     */
    public void createGameTest() {
        List<HoldemPlayer> players = new ArrayList<>();
        GameEngine ge = new GameEngine();

        for (int i = 3; i < 8; i++) {
            Game game = ge.createGame(players, i);
            List<HoldemPlayer> returnedPlayers = game.getHoldemPlayers();
            Assert.assertEquals("wrong number of players during game creation", returnedPlayers.size(), i);
            List<PlayingCard> returnedCards = game.getPlayingCards();
            deckEmptynessTest(returnedCards);
        }

    }
}
