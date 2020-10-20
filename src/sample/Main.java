package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//AudioSystem
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Main extends Application {

    public String filepath;
    public boolean fileSelected;


    // launch the application
    public void start(Stage stage){


        try{

            // set title for the stage
            stage.setTitle("FileChooser");

            // create a File chooser
            FileChooser file_chooser = new FileChooser();
            file_chooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.acac")
            );

            // create a Label
            Label label = new Label("no files selected");

            // create a Button
            Button button = new Button("Show open dialog");

            // create an Event Handler
            EventHandler<ActionEvent> event =
                    new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent e){

                            // get the file selected
                            File file = file_chooser.showOpenDialog(stage);

                            if (file != null) {



                                try {
                                    label.setText(file.getCanonicalPath()
                                            + "  selected");
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    filepath = file.getCanonicalPath();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                fileSelected = true;
                                System.out.println(filepath);

                                //AUDIO
                                Media media = new Media(new File(filepath).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(media);

                                mediaPlayer.setAutoPlay(true);
                                stage.show();
                                //AUDIO

                            }
                        }
                    };




            button.setOnAction(event);

            // create a Button
            Button button1 = new Button("Show save dialog");

            // create an Event Handler
            EventHandler<ActionEvent> event1 =
                    new EventHandler<ActionEvent>() {

                        public void handle(ActionEvent e)
                        {

                            // get the file selected
                            File file = file_chooser.showSaveDialog(stage);

                            if (file != null) {
                                label.setText(file.getAbsolutePath()
                                        + "  selected");
                            }
                        }
                    };

            button1.setOnAction(event1);

            // create a VBox
            VBox vbox = new VBox(30, label, button, button1);

            // set Alignment
            vbox.setAlignment(Pos.CENTER);

            // create a scene
            Scene scene = new Scene(vbox, 800, 500);

            // set the scene
            stage.setScene(scene);

            stage.show();

        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }


    // Main Method
    public static void main(String args[])
    {

        // launch the application
        launch(args);
    }
}