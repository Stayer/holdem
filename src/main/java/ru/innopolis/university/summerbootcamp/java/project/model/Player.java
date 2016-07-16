package ru.innopolis.university.summerbootcamp.java.project.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalv6_000 on 14.07.2016.
 */
public class Player extends User {


    private transient  List<PlayingCard> playingCards;

    private double points;

    public List<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Player() {
        playingCards = new ArrayList<>();
    }

}
