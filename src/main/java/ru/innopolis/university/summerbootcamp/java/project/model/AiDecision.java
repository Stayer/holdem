package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;

/**
 * Created by Bulat on 19.07.2016.
 */
public class AiDecision {
    private CommandType command;
    private int value;

    public CommandType getCommand() {
        return command;
    }

    public int getValue() {
        return value;
    }

    private AiDecision(CommandType command, int value) {
        this.command = command;

        this.value = value;
    }

    public static AiDecision fold() {
        return new AiDecision(CommandType.Fold, 0);
    }

    public static AiDecision bet() {
        return new AiDecision(CommandType.Bet, 0);
    }

    public static AiDecision riseWith(int value) {
        return new AiDecision(CommandType.Rise, value);
    }
}
