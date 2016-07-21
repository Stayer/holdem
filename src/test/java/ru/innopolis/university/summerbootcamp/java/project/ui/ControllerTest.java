package ru.innopolis.university.summerbootcamp.java.project.ui;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.model.Game;
import ru.innopolis.university.summerbootcamp.java.project.model.HoldemPlayer;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;
import ru.innopolis.university.summerbootcamp.java.project.model.User;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;

import java.util.List;
import java.util.Objects;

/**
 * Created by iskandar on 21/07/16.
 */
public class ControllerTest {

/*    @Test
    public void createGameTest() {
        Controller controller = new Controller();

        HoldemPlayer player = new HoldemPlayer();
        player.setLogin("Joe Pasquale");
        player.setBet(931);

        SettingsServices services = SettingsServices.getInstance();
        Settings setting = services.findOne(player.getLogin());
        setting.setPlayerCount(3);
        services.save(setting);

        Game currentGame = controller.createGame();
        List<HoldemPlayer> players = currentGame.getHoldemPlayers();

        Assert.assertTrue(
                "Wrong number of players in game",
                players.size() == 3
        );

        Assert.assertTrue(
                "Wrong first player in game",
                Objects.equals(currentGame.getUser().getLogin(), "Anonymous")
        );
        
        // TODO: complete tests
    }*/
}
