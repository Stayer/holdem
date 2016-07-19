package ru.innopolis.university.summerbootcamp.java.project.ai;

import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.model.AiDecision;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.PokerHands;
import ru.innopolis.university.summerbootcamp.java.project.util.CommonUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
    private List<Integer> history = new LinkedList<>();
    private Random random = new Random();
    /**
     * Analyzes current player's data and makes decision.
     * @param cards player's current deck
     * @param cash player's current cash
     * @param bet current bet
     * @param round current round of bets (IAE exception if round is incorrect)
     * @return computed decision
     */
    public AiDecision getDecision(List<PlayingCard> cards, int cash, int bet, int round) throws IllegalArgumentException {

        if (round < 1 || round > 2) {
            throw new IllegalArgumentException("round");
        }

        float prevBetsAvg = history.stream().reduce(0, (i1, i2)-> i1+i2) / history.size();

        int comboPoints = Checker.checkCombo(cards);
        boolean goodCards = false;
        boolean enoughMoney = false;
        boolean suddenRaise = false;
        // TODO: pointsBias is almost hardcoded. There must be better solution
        if (CommonUtils.isIn(pointsBias, comboPoints, Checker.FLUSHROYAL))
            goodCards = true;
        if (cash > bet)
            enoughMoney = true;
        if (bet > prevBetsAvg)
            suddenRaise = true;

        history.add(bet);

        if (!enoughMoney) {
            return AiDecision.fold();
        }

        if (goodCards && round > 1 ) {
            return AiDecision.bet();
        }

        if (goodCards && suddenRaise && round == 1) {
            return AiDecision.riseWith((int) prevBetsAvg);
        }

        double gaussian = random.nextGaussian();
        float[] coeffs = getCoeffsFromPoints(cards);

        if (CommonUtils.isInExclusiveR(.0, gaussian, (double)coeffs[0])) {
            return AiDecision.fold();
        } else if (CommonUtils.isInExclusiveR((double)coeffs[0], gaussian, (double)(coeffs[1] + coeffs[0]))) {
            return AiDecision.riseWith((int) prevBetsAvg);
        } else {
            return AiDecision.bet();
        }
    }

    /**
     *
     * @param cards
     * @return float[0] - FOLD; float[1] - RAISE; float[2] - CHECK
     */
    private float[] getCoeffsFromPoints (List<PlayingCard> cards)
    {
        int comboPoints = Checker.checkCombo(cards);
        switch(PokerHands.parse(comboPoints)) {
            case FLUSHROYAL:
                return new float[]{0.0f, 0.5f, 0.5f};
            case STRAIGHTFLUSH:
                return new float[]{0.0f, 0.5f, 0.5f};
            case FOUROFAKIND:
                return new float[]{0.02f, 0.38f, 0.6f};
            case FULLHOUSE:
                return new float[]{0.05f, 0.85f, 0.1f};
            case FLUSH:
                return new float[]{0.2f, 0.6f, 0.2f};
            case STRAIGHT:
                return new float[]{0.3f, 0.5f, 0.2f};
            case THREEOFAKIND:
                return new float[]{0.2f, 0.3f, 0.5f};
            case TWOPAIR:
                return new float[]{0.3f, 0.3f, 0.4f};
            case ONEPAIR:
                return new float[]{0.25f, 0.7f, 0.05f};
            default:
                return new float[]{0.4f, 0.4f, 0.2f};
        }
    }
}
