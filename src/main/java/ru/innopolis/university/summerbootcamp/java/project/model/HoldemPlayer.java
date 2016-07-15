package ru.innopolis.university.summerbootcamp.java.project.model;

/**
 * Created by dalv6_000 on 15.07.2016.
 */
public class HoldemPlayer extends Player {

    private boolean isDealer;
    private boolean isSmallBlind;
    private boolean isBigBlind;
    private double bet;

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

    public boolean isSmallBlind() {
        return isSmallBlind;
    }

    public void setSmallBlind(boolean smallBlind) {
        isSmallBlind = smallBlind;
    }

    public boolean isBigBlind() {
        return isBigBlind;
    }

    public void setBigBlind(boolean bigBlind) {
        isBigBlind = bigBlind;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }
}
