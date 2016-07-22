package ru.innopolis.university.summerbootcamp.java.project.ui;/**
 * Created by dalv6_000 on 18.07.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        root.getStylesheets().addAll(getClass().getClassLoader().getResource("style.css").toExternalForm());
        primaryStage.setTitle("#InnoBootCamp2016: Texas Holdem");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
