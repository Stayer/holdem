[33mcommit 9b7f13f59548d2ecd03698263f1a1f800ae95cff[m
Author: Stayer <rodionov12@gmail.com>
Date:   Mon Jul 18 19:31:25 2016 +0600

    Update Checker. #holdem-15

[1mdiff --git a/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/Checker.java b/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/Checker.java[m
[1mindex 475a608..0ea455d 100644[m
[1m--- a/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/Checker.java[m
[1m+++ b/src/main/java/ru/innopolis/university/summerbootcamp/java/project/engine/Checker.java[m
[36m@@ -94,7 +94,7 @@[m [mpublic class Checker {[m
             }[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 10000[m
     private static int isStraightFlush(List<PlayingCard> cards) {[m
         for (int i = 0; i < 4; i++) {[m
             int count = 0;[m
[36m@@ -112,14 +112,14 @@[m [mpublic class Checker {[m
                     else {[m
                         count = 0;[m
                     }[m
[31m-                    if (count == 5) {[m
[31m-                        return j;[m
[32m+[m[32m                    if (count == 4) {[m
[32m+[m[32m                        return j+3;[m
                     }[m
                 }[m
             }[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 9000+[m
     private static int isFourOfKind(List<PlayingCard> cards) {[m
         for (int j = 12; j >= 0; j--) {[m
             int counter = 0;[m
[36m@@ -130,63 +130,63 @@[m [mpublic class Checker {[m
                 return j;[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 8000+[m
     private static int isFullHouse(List<PlayingCard> cards) {[m
[31m-        int counter = 0;[m
         int sum = 1;[m
         int[] total = new int[13];[m
         for (int j = 12; j >= 0; j--)[m
         {[m
[31m-            for(int i = 0; i < 4; i++)[m
[31m-                if(pool[i][j])[m
[31m-                    counter++;[m
[31m-            if(counter == 2)[m
[31m-                total[j] = 1;[m
[31m-            if(counter > 2)[m
[31m-                total[j] = 2;[m
[31m-        }[m
[31m-        for(int j = 12; j >= 0; j--)[m
[31m-            if(total[j] == 2)[m
[31m-            {[m
[31m-                sum *= j;[m
[31m-                break;[m
[31m-            }[m
[31m-        for(int j = 12; j>= 0; j--)[m
[31m-            if(total[j] >= 1 && j != sum) {[m
[31m-                sum *= j;[m
[31m-                break;[m
[32m+[m[32m            int counter = 0;[m
[32m+[m[32m            for(int i = 0; i < 4; i++) {[m
[32m+[m[32m                if (pool[i][j]) { counter++;}[m
             }[m
[31m-        if(sum > 12)[m
[31m-            return sum; // need to check it[m
[32m+[m[32m            total[j] = counter;[m
[32m+[m
[32m+[m[32m        }[m
[32m+[m[32m        int two = -1;[m
[32m+[m[32m        int three = -1;[m
[32m+[m[32m        for(int j = 12; j >= 0; j--) {[m
[32m+[m[32m            if (total[j] == 3 && j > three) { three = j;}[m
[32m+[m[32m        }[m
[32m+[m[32m        for(int j = 12; j >= 0; j--) {[m
[32m+[m[32m            if (total[j] >= 2 && j != three && j > three) { two = j;}[m
[32m+[m[32m        }[m
[32m+[m[32m        if(two != -1 && three != -1)[m
[32m+[m[32m            return((two+1)*(three+1));[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 7000+[m
     private static int isFlush(List<PlayingCard> cards) {[m
         for(int i = 0; i < 4; i++) {[m
             int counter = 0;[m
[32m+[m[32m            int highCard = -1;[m
             for (int j = 12; j >= 0; j--) {[m
                 if (pool[i][j]) {[m
[32m+[m[32m                    if(j > highCard) {highCard = j;}[m
                     counter++;[m
[31m-                    if(counter == 4)[m
[31m-                        return 0; // need to more work[m
[32m+[m[32m                    if(counter == 5)[m
[32m+[m[32m                        return highCard; // need to more work[m
                 }[m
             }[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 6000+[m
     private static int isStraight(List<PlayingCard> cards) { // need to write some code for Ace correct working[m
[31m-        for (int i = 0; i < 4; i++) {[m
[31m-            int count = 0;[m
[31m-            for (int j = 12; j > 0; j--)[m
[31m-                if (pool[i][j] && pool[i][j - 1]) {[m
[31m-                    count++;[m
[31m-                    if (count == 5)[m
[31m-                        return 0; // need to work more[m
[31m-                }[m
[31m-                else[m
[31m-                    count = 0;[m
[32m+[m[32m        int count = 0;[m
[32m+[m[32m        boolean[] tmpPool = new boolean[13];[m
[32m+[m[32m        for(int j = 12; j >= 0; j--) {[m
[32m+[m[32m            for (int i = 0; i < 4; i++) {[m
[32m+[m[32m                if (pool[i][j])[m
[32m+[m[32m                    tmpPool[j] = true;[m
[32m+[m[32m            }[m
[32m+[m[32m        }[m
[32m+[m[32m        for (int j = 12; j > 0; j--) {[m
[32m+[m[32m            if (tmpPool[j] && tmpPool[j - 1]) {[m
[32m+[m[32m                count++;[m
[32m+[m[32m                if ((count == 4) || (count == 3 && tmpPool[12] && tmpPool[0])) return j+3; // need to work more[m
[32m+[m[32m            }[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 5000+[m
     private static int isThreeOfKind(List<PlayingCard> cards) {[m
         for (int j = 12; j >= 0; j--) {[m
             int counter = 0;[m
[36m@@ -194,25 +194,27 @@[m [mpublic class Checker {[m
                 if (pool[i][j])[m
                     counter++;[m
             if(counter == 3)[m
[31m-                return 12 - j;[m
[32m+[m[32m                return j;[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 4000+[m
     private static int isTwoPairs(List<PlayingCard> cards) {[m
[31m-        int counter = 0;[m
[31m-        int sum = 0;[m
[31m-[m
[32m+[m[32m        int pairs = 0;[m
[32m+[m[32m        int sum = 1;[m
         for (int j = 12; j >= 0; j--) {[m
[32m+[m[32m            int counter = 0;[m
             for (int i = 0; i < 4; i++)[m
                 if (pool[i][j])[m
                     counter++;[m
[31m-            if(counter == 2)[m
[31m-                sum++;[m
[31m-            if(sum == 2)[m
[31m-                return 0; // need more work with it[m
[32m+[m[32m            if(counter == 2) {[m
[32m+[m[32m                pairs++;[m
[32m+[m[32m                sum *= (j+1);[m
[32m+[m[32m            }[m
[32m+[m[32m            if(pairs == 2)[m
[32m+[m[32m                return sum; // need more work with it[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 3000+[m
     private static int isOnePair(List<PlayingCard> cards) {[m
         for (int j = 12; j >= 0; j--) {[m
             int counter = 0;[m
[36m@@ -220,15 +222,15 @@[m [mpublic class Checker {[m
                 if (pool[i][j])[m
                     counter++;[m
             if(counter == 2)[m
[31m-                return 12 - j;[m
[32m+[m[32m                return j;[m
         }[m
         return -1000;[m
[31m-    }[m
[32m+[m[32m    } // 2000+[m
     private static int isHighCard(List<PlayingCard> cards) {[m
         PlayingCard card = cards.get(0);[m
         for(int i = 1; i<cards.size(); i++)[m
             if (cards.get(i).getRank() > card.getRank())[m
                 card = cards.get(i);[m
         return card.getRank();[m
[31m-    }[m
[32m+[m[32m    } // 0+[m
 }[m
