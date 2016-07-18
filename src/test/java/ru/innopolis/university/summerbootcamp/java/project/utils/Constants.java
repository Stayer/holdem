package ru.innopolis.university.summerbootcamp.java.project.utils;

import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.Rank;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.Suit;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by iskandar on 17/07/16.
 */
public class Constants {
    public static final PlayingCard ACE_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.ACE.getValue());
    public static final PlayingCard ACE_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.ACE.getValue());
    public static final PlayingCard ACE_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.ACE.getValue());
    public static final PlayingCard ACE_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.ACE.getValue());

    // kings
    public static final PlayingCard KING_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.KING.getValue());
    public static final PlayingCard KING_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.KING.getValue());
    public static final PlayingCard KING_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.KING.getValue());
    public static final PlayingCard KING_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.KING.getValue());

    // queens
    public static final PlayingCard QUEEN_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.QUEEN.getValue());
    public static final PlayingCard QUEEN_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.QUEEN.getValue());
    public static final PlayingCard QUEEN_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.QUEEN.getValue());
    public static final PlayingCard QUEEN_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.QUEEN.getValue());

    // jacks
    public static final PlayingCard JACK_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.JACK.getValue());
    public static final PlayingCard JACK_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.JACK.getValue());
    public static final PlayingCard JACK_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.JACK.getValue());
    public static final PlayingCard JACK_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.JACK.getValue());

    // tens
    public static final PlayingCard TEN_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.TEN.getValue());
    public static final PlayingCard TEN_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.TEN.getValue());
    public static final PlayingCard TEN_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.TEN.getValue());
    public static final PlayingCard TEN_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.TEN.getValue());

    // nines
    public static final PlayingCard NINE_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.NINE.getValue());
    public static final PlayingCard NINE_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.NINE.getValue());
    public static final PlayingCard NINE_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.NINE.getValue());
    public static final PlayingCard NINE_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.NINE.getValue());

    // eights
    public static final PlayingCard EIGHT_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.EIGHT.getValue());
    public static final PlayingCard EIGHT_OF_HEART = new PlayingCard(Suit.Hearts.getValue(), Rank.EIGHT.getValue());
    public static final PlayingCard EIGHT_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.EIGHT.getValue());
    public static final PlayingCard EIGHT_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.EIGHT.getValue());

    // sevens
    public static final PlayingCard SEVEN_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.SEVEN.getValue());
    public static final PlayingCard SEVEN_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.SEVEN.getValue());
    public static final PlayingCard SEVEN_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.SEVEN.getValue());
    public static final PlayingCard SEVEN_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.SEVEN.getValue());

    // sixes
    public static final PlayingCard SIX_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.SIX.getValue());
    public static final PlayingCard SIX_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.SIX.getValue());
    public static final PlayingCard SIX_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.SIX.getValue());
    public static final PlayingCard SIX_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.SIX.getValue());

    // fives
    public static final PlayingCard FIVE_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.FIVE.getValue());
    public static final PlayingCard FIVE_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.FIVE.getValue());
    public static final PlayingCard FIVE_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.FIVE.getValue());
    public static final PlayingCard FIVE_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.FIVE.getValue());

    // fours
    public static final PlayingCard FOUR_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.FOUR.getValue());
    public static final PlayingCard FOUR_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.FOUR.getValue());
    public static final PlayingCard FOUR_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.FOUR.getValue());
    public static final PlayingCard FOUR_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.FOUR.getValue());

    // threes
    public static final PlayingCard THREE_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.THREE.getValue());
    public static final PlayingCard THREE_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.THREE.getValue());
    public static final PlayingCard THREE_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.THREE.getValue());
    public static final PlayingCard THREE_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.THREE.getValue());

    // twos
    public static final PlayingCard TWO_OF_SPADES = new PlayingCard(Suit.Spades.getValue(), Rank.TWO.getValue());
    public static final PlayingCard TWO_OF_HEARTS = new PlayingCard(Suit.Hearts.getValue(), Rank.TWO.getValue());
    public static final PlayingCard TWO_OF_CLUBS = new PlayingCard(Suit.Clubs.getValue(), Rank.TWO.getValue());
    public static final PlayingCard TWO_OF_DIAMONDS = new PlayingCard(Suit.Diamonds.getValue(), Rank.TWO.getValue());


    public static List<PlayingCard> getFlushRoyal() {
        List<PlayingCard> flushRoyal = new LinkedList<>();
        flushRoyal.add(TEN_OF_CLUBS);
        flushRoyal.add(JACK_OF_CLUBS);
        flushRoyal.add(QUEEN_OF_CLUBS);
        flushRoyal.add(KING_OF_CLUBS);
        flushRoyal.add(ACE_OF_CLUBS);

        return flushRoyal;
    }

    public static List<PlayingCard> getStraightFlush() {
        List<PlayingCard> straightFlush = new LinkedList<>();
        straightFlush.add(TWO_OF_CLUBS);
        straightFlush.add(THREE_OF_CLUBS);
        straightFlush.add(FOUR_OF_CLUBS);
        straightFlush.add(FIVE_OF_CLUBS);
        straightFlush.add(SIX_OF_CLUBS);

        return straightFlush;
    }

    public static List<PlayingCard> getFourOfKind() {
        List<PlayingCard> fourOfKind = new LinkedList<>();
        fourOfKind.add(ACE_OF_CLUBS);
        fourOfKind.add(ACE_OF_DIAMONDS);
        fourOfKind.add(ACE_OF_HEARTS);
        fourOfKind.add(ACE_OF_SPADES);
        fourOfKind.add(TWO_OF_CLUBS);

        return fourOfKind;
    }

    public static List<PlayingCard> getFullHouse() {
        List<PlayingCard> fullHouse = new LinkedList<>();
        fullHouse.add(TWO_OF_DIAMONDS);
        fullHouse.add(TWO_OF_CLUBS);
        fullHouse.add(TWO_OF_HEARTS);
        fullHouse.add(THREE_OF_DIAMONDS);
        fullHouse.add(THREE_OF_CLUBS);

        return fullHouse;
    }

    public static List<PlayingCard> getFlush() {
        List<PlayingCard> flush = new LinkedList<>();
        flush.add(TWO_OF_CLUBS);
        flush.add(THREE_OF_CLUBS);
        flush.add(FIVE_OF_CLUBS);
        flush.add(SEVEN_OF_CLUBS);
        flush.add(JACK_OF_CLUBS);

        return flush;
    }

    public static List<PlayingCard> getStaight() {

        List<PlayingCard> straight = new LinkedList<>();
        straight.add(TWO_OF_CLUBS);
        straight.add(THREE_OF_DIAMONDS);
        straight.add(FOUR_OF_SPADES);
        straight.add(FIVE_OF_HEARTS);
        straight.add(SIX_OF_HEARTS);

        return straight;
    }

    public static List<PlayingCard> getThreeOfKind() {
        List<PlayingCard> threeOfKind = new LinkedList<>();
        threeOfKind.add(ACE_OF_CLUBS);
        threeOfKind.add(ACE_OF_DIAMONDS);
        threeOfKind.add(ACE_OF_HEARTS);
        threeOfKind.add(TWO_OF_CLUBS);
        threeOfKind.add(FIVE_OF_CLUBS);

        return threeOfKind;
    }

    public static List<PlayingCard> getTwoPair() {
        List<PlayingCard> twoPair = new LinkedList<>();
        twoPair.add(ACE_OF_CLUBS);
        twoPair.add(ACE_OF_DIAMONDS);
        twoPair.add(KING_OF_CLUBS);
        twoPair.add(KING_OF_DIAMONDS);
        twoPair.add(THREE_OF_CLUBS);

        return twoPair;
    }

    public static List<PlayingCard> getOnePair() {
        List<PlayingCard> onePair = new LinkedList<>();
        onePair.add(KING_OF_CLUBS);
        onePair.add(KING_OF_DIAMONDS);
        onePair.add(ACE_OF_CLUBS);
        onePair.add(TWO_OF_CLUBS);
        onePair.add(THREE_OF_CLUBS);

        return onePair;
    }
}
