package ru.innopolis.university.summerbootcamp.java.project.engine;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

import java.util.List;

/**
 * Created by rodionov on 16.07.2016.
 */
public class Checker {
    private static boolean[][] pool = new boolean[4][13];

    public static int checkCombo(List<PlayingCard> cards) {
        int score = 10000;
        int tmp = 0;
        for (int i = 0; i < cards.size(); i++)
            pool[cards.get(i).getSuit()][cards.get(i).getRank()] = true;

        tmp = isFlushRoyal(cards);
         if(tmp>0) {
            score -= tmp;
            return score;
        }
        tmp = isStraightFlush(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isFourOfKind(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isFullHouse(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isFlush(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isStraight(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isThreeOfKind(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isTwoPairs(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }
        tmp = isOnePair(cards);
        if(tmp<0) {
            score -= tmp;
            return score;
        }

        return score;
    }
    private static int isFlushRoyal(List<PlayingCard> cards) {
        for(int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 13; j++)
                if (pool[i][j])
                    count++;
            if (count >= 5)
                if (pool[i][12] && pool[i][11] && pool[i][10] && pool[i][9] && pool[i][8])
                    return 0;
        }
        return 1000;
    }
    private static int isStraightFlush(List<PlayingCard> cards) {
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 13; j++)
                if (pool[i][j])
                    count++;
            if (count >= 5) {
                count = 0;
                for (int j = 12; j > 0; j--) {
                    if (pool[i][j] && pool[i][j - 1])
                        count++;
                    else
                        count = 0;
                    if (count == 5)
                        return 12 - j + 5;
                }
            }
        }
        return 1000;
    }
    private static int isFourOfKind(List<PlayingCard> cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter >= 4)
                return 12 - j;
        }
        return 1000;
    }
    private static int isFullHouse(List<PlayingCard> cards) {
        int counter = 0;
        int sum = 0;
        int[] total = new int[13];
        for (int j = 12; j >= 0; j--)
        {
            for(int i = 0; i < 4; i++)
                if(pool[i][j])
                    counter++;
            if(counter == 2)
                total[j] = 1;
            if(counter > 2)
                total[j] = 2;
        }
        for(int j = 12; j >= 0; j--)
            if(total[j] == 2)
            {
                sum = 12-j;
                break;
            }
        for(int j = 12; j>= 0; j--)
            if(total[j] >= 1) {
                sum = 12 - j;
                break;
            }
        if(sum>0)
            return sum; // need to check it
        return 1000;
    }
    private static int isFlush(List<PlayingCard> cards) {
        for(int i = 0; i < 4; i++) {
            int counter = 0;
            for (int j = 12; j >= 0; j--) {
                if (pool[i][j]) {
                    counter++;
                    if(counter == 4)
                        return 0; // need to more work
                }
            }
        }
        return 1000;
    }
    private static int isStraight(List<PlayingCard> cards) { // need to write some code for Ace correct working
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 12; j > 0; j--)
                if (pool[i][j] && pool[i][j - 1]) {
                    count++;
                    if (count == 5)
                        return 0; // need to work more
                }
                else
                    count = 0;
        }
        return 1000;
    }
    private static int isThreeOfKind(List<PlayingCard> cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 3)
                return 12 - j;
        }
        return 1000;
    }
    private static int isTwoPairs(List<PlayingCard> cards) {
        int counter = 0;
        int sum = 0;

        for (int j = 12; j >= 0; j--) {
            for (int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 2)
                sum++;
            if(sum == 2)
                return 0; // need more work with it
        }
        return 1000;
    }
    private static int isOnePair(List<PlayingCard> cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 2)
                return 12 - j;
        }
        return 1000;
    }
    private static int isHighCard(List<PlayingCard> cards) {
        PlayingCard card = cards.get(0);
        for(int i = 1; i<cards.size(); i++)
            if (cards.get(i).getRank() > card.getRank())
                card = cards.get(i);
        return card.getRank();
    }

}
