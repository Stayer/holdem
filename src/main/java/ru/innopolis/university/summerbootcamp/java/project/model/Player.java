package ru.innopolis.university.summerbootcamp.java.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalv6_000 on 14.07.2016.
 */
public class Player extends User {


    private transient  List<PlayingCard> playingCards;

    private double cash;

    public List<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public Player() {
        playingCards = new ArrayList<>();
    }

}
