package spacetraders.controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import spacetraders.classes.Person;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

public class CharacterPageController implements Initializable {
    private Parent root;
    private @FXML Label engineerLabel;
    private @FXML Label pilotLabel;
    private @FXML Label nameLabel;
    private @FXML Label difficultyLabel;
    private @FXML Label creditsLabel;
    private @FXML Label merchantLabel;
    private @FXML Label fighterLabel;
    public void openMap(javafx.event.ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("..//screens//mapPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene mapPage = new Scene(root, 1080, 720);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        gameController.changeStage(mapPage);
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameController gameController = new GameController();
        Person person = new Person();
        nameLabel.setText("Name: " + person.getName());
        difficultyLabel.setText("Difficulty: " + person.getDifficulty());
        creditsLabel.setText("Credits: " + String.valueOf(person.getCredits()));
        engineerLabel.setText("Engineer: " + String.valueOf(person.getEngineeringPoints()));
        fighterLabel.setText("Fighter: " + String.valueOf(person.getFighterPoints()));
        pilotLabel.setText("Pilot: " + String.valueOf(person.getPilotPoints()));
        merchantLabel.setText("Merchant: " + String.valueOf(person.getMerchantPoints()));
    }
}
