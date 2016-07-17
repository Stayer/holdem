package ru.innopolis.university.summerbootcamp.java.project.ai;

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
        50.1177394035f   // HighKard
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
        17.4119195f   // HighKard
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

}
