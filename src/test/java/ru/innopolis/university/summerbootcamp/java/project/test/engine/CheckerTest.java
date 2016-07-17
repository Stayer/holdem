package ru.innopolis.university.summerbootcamp.java.project.test.engine;

import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.Rank;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.Suit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by iskandar on 17/07/16.
 */
public class CheckerTest {
    @Test
    public void deckCheckerTets() {
        // aces
        PlayingCard aceOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("ACE").ordinal());
        PlayingCard aceOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("ACE").ordinal());
        PlayingCard aceOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("ACE").ordinal());
        PlayingCard aceOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("ACE").ordinal());

        // kings
        PlayingCard kingOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("KING").ordinal());
        PlayingCard kingOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("KING").ordinal());
        PlayingCard kingOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("KING").ordinal());
        PlayingCard kingOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("KING").ordinal());

        // queens
        PlayingCard queenOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("QUEEN").ordinal());
        PlayingCard queenOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("QUEEN").ordinal());
        PlayingCard queenOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("QUEEN").ordinal());
        PlayingCard queenOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("QUEEN").ordinal());

        // jacks
        PlayingCard jackOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("JACK").ordinal());
        PlayingCard jackOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("JACK").ordinal());
        PlayingCard jackOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("JACK").ordinal());
        PlayingCard jackOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("JACK").ordinal());

        // tens
        PlayingCard tenOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("TEN").ordinal());
        PlayingCard tenOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("TEN").ordinal());
        PlayingCard tenOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("TEN").ordinal());
        PlayingCard tenOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("TEN").ordinal());

        // nines
        PlayingCard nineOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("NINE").ordinal());
        PlayingCard nineOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("NINE").ordinal());
        PlayingCard nineOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("NINE").ordinal());
        PlayingCard nineOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("NINE").ordinal());

        // eights
        PlayingCard eightOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("EIGHT").ordinal());
        PlayingCard eightOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("EIGHT").ordinal());
        PlayingCard eightOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("EIGHT").ordinal());
        PlayingCard eightOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("EIGHT").ordinal());

        // sevens
        PlayingCard sevenOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("SEVEN").ordinal());
        PlayingCard sevenOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("SEVEN").ordinal());
        PlayingCard sevenOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("SEVEN").ordinal());
        PlayingCard sevenOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("SEVEN").ordinal());

        // sixes
        PlayingCard sixOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("SIX").ordinal());
        PlayingCard sixOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("SIX").ordinal());
        PlayingCard sixOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("SIX").ordinal());
        PlayingCard sixOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("SIX").ordinal());

        // fives
        PlayingCard fiveOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("FIVE").ordinal());
        PlayingCard fiveOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("FIVE").ordinal());
        PlayingCard fiveOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("FIVE").ordinal());
        PlayingCard fiveOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("FIVE").ordinal());

        // fours
        PlayingCard fourOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("FOUR").ordinal());
        PlayingCard fourOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("FOUR").ordinal());
        PlayingCard fourOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("FOUR").ordinal());
        PlayingCard fourOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("FOUR").ordinal());

        // threes
        PlayingCard threeOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("THREE").ordinal());
        PlayingCard threeOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("THREE").ordinal());
        PlayingCard threeOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("THREE").ordinal());
        PlayingCard threeOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("THREE").ordinal());

        // twos
        PlayingCard twoOfSpades = new PlayingCard(Suit.valueOf("Spades").ordinal(), Rank.valueOf("TWO").ordinal());
        PlayingCard twoOfHarts = new PlayingCard(Suit.valueOf("Hearts").ordinal(), Rank.valueOf("TWO").ordinal());
        PlayingCard twoOfClubs = new PlayingCard(Suit.valueOf("Clubs").ordinal(), Rank.valueOf("TWO").ordinal());
        PlayingCard twoOfDiamonds = new PlayingCard(Suit.valueOf("Diamonds").ordinal(), Rank.valueOf("TWO").ordinal());

        List<PlayingCard> flushRoyal = new LinkedList<>();
        flushRoyal.add(tenOfClubs);
        flushRoyal.add(jackOfClubs);
        flushRoyal.add(queenOfClubs);
        flushRoyal.add(kingOfClubs);
        flushRoyal.add(aceOfClubs);

        PlayingCard[] straightFlush = {twoOfClubs, threeOfClubs, fourOfClubs, fiveOfClubs, sixOfClubs};
        PlayingCard[] fourOfKind = {twoOfClubs, twoOfDiamonds, twoOfHarts, twoOfSpades, aceOfDiamonds};
        PlayingCard[] fullHouse = {twoOfClubs, twoOfDiamonds, twoOfHarts, threeOfClubs, threeOfDiamonds};
        PlayingCard[] flush = {twoOfClubs, threeOfClubs, fiveOfClubs, sevenOfClubs, jackOfClubs};
        PlayingCard[] straight = {twoOfClubs, threeOfDiamonds, fourOfSpades, fiveOfHarts, sixOfHarts};
        PlayingCard[] threeOfKind = {aceOfClubs, aceOfDiamonds, aceOfHarts, twoOfClubs, fiveOfClubs};
        PlayingCard[] twoPair = {aceOfClubs, aceOfDiamonds, kingOfClubs, kingOfHarts, threeOfClubs};
        PlayingCard[] onePair = {kingOfClubs, kingOfDiamonds, aceOfClubs, twoOfClubs, threeOfClubs};

        int result = Checker.checkCombo(flushRoyal);
        System.out.println(result);
    }
}
