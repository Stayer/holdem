package ru.innopolis.university.summerbootcamp.java.project.model.enums;

import ru.innopolis.university.summerbootcamp.java.project.engine.Checker;
import ru.innopolis.university.summerbootcamp.java.project.util.CommonUtils;

/**
 * Created by Bulat on 19.07.2016.
 */
public enum PokerHands {
    FLUSHROYAL,
    STRAIGHTFLUSH,
    FOUROFAKIND,
    FULLHOUSE,
    FLUSH,
    STRAIGHT,
    THREEOFAKIND,
    TWOPAIR,
    ONEPAIR,
    HIGH;

    public static PokerHands parse(int comboPoints) {
        if (comboPoints >= Checker.FLUSHROYAL) {
            return PokerHands.FLUSHROYAL;
        } else if (CommonUtils.isInExclusiveR(Checker.STRAIGHTFLUSH, comboPoints, Checker.FLUSHROYAL)) {
            return PokerHands.STRAIGHTFLUSH;
        } else if (CommonUtils.isInExclusiveR(Checker.FOUROFAKIND, comboPoints, Checker.STRAIGHTFLUSH)) {
            return PokerHands.FOUROFAKIND;
        } else if (CommonUtils.isInExclusiveR(Checker.FULLHOUSE, comboPoints, Checker.FOUROFAKIND)) {
            return PokerHands.FULLHOUSE;
        } else if (CommonUtils.isInExclusiveR(Checker.FLUSH, comboPoints, Checker.FULLHOUSE)) {
            return PokerHands.FLUSH;
        } else if (CommonUtils.isInExclusiveR(Checker.STRAIGHT, comboPoints, Checker.FLUSH)) {
            return PokerHands.STRAIGHT;
        } else if (CommonUtils.isInExclusiveR(Checker.THREEOFAKIND, comboPoints, Checker.STRAIGHT)) {
            return PokerHands.THREEOFAKIND;
        } else if (CommonUtils.isInExclusiveR(Checker.TWOPAIR, comboPoints, Checker.THREEOFAKIND)) {
            return PokerHands.TWOPAIR;
        } else if (CommonUtils.isInExclusiveR(Checker.ONEPAIR, comboPoints, Checker.TWOPAIR)) {
            return PokerHands.ONEPAIR;
        } else
            return PokerHands.HIGH;
    }

}
