package ru.innopolis.university.summerbootcamp.java.project.ui.util;

import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

import java.util.Random;

/**
 * Created by dalv6_000 on 19.07.2016.
 */
public class ViewUtil {


    public static String getPlayingCardImageUrlByValue(PlayingCard playingCard) {
        if(new Random().nextBoolean()){
            return "ui/ah.png";
        }else{
            return "ui/kh.png";
        }
        //return playingCard.getRank() + " " + playingCard.getSuit();
    }

}
