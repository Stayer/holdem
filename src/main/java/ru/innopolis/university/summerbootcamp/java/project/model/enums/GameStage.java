package ru.innopolis.university.summerbootcamp.java.project.model.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dalv6_000 on 15.07.2016.
 */
public enum GameStage {
    Start(0), Preflop(1), Round1(2), Flop(3), Round2(4), Tern(5), Round3(6), Riever(7), Round4(8), Final(9);

    private static final Map<Integer,GameStage> lookup
            = new HashMap<>();

    static {
        for(GameStage w : EnumSet.allOf(GameStage.class))
            lookup.put(w.getValue(), w);
    }

    private int value;

    private GameStage(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
