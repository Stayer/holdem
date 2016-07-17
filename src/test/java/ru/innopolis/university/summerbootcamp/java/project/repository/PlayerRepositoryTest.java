package ru.innopolis.university.summerbootcamp.java.project.repository;

import org.junit.Test;

import static org.junit.Assert.*;

import ru.innopolis.university.summerbootcamp.java.project.model.Player;
import ru.innopolis.university.summerbootcamp.java.project.repository.impl.PlayerRepository;

/**
 * Created by dalv6_000 on 17.07.2016.
 */
public class PlayerRepositoryTest {

    @Test
    public void saveTest() {
        Player player = new Player();
        player.setLogin("test");
        player.setPassword("password");
        player.setCash(223);
        PlayerRepository.getInstance().create(player);

        Player player1 = new Player();
        player1.setLogin("test");
        Player read = PlayerRepository.getInstance().read(player1);
        assertEquals("password", read.getPassword());
    }


    @Test
    public void readTest() {
        Player player1 = new Player();
        player1.setLogin("test");
        Player read = PlayerRepository.getInstance().read(player1);
        assertEquals("password", read.getPassword());
    }
}
