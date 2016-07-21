package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;
import ru.innopolis.university.summerbootcamp.java.project.services.impl.SettingsServices;

import java.io.IOException;

/**
 * Created by NIKMC-I on 20.07.2016.
 */
public class SettingsController {

    @FXML
    private Button btnBackOnMainMenu;
    @FXML
    private RadioButton Bet1, Bet2, Bet3, Bet4, difficultyEasy, difficultyHard, player3, player4, player5, player6, player7, musicOn, MusicOff;
    @FXML
    private ToggleGroup Number_of_players;

    @FXML
    private VBox vbPlayers;


    public void setDifficulty(int i){
        switch (i){
            case 1:
                difficultyEasy.setSelected(true);
                break;
            case 2:
                difficultyHard.setSelected(true);
                break;
        }
    }
    public void setBet(int i){
        switch (i){
            case 10:
                Bet1.setSelected(true);
            break;
            case 25:
                Bet2.setSelected(true);
                break;
            case 100:
                Bet3.setSelected(true);
                break;
            case 250:
                Bet4.setSelected(true);
                break;
        }
    }
    public void setplayer(int i){
        switch (i){
            case 3:
                player3.setSelected(true);
                break;
            case 4:
                player4.setSelected(true);
                break;
            case 5:
                player5.setSelected(true);
                break;
            case 6:
                player6.setSelected(true);
                break;
            case 7:
                player7.setSelected(true);
                break;
        }
    }

    public void onClickBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) btnBackOnMainMenu.getScene().getWindow();
        if(event.getSource()==btnBackOnMainMenu){
            //get reference to the button's stage
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        }
        else{
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        }

        Settings settings = new Settings();
        settings.setUserName(ui.Name);
        settings.setCash(ui.Cash);
        //ох................

        if (player3.isSelected())
            settings.setPlayerCount(3);
        if (player4.isSelected())
            settings.setPlayerCount(4);
        if (player5.isSelected())
            settings.setPlayerCount(5);
        if (player6.isSelected())
            settings.setPlayerCount(6);
        if (player7.isSelected())
            settings.setPlayerCount(7);

        if (Bet1.isSelected())
            settings.setBat(10);
        if (Bet2.isSelected())
            settings.setBat(25);
        if (Bet3.isSelected())
            settings.setBat(100);
        if (Bet4.isSelected())
            settings.setBat(250);
        if (difficultyEasy.isSelected())
            settings.setDifficulty(1);
        if (difficultyHard.isSelected())
            settings.setDifficulty(2);

        if (musicOn.isSelected())
        {
            if(ui.player==null){
                ui.media = new Media(getClass().getResource("/casino.mp3").toString());
                ui.player = new MediaPlayer(ui.media);
                ui.player.setVolume(10f);
                ui.player.setCycleCount(MediaPlayer.INDEFINITE);
                ui.player.play();
            }
        }
        if (MusicOff.isSelected())
        {
            if(ui.player!=null){
                ui.player.stop();
                ui.player = null;
            }
        }

        SettingsServices service = SettingsServices.getInstance();
        service.save(settings);

        /*HashMap<Integer, String> players = new HashMap<>();
        players.put(3,"3 players");
        players.put(4,"4 players");
        players.put(5,"5 players");
        players.put(6,"6 players");
        players.put(7,"7 players");
        ComboBox<HashMap<Integer,String>> comboBox = new ComboBox();
        comboBox.getItems().addAll(players);
*/


        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
        Parent roott = loader.load();
        MainMenuController personController = loader.getController();
        personController.setTextToLabel();
        personController.setCashToLabel();
        //create a new scene with root and set the stage
        Scene scene = new Scene(roott);
        stage.setScene(scene);
        stage.show();

    }


}
