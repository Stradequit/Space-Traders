package spacetraders.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import spacetraders.controllers.GameController;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class WelcomeController implements Initializable {
    private Pane root = null;
    private @FXML MediaView mediaViewer;
    String path = WelcomeController.class.getResource("..//sounds//introMusic.mp3").toString();
    private Media introSong = new Media(path);
    private MediaPlayer mediaPlayer = new MediaPlayer(introSong);
    @FXML public void openConfigScreen(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("..//screens//characterCreation.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Button Pressed");
        Scene characterCreation = new Scene(root, 720, 480);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        gameController.changeStage(characterCreation);
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaViewer.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }
}
