package ru.innopolis.university.summerbootcamp.java.project.util;

import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.PokerHands;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by iskandar on 21/07/16.
 */
public class Logger {

    private static final String MESSAGE_FLOP = "Flop";
    private static final String MESSAGE_TERN = "Tern #ROUND_NUMBER#";
    private static final String MESSAGE_RIEVER = "Riever";
    private static final String MESSAGE_FINAL = "Final";

    private static final String MESSAGE_RISE = "Rise by #USER# for #AMOUNT#";
    private static final String MESSAGE_CHECK = "Check by #USER#";
    private static final String MESSAGE_FOLD = "Fold by #USER#";

    private static final String MESSAGE_WINNER = "User #USER# won with #COMBINATION# ";

    public static String getFlopMessage() {
        return MESSAGE_FLOP;
    }

    public static String getMessageTern(int roundNumber) {
        return MESSAGE_TERN.replace("#ROUND_NUMBER#", "" + roundNumber);
    }

    public static String getRieverMessage() {
        return MESSAGE_RIEVER;
    }

    public static String getFinalMessage() {
        return MESSAGE_FINAL;
    }

    public static String getRiseMessage(String userName, int amount) {
        return MESSAGE_RISE.replace("#USER#", userName).replace("#AMOUNT#", "" + amount);
    }

    public static String getCheckMessage(String userName) {
        return MESSAGE_CHECK.replace("#USER#", userName);
    }

    public static String getFordMessage(String userName) {
        return MESSAGE_FOLD.replace("#USER#", userName);
    }

    public static String getWinnerCombinationMessage(String winnerName, List<PlayingCard> deck) {
        int finalScore = Checker.checkCombo(deck);

        switch (PokerHands.parse(finalScore).toString()) {
            case "FLUSHROYAL":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "flush royal");
            case "STRAIGHTFLUSH":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "straight flush");
            case "FOUROFAKIND":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "four of a kind");
            case "FULLHOUSE":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "full house");
            case "FLUSH":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "flush");
            case "STRAIGHT":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "straight");
            case "THREEOFAKIND":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "three of a kind");
            case "TWOPAIR":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "two pair");
            case "ONEPAIR":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "one pair");
            case "HIGH":
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "a high card");
            default:
                return MESSAGE_WINNER.replace("#USER#", winnerName).replace("#COMBINATION#", "default combinations");
        }
    }
}
