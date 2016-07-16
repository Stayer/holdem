package ru.innopolis.university.summerbootcamp.java.project.engine;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

/**
 * Created by rodionov on 16.07.2016.
 */
public class Checker {
    private boolean[][] pool = new boolean[4][13];

    public int checkCombo(PlayingCard[] cards) {
        int score = 10000;
        int tmp = 0;
        for (int i = 0; i < cards.length; i++)
            pool[cards[i].getSuit()][cards[i].getValue()] = true;

        score += isFlushRoyal(cards);
        score += isStraightFlush(cards);
        score += isFourOfKind(cards);
        score += isFullHouse(cards);
        score += isFlush(cards);
        score += isStraight(cards);
        score += isThreeOfKind(cards);
        score += isTwoPairs(cards);
        score += isOnePair(cards);

        return score;
    }
    private int isFlushRoyal(PlayingCard[] cards) {
        for(int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 0; j < 13; j++)
                if (pool[i][j])
                    count++;
            if (count >= 5)
                if (pool[i][12] && pool[i][11] && pool[i][10] && pool[i][9] && pool[i][8])
                    return 0;
        }
        return -1000;
    }
    private int isStraightFlush(PlayingCard[] cards) {
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
                        return 0 - (12 - j + 5);
                }
            }
        }
        return -1000;
    }
    private int isFourOfKind(PlayingCard[] cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter >= 4)
                return 0 - (12 - j);
        }
        return -1000;
    }
    private int isFullHouse(PlayingCard[] cards) {
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
            return -sum; // need to check it
        return -1000;
    }
    private int isFlush(PlayingCard[] cards) {
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
        return -1000;
    }
    private int isStraight(PlayingCard[] cards) {
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
        return -1000;
    }
    private int isThreeOfKind(PlayingCard[] cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 3)
                return 0 - (12 - j);
        }
        return -1000;
    }
    private int isTwoPairs(PlayingCard[] cards) {
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
        return -1000;
    }
    private int isOnePair(PlayingCard[] cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 2)
                return 0 - (12 - j);
        }
        return -1000;
    }

}
