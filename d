[33mcommit addc43d01d2af8a8912b3cb140e28967a2e92229[m
Author: Stayer <rodionov12@gmail.com>
Date:   Sat Jul 16 03:30:29 2016 +0600

    Adding Checker class into a GameEngine

[1mdiff --git a/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/GameEngine.java b/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/GameEngine.java[m
[1mindex 2e1b054..7f25050 100644[m
[1m--- a/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/GameEngine.java[m
[1m+++ b/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/GameEngine.java[m
[36m@@ -1,8 +1,174 @@[m
 package ru.innopolis.university.summerbootcamp.java.project.engine;[m
 [m
[32m+[m[32mimport ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;[m
[32m+[m[32mimport ru.innopolis.university.summerbootcamp.java.project.model.enums.Suit;[m
[32m+[m
[32m+[m[32mimport java.util.LinkedList;[m
[32m+[m[32mimport java.util.List;[m
[32m+[m
[32m+[m
 /**[m
  * Engine for game[m
  * Rules, judging and so on...[m
  */[m
 public class GameEngine {[m
[32m+[m[32m    public class Checker {[m
[32m+[m[32m        private boolean[][] pool = new boolean[4][13];[m
[32m+[m
[32m+[m[32m        public int checkCombo(PlayingCard[] cards) {[m
[32m+[m[32m            int score = 10000;[m
[32m+[m[32m            int tmp = 0;[m
[32m+[m[32m            for (int i = 0; i < cards.length; i++)[m
[32m+[m[32m                pool[cards[i].getSuit()][cards[i].getValue()] = true;[m
[32m+[m
[32m+[m[32m            score = isFlushRoyal(cards);[m
[32m+[m[32m            score = isStraightFlush(cards);[m
[32m+[m[32m            score = isFourOfKind(cards);[m
[32m+[m[32m            score = isFullHouse(cards);[m
[32m+[m[32m            score = isFlush(cards);[m
[32m+[m[32m            score = isStraight(cards);[m
[32m+[m[32m            score = isThreeOfKind(cards);[m
[32m+[m[32m            score = isTwoPairs(cards);[m
[32m+[m[32m            score = isOnePair(cards);[m
[32m+[m
[32m+[m[32m            return score;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isFlushRoyal(PlayingCard[] cards) {[m
[32m+[m[32m            for(int i = 0; i < 4; i++) {[m
[32m+[m[32m                int count = 0;[m
[32m+[m[32m                for (int j = 0; j < 13; j++)[m
[32m+[m[32m                    if (pool[i][j])[m
[32m+[m[32m                        count++;[m
[32m+[m[32m                if (count >= 5)[m
[32m+[m[32m                    if (pool[i][13] && pool[i][12] && pool[i][11] && pool[i][10] && pool[i][9])[m
[32m+[m[32m                        return 0;[m
[32m+[m[32m            }[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isStraightFlush(PlayingCard[] cards) {[m
[32m+[m[32m            for (int i = 0; i < 4; i++) {[m
[32m+[m[32m                int count = 0;[m
[32m+[m[32m                for (int j = 0; j < 13; j++)[m
[32m+[m[32m                    if (pool[i][j])[m
[32m+[m[32m                        count++;[m
[32m+[m[32m                if (count >= 5) {[m
[32m+[m[32m                    count = 0;[m
[32m+[m[32m                    for (int j = 12; j > 0; j--) {[m
[32m+[m[32m                        if (pool[i][j] && pool[i][j - 1])[m
[32m+[m[32m                            count++;[m
[32m+[m[32m                        else[m
[32m+[m[32m                            count = 0;[m
[32m+[m[32m                        if (count == 5)[m
[32m+[m[32m                            return 0 - (12 - j + 5);[m
[32m+[m[32m                    }[m
[32m+[m[32m                }[m
[32m+[m[32m            }[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isFourOfKind(PlayingCard[] cards) {[m
[32m+[m[32m            for (int j = 12; j >= 0; j++) {[m
[32m+[m[32m                int counter = 0;[m
[32m+[m[32m                for(int i = 0; i < 4; i++)[m
[32m+[m[32m                    if (pool[i][j])[m
[32m+[m[32m                        counter++;[m
[32m+[m[32m                if(counter >= 4)[m
[32m+[m[32m                    return 0 - (12 - j);[m
[32m+[m[32m            }[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isFullHouse(PlayingCard[] cards) {[m
[32m+[m[32m            int counter = 0;[m
[32m+[m[32m            int sum = 0;[m
[32m+[m[32m            int[] total = new int[13];[m
[32m+[m[32m            for (int j = 0; j < 13; j++)[m
[32m+[m[32m            {[m
[32m+[m[32m                for(int i = 0; i < 4; i++)[m
[32m+[m[32m                    if(pool[i][j])[m
[32m+[m[32m                        counter++;[m
[32m+[m[32m                if(counter == 2)[m
[32m+[m[32m                    total[j] = 1;[m
[32m+[m[32m                if(counter > 2)[m
[32m+[m[32m                    total[j] = 2;[m
[32m+[m[32m            }[m
[32m+[m[32m            for(int j = 12; j >= 0; j--)[m
[32m+[m[32m                if(total[j] == 2)[m
[32m+[m[32m                {[m
[32m+[m[32m                    sum = 12-j;[m
[32m+[m[32m                    break;[m
[32m+[m[32m                }[m
[32m+[m[32m            for(int j = 12; j>= 0; j--)[m
[32m+[m[32m                if(total[j] >= 1) {[m
[32m+[m[32m                    sum = 12 - j;[m
[32m+[m[32m                    break;[m
[32m+[m[32m                }[m
[32m+[m[32m                if(sum>0)[m
[32m+[m[32m                    return -sum; // need to check it[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isFlush(PlayingCard[] cards) {[m
[32m+[m[32m            for(int i = 0; i < 4; i++) {[m
[32m+[m[32m                int counter = 0;[m
[32m+[m[32m                for (int j = 12; j >= 0; j++) {[m
[32m+[m[32m                    if (pool[i][j]) {[m
[32m+[m[32m                        counter++;[m
[32m+[m[32m                        if(counter == 4)[m
[32m+[m[32m                            return 0; // need to more work[m
[32m+[m[32m                    }[m
[32m+[m[32m                }[m
[32m+[m[32m            }[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isStraight(PlayingCard[] cards) {[m
[32m+[m[32m            for (int i = 0; i < 4; i++) {[m
[32m+[m[32m                int count = 0;[m
[32m+[m[32m                for (int j = 13; j > 0; j++)[m
[32m+[m[32m                    if (pool[i][j] && pool[i][j - 1]) {[m
[32m+[m[32m                        count++;[m
[32m+[m[32m                        if (count == 5)[m
[32m+[m[32m                            return 0; // need to work more[m
[32m+[m[32m                    }[m
[32m+[m[32m                    else[m
[32m+[m[32m                        count = 0;[m
[32m+[m[32m            }[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isThreeOfKind(PlayingCard[] cards) {[m
[32m+[m[32m            for (int j = 12; j >= 0; j++) {[m
[32m+[m[32m                int counter = 0;[m
[32m+[m[32m                for(int i = 0; i < 4; i++)[m
[32m+[m[32m                    if (pool[i][j])[m
[32m+[m[32m                        counter++;[m
[32m+[m[32m                if(counter == 3)[m
[32m+[m[32m                    return 0 - (12 - j);[m
[32m+[m[32m            }[m
[32m+[m[32m            return -1000;[m
[32m+[m[32m        }[m
[32m+[m[32m        private int isTwoPairs(PlayingCard[] cards) {[m
[32m+[m[32m            int counter = 0;[m
[32m+[m[32m            int sum = 0;[m
[32m+[m
[32m+[m[32m            for (int j = 13; j >= 0; j++) {[m
[32m+[m[32m                for (int i = 0; i < 4; i++)[m
[32m+[m[32m                    if (pool[i][j])[m
[32m+[m[32m                        counter++;[m
[32m+[m[32m 