package ru.innopolis.university.summerbootcamp.java.project.services.impl;

import ru.innopolis.university.summerbootcamp.java.project.model.Player;
import ru.innopolis.university.summerbootcamp.java.project.repository.impl.PlayerRepository;
import ru.innopolis.university.summerbootcamp.java.project.services.Service;

import java.util.List;

/**
 * Created by dalv6_000 on 15.07.2016.
 */
public class PlayerServices implements Service<Player> {

    private static PlayerRepository playerRepository = PlayerRepository.getInstance();
    private static PlayerServices playerServices;

    private PlayerServices(){

    }

    public static PlayerServices getInstance() {
        if (playerServices == null) {
            playerServices = new PlayerServices();
        }
        return playerServices;
    }

    public Player save(Player player) {
        playerRepository.create(player);
        return player;
    }

    public Player findOne(String name) {
        Player player = new Player();
        player.setLogin(name);
        playerRepository.read(player);
        return player;
    }

    public List<Player> findAll() {
        return playerRepository.getAll();
    }

    public Player update(Player player) {
        playerRepository.update(player);
        return player;
    }

    public void delete(Long playerId) {

    }
}
