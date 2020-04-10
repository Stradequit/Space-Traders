package spacetraders.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import spacetraders.Main;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class EndingController {
    public void seeCredits(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("..//screens//Credits.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene credits = new Scene(root, 720, 480);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        gameController.changeStage(credits);
    }

    public void newGame(ActionEvent actionEvent) throws IOException, InterruptedException {
        System.out.println( "Restarting app!" );
        Platform.runLater( () -> {
            try {
                new Main().start( new Stage() );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
