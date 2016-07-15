package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;

/**
 * Created by dalv6_000 on 15.07.2016.
 */
public class PlayerCommand {

    private String value;
    private CommandType type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }
}
