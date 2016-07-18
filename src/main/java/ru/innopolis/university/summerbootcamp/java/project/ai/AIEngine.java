package ru.innopolis.university.summerbootcamp.java.project.ai;

import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Bot decisions engine
 */
public class AIEngine {
    private float prob = 0.0f;
    private float[] ptacc5 = { // Probability to collect a certain combination (5 of 52)
        0.0001539077f, // FlushRoyal
        0.0013851695f, // StraightFlush
        0.0240096038f, // FourOfAKind
        0.144057623f, // FullHouse
        0.1965401545f, // Flush
        0.3924646782f, // Straight
        2.1128451381f, // ThreeOfAKind
        4.7539015606f, // TwoPair
        42.2569027611f, // OnePair
        50.1177394035f   // HighCard
    };

    private float[] ptacc7 = { // Probability to collect a certain combination (7 of 52)
        0.003232062f, // FlushRoyal
        0.027850748f, // StraightFlush
        0.168067227f, // FourOfAKind
        2.596102271f, // FullHouse
        3.025494123f, // Flush
        4.619382087f, // Straight
        4.829869755f, // ThreeOfAKind
        23.49553641f, // TwoPair
        43.82254574f, // OnePair
        17.4119195f   // HighCard
    };
    private float[] ishotf = // Improved starting hand on the flop
    {
        12.7f, // pocket pair -> set or higher
        11.8f, // pocket pair -> set
        0.73f, // pocket pair -> FullHouse
        0.24f, // pocket pair -> FourOfAKind
        32.4f, // 2 cards no-pair -> OnePair
        2.0f, // 2 cards no-pair -> TwoPair
        0.842f, // 2 cards with the same suit -> Flush
        10.9f, // 2 cards with the same suit -> Flush-draw
        41.6f, // 2 cards with the same suit -> BackdoorFlush
        9.6f, // connectors 4|5-J|T -> OESD
        19.1f, // connectors 4|5-J|T -> Straight or Flush-draw
        1.31f, // connectors 4|5-J|T -> Straight
    };

    /**
     * Analyzes current player's data and makes decision.
     * @param cards player's current deck
     * @param cash player's current cash
     * @param round 1 for first round. 2 for second. Exception thrown otherwise
     * @return computed decision
     */

    private float[] getCoeffsFromPoints (List<PlayingCard> cards)
    {
        float[] coeffs = new float[3]; // coeffs[0] - FOLD, coeffs[1] - RAISE, coeffs[2] - CHECK
        int comboPoints = Checker.checkCombo(cards);
        switch(comboPoints % 1000)
        {                           // fold raise check
            case 10: // flushroyal
                coeffs = new float[]{0.0f, 0.5f, 0.5f};
                break;
            case 9: // straightflush
                coeffs = new float[]{0.0f, 0.5f, 0.5f};
                break;
            case 8: // fourofakind
                coeffs = new float[]{0.02f, 0.38f, 0.6f};
                break;
            case 7: // fullhouse
                coeffs = new float[]{0.05f, 0.85f, 0.1f};
                break;
            case 6: // flush
                coeffs = new float[]{0.2f, 0.6f, 0.2f};
                break;
            case 5: // staight
                coeffs = new float[]{0.3f, 0.5f, 0.2f};
                break;
            case 4: // threeofakind
                coeffs = new float[]{0.2f, 0.3f, 0.5f};
                break;
            case 3: // twopairs
                coeffs = new float[]{0.3f, 0.3f, 0.4f};
                break;
            case 2: // onepair
                coeffs = new float[]{0.25f, 0.7f, 0.05f};
                break;
            default:
                coeffs = new float[]{0.4f, 0.4f, 0.2f};
                break;
        }
        return coeffs;
    }

    public CommandType getDecision(List<PlayingCard> cards, int cash, int round) throws IllegalArgumentException {
        int comboPoints = Checker.checkCombo(cards);
        float[] coeffs = getCoeffsFromPoints(cards);
        switch (cards.size()) {
            case 2:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                throw new IllegalArgumentException("incorrect cards quantity");
        }
        throw new NotImplementedException();
    }
}
