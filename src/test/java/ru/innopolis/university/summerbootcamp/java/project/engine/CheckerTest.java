package ru.innopolis.university.summerbootcamp.java.project.engine;

import org.junit.Assert;
import org.junit.Test;

import ru.innopolis.university.summerbootcamp.java.project.utils.Constants;

/**
 * Created by iskandar on 17/07/16.
 */
public class CheckerTest {
    @Test
    public void deckCheckerTests() {
        Assert.assertTrue(
                "Flush royal must be grater then straight flush",
                Checker.checkCombo(Constants.getFlushRoyal()) > Checker.checkCombo(Constants.getStraightFlush())
        );

        Assert.assertTrue(
                "Straight flush must be greater then four of a kind",
                Checker.checkCombo(Constants.getStraightFlush()) > Checker.checkCombo(Constants.getFourOfKind())
        );

        Assert.assertTrue(
                "Four of a kind must be greater then full house",
                Checker.checkCombo(Constants.getFourOfKind()) > Checker.checkCombo(Constants.getFullHouse())
        );

        Assert.assertTrue(
                "Full house must be greater then flush",
                Checker.checkCombo(Constants.getFullHouse()) > Checker.checkCombo(Constants.getFlush())
        );

        Assert.assertTrue(
                "Flush must be greater then straight",
                Checker.checkCombo(Constants.getFullHouse()) > Checker.checkCombo(Constants.getStaight())
        );

        Assert.assertTrue(
                "Straight must be greater then three of a kind",
                Checker.checkCombo(Constants.getStaight()) > Checker.checkCombo(Constants.getThreeOfKind())
        );

        Assert.assertTrue(
                "Three of a kind must be greater then two pairs",
                Checker.checkCombo(Constants.getThreeOfKind()) >  Checker.checkCombo(Constants.getTwoPair())
        );

        Assert.assertTrue(
                "Two pairs must be greater one pair",
                Checker.checkCombo(Constants.getTwoPair()) > Checker.checkCombo(Constants.getOnePair())
        );

        Assert.assertTrue(
                "Cycled straight must be greater than three of kind",
                Checker.checkCombo(Constants.getCycledStraight()) > Checker.checkCombo(Constants.getThreeOfKind())
        );

        Assert.assertTrue(
                "Cycled straight flush must be greater than three of kind",
                Checker.checkCombo(Constants.getCycledStraightFlush()) > Checker.checkCombo(Constants.getFourOfKind())
        );
    }
}
