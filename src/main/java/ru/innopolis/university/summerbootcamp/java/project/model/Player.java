package ru.innopolis.university.summerbootcamp.java.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalv6_000 on 14.07.2016.
 */
public class Player extends User {

    private List<PlayingCard> playingCards;

    public List<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public Player(){
        playingCards = new ArrayList<PlayingCard>();
    }

}
