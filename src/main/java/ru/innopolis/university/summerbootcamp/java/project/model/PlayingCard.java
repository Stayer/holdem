package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.Suit;

public class PlayingCard {
    public static String getString(PlayingCard card) {
        StringBuilder builder = new StringBuilder();

        switch (card.getRank()) {
            case 0 :
                builder.append("2");
                break;
            case 1 :
                builder.append("3");
                break;
            case 2 :
                builder.append("4");
                break;
            case 3 :
                builder.append("5");
                break;
            case 4 :
                builder.append("6");
                break;
            case 5 :
                builder.append("7");
                break;
            case 6 :
                builder.append("8");
                break;
            case 7 :
                builder.append("9");
                break;
            case 8 :
                builder.append("10");
                break;
            case 9 :
                builder.append("J");
                break;
            case 10 :
                builder.append("Q");
                break;
            case 11 :
                builder.append("K");
                break;
            case 12 :
                builder.append("A");
                break;
        }

        switch (card.suit) {
            case 0:
                builder.append("D");
                break;
            case 1:
                builder.append("H");
                break;
            case 2:
                builder.append("C");
                break;
            case 3:
                builder.append("S");
                break;
        }

        return builder.toString();
    }
    private int suit;
    private int rank;

    public PlayingCard(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) { this.rank = rank; }
}
