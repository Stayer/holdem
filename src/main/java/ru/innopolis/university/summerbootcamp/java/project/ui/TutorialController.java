package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by NIKMC-I on 20.07.2016.
 */
public class TutorialController {

    @FXML
    private Button btnBackOnMainMenu;


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

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
        Parent roott = loader.load();
        MainMenuController personController = loader.getController();
        personController.setTextToLabel();
        personController.setCashToLabel();
        //create a new scene with root and set the stage
        Scene scene = new Scene(roott);
        stage.setTitle("Texas Holdem");
        stage.setScene(scene);
        stage.show();

    }
}
