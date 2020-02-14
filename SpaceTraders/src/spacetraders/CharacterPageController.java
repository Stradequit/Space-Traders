package spacetraders;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spacetraders.classes.Person;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import spacetraders.GameController;

public class CharacterPageController implements Initializable {
    Parent root;
    @FXML Label engineerLabel, pilotLabel, nameLabel, difficultyLabel, creditsLabel, merchantLabel, fighterLabel;
    public void openMap(javafx.event.ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Screens/mapPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene mapPage = new Scene(root, 1920, 960);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        gameController.changeStage(mapPage);
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameController gameController = new GameController();
        nameLabel.setText(gameController.person.getName());
        difficultyLabel.setText(gameController.person.getDifficulty());
        creditsLabel.setText(String.valueOf(gameController.person.getCredits()));
        engineerLabel.setText(String.valueOf(gameController.person.getEngineeringPoints()));
        fighterLabel.setText(String.valueOf(gameController.person.getFighterPoints()));
        pilotLabel.setText(String.valueOf(gameController.person.getPilotPoints()));
        merchantLabel.setText(String.valueOf(gameController.person.getMerchantPoints()));
    }
}
