package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by NIKMC-I on 19.07.2016.
 */
public class MainController  implements Initializable {

    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignIn;
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
    private TextField etName;
    @FXML
    private Label lName;
    @FXML
    private Label lCash;

    private static String Name = "defaultUser";

    public void onClickExit(ActionEvent event){
        if(event.getSource()==btnExit) {
            System.exit(0);
        }
    }


    public void onClickMain(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        MainController.Name = etName.getText();
        if(event.getSource()==btnSignIn){
            //get reference to the button's stage
            stage=(Stage) btnSignIn.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        }
        else{
            stage=(Stage) btnSignIn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("MainFX.fxml"));
        }


        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
        Parent roott = loader.load();
        if(!etName.getText().trim().isEmpty())
        ui.Name = etName.getText();
        else{
            ui.Name = "defaultUser";
        }
        MainMenuController personController = loader.getController();
        personController.setTextToLabel();
        personController.setCashToLabel();

//        btnSignIn.getScene().setRoot(roott);
//create a new scene with root and set the stage
        Scene scene = new Scene(roott);
        stage.setScene(scene);
        stage.show();

    }

   @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
