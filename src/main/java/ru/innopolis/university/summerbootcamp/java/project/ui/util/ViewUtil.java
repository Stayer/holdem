package ru.innopolis.university.summerbootcamp.java.project.ui.util;

import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

/**
 * Created by dalv6_000 on 19.07.2016.
 */
public class ViewUtil {


    public static String getPlayingCardImageUrlByValue(PlayingCard playingCard) {
        return "ui/ah.png";
        //return playingCard.getRank() + " " + playingCard.getSuit();
    }

}
