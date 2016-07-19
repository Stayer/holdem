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
        } else if (CommonUtils.isInExclusiveL(Checker.FLUSHROYAL, comboPoints, Checker.STRAIGHTFLUSH)) {
            return PokerHands.STRAIGHTFLUSH;
        } else if (CommonUtils.isInExclusiveL(Checker.STRAIGHTFLUSH, comboPoints, Checker.FOUROFAKIND)) {
            return PokerHands.FOUROFAKIND;
        } else if (CommonUtils.isInExclusiveL(Checker.FOUROFAKIND, comboPoints, Checker.FULLHOUSE)) {
            return PokerHands.FULLHOUSE;
        } else if (CommonUtils.isInExclusiveL(Checker.FULLHOUSE, comboPoints, Checker.FLUSH)) {
            return PokerHands.FLUSH;
        } else if (CommonUtils.isInExclusiveL(Checker.FLUSH, comboPoints, Checker.STRAIGHT)) {
            return PokerHands.STRAIGHT;
        } else if (CommonUtils.isInExclusiveL(Checker.STRAIGHT, comboPoints, Checker.THREEOFAKIND)) {
            return PokerHands.THREEOFAKIND;
        } else if (CommonUtils.isInExclusiveL(Checker.THREEOFAKIND, comboPoints, Checker.TWOPAIR)) {
            return PokerHands.TWOPAIR;
        } else if (CommonUtils.isInExclusiveL(Checker.TWOPAIR, comboPoints, Checker.ONEPAIR)) {
            return PokerHands.ONEPAIR;
        } else
            return PokerHands.HIGH;
    }

}
