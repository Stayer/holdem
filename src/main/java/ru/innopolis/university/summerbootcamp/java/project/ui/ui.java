package ru.innopolis.university.summerbootcamp.java.project.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ui extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Button gotoSignUp,gotoSignIn, gotoQuit;
    Button yesQuit, noQuit;
    Button confirm, back;
    Button startGame, settings, score, tutorial;
    Button backtoMenu1,backtoMenu2,backtoMenu3,backtoMenu4,backtoMenu5,backtoMenu6;
    Button gotoSignUpAgain,gotoSignInAgain,gotoQuit1,gotoQuit2,gotoQuit3;

    Scene sceneMainMenu, sceneQuit, sceneUserSign, sceneExceptionWindowNotExist;
    Scene sceneExceptionWindowExist, sceneProfileWindow, sceneSettingsWindow;
    Scene sceneScoreWindow, sceneTutorialWindow;
    Stage thestage;
    public GridPane setMainMenu(){

        gotoSignIn=new Button("Sign In");
        gotoQuit=new Button("Quit");
        gotoSignIn.setOnAction(e-> ButtonClicked(e));
        gotoSignUp=new Button("Sign Up");
        gotoSignUp.setOnAction(e-> ButtonClicked(e));
        gotoQuit.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn1.getChildren().add(gotoSignUp);
        grid.add(hbBtn1, 0, 1);
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add(gotoSignIn);
        grid.add(hbBtn2, 0, 2);
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn3.getChildren().add(gotoQuit);
        grid.add(hbBtn3, 0, 3);
        return grid;
    }
    public GridPane setQuit(){
        yesQuit=new Button("Yes");
        noQuit=new Button("No");
        noQuit.setOnAction(e-> ButtonClicked(e));
        yesQuit.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label quitConf=new Label("Are uou sure you want to quit?");
        grid.add(quitConf, 0, 1);
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn1.getChildren().add( yesQuit);
        grid.add(hbBtn1, 1, 2);
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add( noQuit);
        grid.add(hbBtn2, 2, 2);
        return grid;
    }
    public GridPane setEnter(){
        confirm=new Button("Confirm");
        back = new Button("Back");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        confirm.setOnAction(e-> ButtonClicked(e));
        back.setOnAction(e-> ButtonClicked(e));
        Label uName, uPass;
        uName=new Label("Username");
        grid.add(uName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        uPass=new Label("Password");
        grid.add(uPass, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(confirm);
        grid.add(hbBtn, 1, 4);
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(back);
        grid.add(hbBtn1, 1, 5);
        return grid;
    }
    public GridPane setNotExist(){
        gotoSignInAgain=new Button("Sign In");
        gotoSignInAgain.setOnAction(e-> ButtonClicked(e));
        gotoQuit1=new Button("Quit");
        gotoQuit1.setOnAction(e-> ButtonClicked(e));
        backtoMenu1 = new Button("Back");
        backtoMenu1.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label sign;
        sign=new Label("User doesn't exist");
        grid.add(sign, 0, 1);
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn1.getChildren().add(gotoSignInAgain);
        grid.add(hbBtn1, 0, 2);
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add(backtoMenu1);
        grid.add(hbBtn2, 0, 3);
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn3.getChildren().add(gotoQuit1);
        grid.add(hbBtn3, 0, 4);
        return grid;
    }
    public GridPane setExist(){
        gotoSignUpAgain=new Button("Sign Up");
        gotoSignUpAgain.setOnAction(e-> ButtonClicked(e));
        gotoQuit2=new Button("Quit");
        gotoQuit2.setOnAction(e-> ButtonClicked(e));
        backtoMenu2 = new Button("Back");
        backtoMenu2.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label sign;
        sign=new Label("User already exists");
        grid.add(sign, 0, 1);
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn1.getChildren().add(gotoSignUpAgain);
        grid.add(hbBtn1, 0, 2);
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add(backtoMenu2);
        grid.add(hbBtn2, 0, 3);
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn3.getChildren().add(gotoQuit2);
        grid.add(hbBtn3, 0, 4);
        return grid;
    }
    public GridPane setProfile(){
        gotoQuit3=new Button("Quit");
        gotoQuit3.setOnAction(e-> ButtonClicked(e));
        backtoMenu3 = new Button("Log out");
        backtoMenu3.setOnAction(e-> ButtonClicked(e));
        startGame=new Button("Start");
        startGame.setOnAction(e-> ButtonClicked(e));
        settings=new Button("Settings");
        settings.setOnAction(e-> ButtonClicked(e));
        score=new Button("Score");
        score.setOnAction(e-> ButtonClicked(e));
        tutorial=new Button("Tutorial");
        tutorial.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label sign, uName;
        String cash="100";
        String uNameS="Username";
        sign=new Label("Cash: "+cash);
        grid.add(sign, 0, 1);
        uName=new Label(uNameS);
        grid.add(uName, 1, 1);
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn1.getChildren().add(startGame);
        grid.add(hbBtn1, 0, 2);
        HBox hbBtn2 = new HBox(10);
        hbBtn2.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn2.getChildren().add(settings);
        grid.add(hbBtn2, 0, 3);
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn3.getChildren().add(score);
        grid.add(hbBtn3, 0, 4);
        HBox hbBtn4 = new HBox(10);
        hbBtn4.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn4.getChildren().add(tutorial);
        grid.add(hbBtn4, 0, 5);
        HBox hbBtn5 = new HBox(10);
        hbBtn5.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn5.getChildren().add(backtoMenu3);
        grid.add(hbBtn5, 0, 6);
        HBox hbBtn6 = new HBox(10);
        hbBtn6.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn6.getChildren().add(gotoQuit3);
        grid.add(hbBtn6, 0, 7);
        return grid;
    }
    public GridPane setSettings(){

        backtoMenu6 = new Button("Back");
        backtoMenu6.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Label players, difficulty,bet;
        players=new Label("Number of players");
        grid.add(players, 0, 0);
        ToggleGroup groupPlayers = new ToggleGroup();
        RadioButton rbPlayers[]=new RadioButton[5];
        for(int i=0;i<5;i++) {
            rbPlayers[i]= new RadioButton(i+3+" Players");
            rbPlayers[i].setToggleGroup(groupPlayers);
            grid.add(rbPlayers[i], 0, i+1);
        }
        rbPlayers[0].setSelected(true);


        difficulty=new Label("Difficulty");
        grid.add(difficulty, 1, 0);
        ToggleGroup groupDif = new ToggleGroup();
        RadioButton rbDif[]=new RadioButton[2];
        rbDif[0]= new RadioButton("Easy");
        rbDif[0].setSelected(true);
        rbDif[1] = new RadioButton("Hard");
        rbDif[0].setToggleGroup(groupDif);
        rbDif[1].setToggleGroup(groupDif);
        grid.add(rbDif[0], 1, 1);
        grid.add(rbDif[1], 1, 2);
        bet=new Label("Minimal bet");
        grid.add(bet, 2, 0);
        ToggleGroup groupBet = new ToggleGroup();
        RadioButton rbBet[]=new RadioButton[4];
        rbBet[0]= new RadioButton("$10");
        rbBet[0].setSelected(true);
        rbBet[1] = new RadioButton("$25");
        rbBet[2] = new RadioButton("$100");
        rbBet[3] = new RadioButton("$250");
        for(int i=0;i<4;i++) {
            grid.add(rbBet[i], 2, i + 1);
            rbBet[i].setToggleGroup(groupBet);
        }
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(backtoMenu6);
        grid.add(hbBtn, 1, 7);
        return grid;
    }
    public GridPane setScore(){
        ArrayList<String> records = new ArrayList<>();
        ArrayList<Label> labels = new ArrayList<>();
        backtoMenu4 = new Button("Back");
        backtoMenu4.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        for (int i=0;i<5;i++){
            records.add("Player"+Integer.toString(i+1)+": "+Integer.toString(600-(i+1)*100));
            labels.add(new Label(records.get(i)));
            grid.add(labels.get(i), 0, i+1);
        }
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(backtoMenu4);
        grid.add(hbBtn, 0, 6);
        return grid;
    }
    public GridPane setTutorial(){

        backtoMenu5 = new Button("Back");
        backtoMenu5.setOnAction(e-> ButtonClicked(e));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        HBox hbBtn = new HBox(10);
        Label rules;
        rules=new Label("Rules:");
        rules.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(rules, 0, 1);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(backtoMenu5);
        grid.add(hbBtn, 0, 2);
        return grid;
    }
    @Override
    public void start(Stage primaryStage) {
        thestage=primaryStage;
        sceneMainMenu = new Scene(setMainMenu(), 800, 600);
        sceneQuit = new Scene(setQuit(), 800, 600);
        sceneUserSign = new Scene(setEnter(), 800, 675);
        sceneExceptionWindowNotExist = new Scene(setNotExist(), 800, 600);
        sceneExceptionWindowExist = new Scene(setExist(), 800, 600);
        sceneProfileWindow = new Scene(setProfile(), 800, 675);
        sceneSettingsWindow = new Scene(setSettings(), 800, 600);
        sceneScoreWindow = new Scene(setScore(), 800, 600);
        sceneTutorialWindow = new Scene(setTutorial(), 800, 675);


        primaryStage.setTitle("Texas Hold'em");
        primaryStage.setScene(sceneMainMenu);
        primaryStage.show();
    }
    public void ButtonClicked(ActionEvent e){
        if (e.getSource()==gotoSignIn) {
            thestage.setScene(sceneUserSign);
        }
        else if(e.getSource()==gotoSignUp){
            thestage.setScene(sceneUserSign);
        }
        if (e.getSource()==gotoSignInAgain) {
            thestage.setScene(sceneUserSign);
        }
        else if(e.getSource()==gotoSignUpAgain){
            thestage.setScene(sceneUserSign);
        }
        else if(e.getSource()==gotoQuit){
            thestage.setScene(sceneQuit);
        }
        else if(e.getSource()==gotoQuit1){
            thestage.setScene(sceneQuit);
        }
        else if(e.getSource()==gotoQuit2){
            thestage.setScene(sceneQuit);
        }
        else if(e.getSource()==gotoQuit3){
            thestage.setScene(sceneQuit);
        }
        else if (e.getSource()==noQuit){
            thestage.setScene(sceneMainMenu);
        }
        else if (e.getSource()==yesQuit){
            thestage.close();
        }
        else if (e.getSource()==back){
            thestage.setScene(sceneMainMenu);
        }
        else if (e.getSource()==settings){
            thestage.setScene(sceneSettingsWindow);
        }
        else if (e.getSource()==score){
            thestage.setScene(sceneScoreWindow);
        }
        else if (e.getSource()==tutorial){
            thestage.setScene(sceneTutorialWindow);
        }
        else if (e.getSource()==confirm){
            thestage.setScene(sceneProfileWindow);
        }
        else if (e.getSource()==backtoMenu1){
            thestage.setScene(sceneMainMenu);
        }
        else if (e.getSource()==backtoMenu2){
            thestage.setScene(sceneMainMenu);
        }
        else if (e.getSource()==backtoMenu3){
            thestage.setScene(sceneMainMenu);
        }
        else if (e.getSource()==backtoMenu4){
            thestage.setScene(sceneProfileWindow);
        }
        else if (e.getSource()==backtoMenu5){
            thestage.setScene(sceneProfileWindow);
        }
        else if (e.getSource()==backtoMenu6){
            thestage.setScene(sceneProfileWindow);
        }
    }

}
