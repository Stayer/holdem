package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;

import java.util.List;

public class Game {
    private List<HoldemPlayer> holdemPlayers;
    private List<PlayingCard> deck;
    private List<PlayingCard> tableCards;
    private double lowestBet;
    private GameStage gameStage;
    private double currentBet;
    private int currentPlayer;
    private double roundBet;

    public double getRoundBet() {
        return roundBet;
    }

    public void setRoundBet(double roundBet) {
        this.roundBet = roundBet;
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

    public double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(double currentBet) {
        this.currentBet = currentBet;
    }

    public GameStage getGameStage() {
        return gameStage;
    }

    public void setGameStage(GameStage gameStage) {
        this.gameStage = gameStage;
    }

    public double getLowestBet() {
        return lowestBet;
    }

    public void setLowestBet(double lowestBet) {
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
