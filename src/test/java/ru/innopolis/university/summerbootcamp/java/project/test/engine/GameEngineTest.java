package ru.innopolis.university.summerbootcamp.java.project.test.engine;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.engine.GameEngine;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

import java.util.LinkedList;
import java.util.List;

public class GameEngineTest {

    @Test
    public void changeDealer(){
        // test
    }

    public boolean areDecksSame(List<PlayingCard> deck1, List<PlayingCard> deck2) {
        if (deck1.size() != deck2.size())
            return false;

        for (int i = 0; i < deck1.size(); i++) {
            if (deck1.get(i).getSuit() != deck2.get(i).getSuit() ||
                deck1.get(i).getValue() != deck2.get(i).getValue()
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

}
