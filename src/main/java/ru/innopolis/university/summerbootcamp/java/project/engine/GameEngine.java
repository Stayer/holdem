package ru.innopolis.university.summerbootcamp.java.project.engine;

import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.PlayingCard;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.GameStage;

import java.util.LinkedList;
import java.util.List;

/**
 * Engine for game
 * Rules, judging and so on...
 */
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
    public int compareCombination(List<PlayingCard> combination1, List<PlayingCard> combination2) {
        if (combination1.size() != 7 || combination2.size() != 7) {
            //TODO: Throw exception
        }
        return 0;
    }


    public Game createGame(List<HoldemPlayer> players, int needPlayers) {
        while (players.size() < needPlayers) {
            HoldemPlayer holdemPlayer = new HoldemPlayer();
            holdemPlayer.setLogin("Bot");
            players.add(holdemPlayer);
        }

        Game game = new Game();
        game.setHoldemPlayers(players);
        List<PlayingCard> deck = createAndShuffleDeck();
        game.setPlayingCards(deck);

        return game;
    }


    public List<PlayingCard> createAndShuffleDeck() {
        LinkedList<PlayingCard> playingCards = new LinkedList<>();

        //TODO: implement it!!!

        return playingCards;
    }


    public void initGame(Game game) {
        //TODO: check num of players
        List<HoldemPlayer> holdemPlayers = game.getHoldemPlayers();

        //Setting dealer and blinds
        holdemPlayers.get(0).setDealer(true);
        HoldemPlayer smallBlindPlayer = holdemPlayers.get(1);
        smallBlindPlayer.setSmallBlind(true);
        smallBlindPlayer.setBet(game.getSmallBet() / 2.0);

        HoldemPlayer bigBlindPlayer = holdemPlayers.get(2);
        bigBlindPlayer.setBigBlind(true);
        bigBlindPlayer.setBet(game.getSmallBet());

    }


    /**
     * Change dealer and blinds actors in a game
     *
     * @param game
     */
    public void changeDealer(Game game) {
        List<HoldemPlayer> holdemPlayers = game.getHoldemPlayers();

        for (int i = 0; i < holdemPlayers.size(); i++) {
            HoldemPlayer holdemPlayer = holdemPlayers.get(i);
            if (holdemPlayer.isDealer()) {
                holdemPlayer.setDealer(false);
                if (i == holdemPlayers.size() - 1) {
                    holdemPlayers.get(0).setDealer(true);
                    //Last is dealer
                } else {
                    holdemPlayers.get(i + 1).setDealer(true);
                }


            } else if (holdemPlayer.isBigBlind()) {
                holdemPlayer.setBigBlind(false);
                if (i == holdemPlayers.size() - 1) {
                    holdemPlayers.get(0).setBigBlind(true);
                    //Last is bigBlind
                } else {
                    holdemPlayers.get(i + 1).setBigBlind(true);
                }
            } else if (holdemPlayer.isSmallBlind()) {
                holdemPlayer.setSmallBlind(false);
                if (i == holdemPlayers.size() - 1) {
                    holdemPlayers.get(0).setSmallBlind(true);
                    //Last is smallBlind
                } else {
                    holdemPlayers.get(i + 1).setSmallBlind(true);
                }
            }
        }

    }

    public void startGame(Game game) {
        game.setGameStage(GameStage.Start);
        if (game.getGameStage() == GameStage.Start) {
            game.setGameStage(GameStage.Preflop);
            //Giveaway cards
            for (HoldemPlayer holdemPlayer : game.getHoldemPlayers()) {
                PlayingCard playingCard = takeCard(game);
                holdemPlayer.getPlayingCards().add(playingCard);
                        //TODO: STOP HERE
            }


        }


    }


    private PlayingCard takeCard(Game game) {
        return game.getPlayingCards().remove(0);
    }


}
