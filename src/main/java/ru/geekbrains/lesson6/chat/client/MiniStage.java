package ru.geekbrains.lesson6.chat.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class MiniStage extends Stage {
    String nickTo;
    DataOutputStream out;
    List<TextArea> parentList;

    public MiniStage(String nickTo, DataOutputStream out, List<TextArea> parentList) {
        this.nickTo = nickTo;
        this.out = out;
        this.parentList = parentList;
        Parent root = null;
        try {
            URL url = new URL("file:src/main/java/ru/geekbrains/lesson6/chat/client/personal.fxml");

            root = FXMLLoader.load(url);
            setTitle("personal window");
            Scene scene = new Scene(root, 300, 400);
            setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
