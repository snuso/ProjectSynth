package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    static String filePath;

    @Override
    public void start(Stage primaryStage) {

    // test comment
        primaryStage.setTitle("JavaFX App");

        FileChooser fileChooser = new FileChooser();

        Button button = new Button("Select File");
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
        });

        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
        VBox vBox = new VBox(button);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 200, 100);

        primaryStage.setScene(scene);
        primaryStage.show();

        filePath = fileChooser.getInitialFileName();
        System.out.println(filePath);
    }
}