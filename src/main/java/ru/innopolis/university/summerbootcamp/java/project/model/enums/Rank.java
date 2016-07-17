package ru.innopolis.university.summerbootcamp.java.project.model.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by iskandar on 17/07/16.
 */
public enum Rank {
    TWO(0), THREE(1), FOUR(2), FIVE(3), SIX(4), SEVEN(5), EIGHT(6), NINE(7), TEN(8), JACK(9), QUEEN(10), KING(11), ACE(12);

    private static final Map<Integer,Suit> lookup
            = new HashMap<Integer,Suit>();

    static {
        for(Suit w : EnumSet.allOf(Suit.class))
            lookup.put(w.getValue(), w);
    }

    private int value;

    private Rank(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
