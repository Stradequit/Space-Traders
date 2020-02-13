package spacetraders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spacetraders.classes.Person;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CharacterCreationController implements Initializable {
    @FXML Button nameSubmit;
    @FXML TextField nameField;
    @FXML Label nameBox;
    @FXML Label remainMessage;
    @FXML Label remainPoints;

    Pane root = null;
    Person person = new Person();
    Boolean nameCheck = false;
    public void setEasy() {
        person.setDifficulty("Easy");
        remainMessage.setText("Skill points remaining:");
    }
    public void setMedium() {
        remainMessage.setText("Skill points remaining:");
        person.setDifficulty("Medium");
    }
    public void setHard() {
        remainMessage.setText("Skill points remaining:");
        person.setDifficulty("Hard");
    }
    public void configDone(javafx.event.ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Screens/characterPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene characterPage = new Scene(root, 720, 480);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        gameController.changeStage(characterPage);
        stage.close();
    }

    public void submitName(ActionEvent actionEvent) {
        if (nameField.getText() != null && !nameField.getText().isEmpty()) {
            nameBox.setText("Your name is: " + nameField.getText());
            nameCheck = true;
        }
        else {
            nameBox.setText("Enter a name.");
            nameCheck = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
