package ru.innopolis.university.summerbootcamp.java.project.engine;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;

import java.util.*;

import static sun.audio.AudioPlayer.player;

public class GameEngine {
    /**
     * Compare two combinations
     *
     * @param combination1 first combination
     * @param combination2 second combination
     * @return the value {@code 0} if {@code first combination} is
     * equal to {@code second combination}; a value less than
     * {@code 0} if {@code first combination} is less
     * than {@code second combination}; and a value greater
     * than {@code 0} if {@code first combination} is
     * greater than the {@code second combination} .
     */
    public static int compareCombination(List<PlayingCard> combination1, List<PlayingCard> combination2) {
        if (Checker.checkCombo(combination1) > Checker.checkCombo(combination2))
            return 1;
        else if (Checker.checkCombo(combination1) < Checker.checkCombo(combination2))
            return -1;
        return 0;
    }
    public static int winnerPicker(List<HoldemPlayer> players)
    {
        HoldemPlayer winner = players.stream().max(new Comparator<HoldemPlayer>() {
            Checker checker = new Checker();
            @Override
            public int compare(HoldemPlayer o1, HoldemPlayer o2) {

                return Integer.compare(Checker.checkCombo(o1.getPlayingCards()), Checker.checkCombo(o2.getPlayingCards()));
            }
        }).get();
        return players.indexOf(winner);
    }


}
