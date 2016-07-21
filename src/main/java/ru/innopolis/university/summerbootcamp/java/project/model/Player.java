package ru.innopolis.university.summerbootcamp.java.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalv6_000 on 14.07.2016.
 */
public class Player extends User {


    private transient  List<PlayingCard> playingCards;

    private int cash;

    public List<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Player() {
        playingCards = new ArrayList<>();
    }

}
