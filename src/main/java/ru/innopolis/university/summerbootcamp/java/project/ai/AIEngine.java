package ru.innopolis.university.summerbootcamp.java.project.ai;

import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import ru.innopolis.university.summerbootcamp.java.project.util.CommonUtils;

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

    private static final int pointsBias = 5000; // 18.07.16 empirical number
    private float prevBetsAvg=0;

    /**
     * Analyzes current player's data and makes decision.
     * @param cards player's current deck
     * @param cash player's current cash
     * @param betSum sum of players' bet
     * @return computed decision
     */
    public CommandType getDecision(List<PlayingCard> cards, int cash, int betSum) throws IllegalArgumentException {
        if (prevBetsAvg == 0) // TODO: WTF?!
            prevBetsAvg = betSum;
        else
            prevBetsAvg = (betSum + prevBetsAvg) / 2;

        int comboPoints = Checker.checkCombo(cards);
        boolean goodCards = false;
        boolean enoughMoney = false;
        boolean suddenRaise = false;
        // TODO: pointsBias is almost hardcoded. There must be better solution
        if (CommonUtils.isInRange(pointsBias, comboPoints, Checker.FLUSHROYAL))
            goodCards = true;
        if (cash > betSum)
            enoughMoney = true;
        if (betSum > prevBetsAvg)
            suddenRaise = true;

        if (!enoughMoney)
            return CommandType.Fold;
        if (goodCards) {
            if (suddenRaise)
                return CommandType.Bet;
            else
                return CommandType.Rise;
        } else {
            if (suddenRaise)
                return CommandType.Fold;
            else
                return CommandType.Bet;
        }
    }

    private float[] getCoeffsFromPoints (List<PlayingCard> cards)
    {
        float[] coeffs = new float[3]; // coeffs[0] - FOLD, coeffs[1] - RAISE, coeffs[2] - CHECK
        int comboPoints = Checker.checkCombo(cards);
        switch(comboPoints % 1000)  // TODO: magic numbers.
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
}
