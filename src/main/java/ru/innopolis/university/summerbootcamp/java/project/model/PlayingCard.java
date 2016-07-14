package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.Suit;


public class PlayingCard {
    private Suit suit;
    private String value;

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
