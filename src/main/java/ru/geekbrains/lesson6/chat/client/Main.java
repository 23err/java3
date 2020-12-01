package ru.geekbrains.lesson6.chat.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        URL url = new URL("file:src/main/java/ru/geekbrains/lesson6/chat/client/client.fxml");

        Parent root = FXMLLoader.load(url);

        primaryStage.setTitle("2k18SummerChat");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        // primaryStage.setOnCloseRequest(event -> System.out.println("On Close"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
