package ru.innopolis.university.summerbootcamp.java.project.test.engine;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.Rank;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.Suit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by iskandar on 17/07/16.
 */
public class CheckerTest {
    @Test
    public void deckCheckerTets() {
        // aces
        PlayingCard aceOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.ACE.getValue());
        PlayingCard aceOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.ACE.getValue());
        PlayingCard aceOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.ACE.getValue());
        PlayingCard aceOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.ACE.getValue());

        // kings
        PlayingCard kingOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.KING.getValue());
        PlayingCard kingOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.KING.getValue());
        PlayingCard kingOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.KING.getValue());
        PlayingCard kingOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.KING.getValue());

        // queens
        PlayingCard queenOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.QUEEN.getValue());
        PlayingCard queenOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.QUEEN.getValue());
        PlayingCard queenOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.QUEEN.getValue());
        PlayingCard queenOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.QUEEN.getValue());

        // jacks
        PlayingCard jackOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.JACK.getValue());
        PlayingCard jackOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.JACK.getValue());
        PlayingCard jackOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.JACK.getValue());
        PlayingCard jackOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.JACK.getValue());

        // tens
        PlayingCard tenOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.TEN.getValue());
        PlayingCard tenOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.TEN.getValue());
        PlayingCard tenOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.TEN.getValue());
        PlayingCard tenOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.TEN.getValue());

        // nines
        PlayingCard nineOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.NINE.getValue());
        PlayingCard nineOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.NINE.getValue());
        PlayingCard nineOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.NINE.getValue());
        PlayingCard nineOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.NINE.getValue());

        // eights
        PlayingCard eightOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.EIGHT.getValue());
        PlayingCard eightOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.EIGHT.getValue());
        PlayingCard eightOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.EIGHT.getValue());
        PlayingCard eightOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.EIGHT.getValue());

        // sevens
        PlayingCard sevenOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.SEVEN.getValue());
        PlayingCard sevenOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.SEVEN.getValue());
        PlayingCard sevenOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.SEVEN.getValue());
        PlayingCard sevenOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.SEVEN.getValue());

        // sixes
        PlayingCard sixOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.SIX.getValue());
        PlayingCard sixOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.SIX.getValue());
        PlayingCard sixOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.SIX.getValue());
        PlayingCard sixOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.SIX.getValue());

        // fives
        PlayingCard fiveOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.FIVE.getValue());
        PlayingCard fiveOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.FIVE.getValue());
        PlayingCard fiveOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.FIVE.getValue());
        PlayingCard fiveOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.FIVE.getValue());

        // fours
        PlayingCard fourOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.FOUR.getValue());
        PlayingCard fourOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.FOUR.getValue());
        PlayingCard fourOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.FOUR.getValue());
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.FOUR.getValue());

        // threes
        PlayingCard threeOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.THREE.getValue());
        PlayingCard threeOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.THREE.getValue());
        PlayingCard threeOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.THREE.getValue());
        PlayingCard threeOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.THREE.getValue());

        // twos
        PlayingCard twoOfSpades = new PlayingCard(Suit.Spades.getValue(), Rank.TWO.getValue());
        PlayingCard twoOfHarts = new PlayingCard(Suit.Hearts.getValue(), Rank.TWO.getValue());
        PlayingCard twoOfClubs = new PlayingCard(Suit.Clubs.getValue(), Rank.TWO.getValue());
        PlayingCard twoOfDiamonds = new PlayingCard(Suit.Diamonds.getValue(), Rank.TWO.getValue());

        // decks

        List<PlayingCard> flushRoyal = new LinkedList<>();
        flushRoyal.add(tenOfClubs);
        flushRoyal.add(jackOfClubs);
        flushRoyal.add(queenOfClubs);
        flushRoyal.add(kingOfClubs);
        flushRoyal.add(aceOfClubs);

        List<PlayingCard> straightFlush = new LinkedList<>();
        straightFlush.add(twoOfClubs);
        straightFlush.add(threeOfClubs);
        straightFlush.add(fourOfClubs);
        straightFlush.add(fiveOfClubs);
        straightFlush.add(sixOfClubs);

        List<PlayingCard> fourOfKind = new LinkedList<>();
        fourOfKind.add(aceOfClubs);
        fourOfKind.add(aceOfDiamonds);
        fourOfKind.add(aceOfHarts);
        fourOfKind.add(aceOfSpades);
        fourOfKind.add(twoOfClubs);

        List<PlayingCard> fullHouse = new LinkedList<>();
        fullHouse.add(twoOfDiamonds);
        fullHouse.add(twoOfClubs);
        fullHouse.add(twoOfHarts);
        fullHouse.add(threeOfDiamonds);
        fullHouse.add(threeOfClubs);

        List<PlayingCard> flush = new LinkedList<>();
        flush.add(twoOfClubs);
        flush.add(threeOfClubs);
        flush.add(fiveOfClubs);
        flush.add(sevenOfClubs);
        flush.add(jackOfClubs);

        List<PlayingCard> straight = new LinkedList<>();
        straight.add(twoOfClubs);
        straight.add(threeOfDiamonds);
        straight.add(fourOfSpades);
        straight.add(fiveOfHarts);
        straight.add(sixOfHarts);

        List<PlayingCard> threeOfKind = new LinkedList<>();
        straight.add(aceOfClubs);
        straight.add(aceOfDiamonds);
        straight.add(aceOfHarts);
        straight.add(twoOfClubs);
        straight.add(fiveOfClubs);

        List<PlayingCard> twoPair = new LinkedList<>();
        straight.add(aceOfClubs);
        straight.add(aceOfDiamonds);
        straight.add(kingOfClubs);
        straight.add(kingOfDiamonds);
        straight.add(threeOfClubs);

        List<PlayingCard> onePair = new LinkedList<>();
        straight.add(kingOfClubs);
        straight.add(kingOfDiamonds);
        straight.add(aceOfClubs);
        straight.add(twoOfClubs);
        straight.add(threeOfClubs);

        // TODO: implement hands compare logic
    }
}
