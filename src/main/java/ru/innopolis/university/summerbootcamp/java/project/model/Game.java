package ru.innopolis.university.summerbootcamp.java.project.model;

import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;

import java.util.List;

public class Game {
    private List<HoldemPlayer> holdemPlayers;
    private List<PlayingCard> playingCards;
    private double lowestBet;
    private GameStage gameStage;



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

    public List<PlayingCard> getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }
}
