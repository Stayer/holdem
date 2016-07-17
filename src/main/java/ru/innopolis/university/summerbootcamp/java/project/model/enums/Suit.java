package ru.innopolis.university.summerbootcamp.java.project.model.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dalv6_000 on 15.07.2016.
 */
public enum Suit {
    Diamonds(0), Hearts(1), Clubs(2), Spades(3);

    private static final Map<Integer,Suit> lookup
            = new HashMap<Integer,Suit>();

    static {
        for(Suit w : EnumSet.allOf(Suit.class))
            lookup.put(w.getValue(), w);
    }

    private int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
