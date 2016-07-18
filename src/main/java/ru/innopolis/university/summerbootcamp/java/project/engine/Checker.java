package ru.innopolis.university.summerbootcamp.java.project.engine;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;

import java.util.List;

/**
 * Created by rodionov on 16.07.2016.
 */
public class Checker {
    public static final int FLUSHROYAL = 10000;
    public static final int STRAIGHTFLUSH = 9000;
    public static final int FOUROFAKIND = 8000;
    public static final int FULLHOUSE = 7000;
    public static final int FLUSH = 6000;
    public static final int STRAIGHT = 5000;
    public static final int THREEOFAKIND = 4000;
    public static final int TWOPAIR = 3000;
    public static final int ONEPAIR = 2000;
    public static final int HIGH = 0;

    public static boolean[][] pool;
    public static int checkCombo(List<PlayingCard> cards) {
        int score = 10000;
        pool = new boolean[4][13];
        int tmp;
        for (PlayingCard card : cards)
            pool[card.getSuit()][card.getRank()] = true;

        tmp = isFlushRoyal(cards);
        score += tmp;
         if(tmp == 0) {
            return score;
        }
        tmp = isStraightFlush(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isFourOfKind(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isFullHouse(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isFlush(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isStraight(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isThreeOfKind(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isTwoPairs(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isOnePair(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }
        tmp = isHighCard(cards);
        score += tmp;
        if(tmp>=0) {
            return score;
        }

        return 0;
    }
    private static int isFlushRoyal(List<PlayingCard> cards) {
        for(int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 12; j >= 0; j--) {
                if (pool[i][j]) {
                    count++;
                }
            }
            if (count > 4) {
                if (pool[i][12] && pool[i][11] && pool[i][10] && pool[i][9] && pool[i][8]) {
                    return 0;
                }
            }
        }
        return -1000;
    } // 10000
    private static int isStraightFlush(List<PlayingCard> cards) {
        for (int i = 0; i < 4; i++) {
            int count = 0;
            for (int j = 12; j >= 0; j--) {
                if (pool[i][j]) {
                    count++;
                }
            }
            if (count > 4) {
                count = 0;
                for (int j = 12; j > 0; j--) {
                    if (pool[i][j] && pool[i][j - 1]) {
                        count++;
                    }
                    else {
                        count = 0;
                    }
                    if (count == 4) {
                        return j+3;
                    }
                }
            }
        }
        return -1000;
    } // 9000+
    private static int isFourOfKind(List<PlayingCard> cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 4)
                return j;
        }
        return -1000;
    } // 8000+
    private static int isFullHouse(List<PlayingCard> cards) {
        int sum = 1;
        int[] total = new int[13];
        for (int j = 12; j >= 0; j--)
        {
            int counter = 0;
            for(int i = 0; i < 4; i++) {
                if (pool[i][j]) { counter++;}
            }
            total[j] = counter;

        }
        int two = -1;
        int three = -1;
        for(int j = 12; j >= 0; j--) {
            if (total[j] == 3 && j > three) { three = j;}
        }
        for(int j = 12; j >= 0; j--) {
            if (total[j] >= 2 && j != three && j > three) { two = j;}
        }
        if(two != -1 && three != -1)
            return((two+1)*(three+1));
        return -1000;
    } // 7000+
    private static int isFlush(List<PlayingCard> cards) {
        for(int i = 0; i < 4; i++) {
            int counter = 0;
            int highCard = -1;
            for (int j = 12; j >= 0; j--) {
                if (pool[i][j]) {
                    if(j > highCard) {highCard = j;}
                    counter++;
                    if(counter == 5)
                        return highCard;
                }
            }
        }
        return -1000;
    } // 6000+
    private static int isStraight(List<PlayingCard> cards) {
        int count = 0;
        boolean[] tmpPool = new boolean[13];
        for(int j = 12; j >= 0; j--) {
            for (int i = 0; i < 4; i++) {
                if (pool[i][j])
                    tmpPool[j] = true;
            }
        }
        for (int j = 12; j > 0; j--) {
            if (tmpPool[j] && tmpPool[j - 1]) {
                count++;
                if ((count == 4) || (count == 3 && tmpPool[12] && tmpPool[0])) return j+3;
            }
        }
        return -1000;
    } // 5000+
    private static int isThreeOfKind(List<PlayingCard> cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 3)
                return j;
        }
        return -1000;
    } // 4000+
    private static int isTwoPairs(List<PlayingCard> cards) {
        int pairs = 0;
        int sum = 1;
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for (int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 2) {
                pairs++;
                sum *= (j+1);
            }
            if(pairs == 2)
                return sum;
        }
        return -1000;
    } // 3000+
    private static int isOnePair(List<PlayingCard> cards) {
        for (int j = 12; j >= 0; j--) {
            int counter = 0;
            for(int i = 0; i < 4; i++)
                if (pool[i][j])
                    counter++;
            if(counter == 2)
                return j;
        }
        return -1000;
    } // 2000+
    private static int isHighCard(List<PlayingCard> cards) {
        PlayingCard card = cards.get(0);
        for(int i = 1; i<cards.size(); i++)
            if (cards.get(i).getRank() > card.getRank())
                card = cards.get(i);
        return card.getRank();
    } // 0+
}
