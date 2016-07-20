package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.innopolis.university.summerbootcamp.java.project.model.Settings;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by NIKMC-I on 20.07.2016.
 */
public class MainMenuController implements Initializable {

    @FXML
    private Button btnSettings;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnBackOnMainMenu;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnTutorial;
    @FXML
    private Button btnScore;
    @FXML
    private Button btnStart;
    @FXML
    private Label lName;
    @FXML
    private Label lCash;

    public void setTextToLabel () {
            lName.setText(ui.Name);
    }
    public void setCashToLabel () {
        lCash.setText(String.valueOf(ui.Cash));
    }

    public void onClickExit(ActionEvent event){
        if(event.getSource()==btnExit) {
            System.exit(0);
        }
    }

    public void onClickSettings(ActionEvent event) throws IOException {
        Stage stage;
        //Parent root;
        stage=(Stage) btnSettings.getScene().getWindow();
        if(event.getSource()==btnSettings){
            //get reference to the button's stage
            //load up OTHER FXML document
            //root = FXMLLoader.load(getClass().getClassLoader().getResource("Settings.fxml"));
        }
        else{
           // root = FXMLLoader.load(getClass().getClassLoader().getResource("MainFX.fxml"));
        }
        CoreConfig setRep = new CoreConfig();
        Settings settings = new Settings(setRep.getSettings());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Settings.fxml"));
        Parent root = loader.load();
        SettingsController personController = loader.getController();
        personController.setDifficulty(settings.getDifficulty());
        personController.setBet(settings.getBat());
        personController.setplayer(settings.getPlayerCount());
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void onClickScore(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==btnScore){
            //get reference to the button's stage
            stage=(Stage) btnScore.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Score.fxml"));
        }
        else{
            stage=(Stage) btnScore.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Score.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onClickTutorial(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==btnTutorial){
            //get reference to the button's stage
            stage=(Stage) btnTutorial.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Tutorial.fxml"));
        }
        else{
            stage=(Stage) btnTutorial.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Tutorial.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onClickStart(ActionEvent event) throws IOException {
        Stage stage;
        stage=(Stage) btnStart.getScene().getWindow();
        if(event.getSource()==btnStart){
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
            root.getStylesheets().addAll(getClass().getClassLoader().getResource("style.css").toExternalForm());
            stage.setTitle("Holdem");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        }

        //create a new scene with root and set the stage


    }
    public void onClickLogOut(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==btnLogOut){
            //get reference to the button's stage
            stage=(Stage) btnLogOut.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MainFX.fxml"));
        }
        else{
            stage=(Stage) btnLogOut.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MainFX.fxml"));
        }
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
/*    public void onClickBack(ActionEvent event) throws IOException {
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
        //create a new scene with root and set the stage
        Scene scene = new Scene(roott);
        stage.setScene(scene);
        stage.show();
    }*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTextToLabel ();
    }
}
