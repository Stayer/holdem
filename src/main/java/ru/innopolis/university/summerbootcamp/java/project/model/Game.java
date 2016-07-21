package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;

import java.util.List;

public class Game {
    private List<HoldemPlayer> holdemPlayers;
    private List<PlayingCard> deck;
    private List<PlayingCard> tableCards;
    private int lowestBet;
    private GameStage gameStage;
    private int currentBet;
    private int currentPlayer;
    private int totalRoundBet;
    private double winPoint;

    public double getWinPoint() {
        return winPoint;
    }

    public void setWinPoint(double winPoint) {
        this.winPoint = winPoint;
    }

    public int getTotalRoundBet() {
        return totalRoundBet;
    }

    public void setTotalRoundBet(int totalRoundBet) {
        this.totalRoundBet = totalRoundBet;
    }

    public List<PlayingCard> getTableCards() {
        return tableCards;
    }

    public void setTableCards(List<PlayingCard> tableCards) {
        this.tableCards = tableCards;
    }

    public HoldemPlayer nextPlayer() {
        HoldemPlayer player = holdemPlayers.get(currentPlayer);
        currentPlayer++;
        if (currentPlayer == holdemPlayers.size()) {
            currentPlayer = 0;
        }
        return player;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        if (currentPlayer >= holdemPlayers.size()) {
            currentPlayer = 0;
        }
        this.currentPlayer = currentPlayer;
    }

    public HoldemPlayer getUser() {
        return holdemPlayers.get(0);
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public void setGameStage(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    public int getLowestBet() {
        return lowestBet;
    }

    public void setLowestBet(int lowestBet) {
        this.lowestBet = lowestBet;
    }

    public List<HoldemPlayer> getHoldemPlayers() {
        return holdemPlayers;
    }

    public void setHoldemPlayers(List<HoldemPlayer> holdemPlayers) {
        this.holdemPlayers = holdemPlayers;
    }

    public List<PlayingCard> getDeck() {
        return deck;
    }

    public void setDeck(List<PlayingCard> deck) {
        this.deck = deck;
    }
}
