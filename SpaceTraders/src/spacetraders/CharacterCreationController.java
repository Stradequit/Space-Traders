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
    @FXML TextField engineeringField, fighterField, pilotField, merchantField;
    @FXML Button engineerPlus, engineerMinus, pilotPlus, pilotMinus, fighterPlus, fighterMinus, merchantPlus, merchantMinus;

    Pane root = null;
    GameController gameController = new GameController();
    Boolean nameCheck = false;
    public void setEasy() {
        gameController.person.setDifficulty("Easy");
        System.out.println(gameController.person.getDifficulty());
        remainMessage.setText("Skill points remaining:" + gameController.person.getSkillPoints());
    }
    public void setMedium() {
        gameController.person.setDifficulty("Medium");
        System.out.println(gameController.person.getDifficulty());
        remainMessage.setText("Skill points remaining:" + gameController.person.getSkillPoints());
    }
    public void setHard() {
        gameController.person.setDifficulty("Hard");
        remainMessage.setText("Skill points remaining:" + gameController.person.getSkillPoints());

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
            gameController.person.setName(nameField.getText());
        }
        else {
            nameBox.setText("Enter a name.");
            nameCheck = false;
        }
    }
    public void incrementUp(ActionEvent actionEvent) {
        if (gameController.person.getSkillPoints() > 0) {
            if (actionEvent.getSource() == engineerPlus) {
                gameController.person.setEngineeringPoints(gameController.person.getEngineeringPoints() + 1);
            } else if (actionEvent.getSource() == merchantPlus) {
                gameController.person.setMerchantPoints(gameController.person.getMerchantPoints() + 1);
            } else if (actionEvent.getSource() == pilotPlus) {
                gameController.person.setPilotPoints(gameController.person.getPilotPoints() + 1);
            } else if (actionEvent.getSource() == fighterPlus) {
                gameController.person.setFighterPoints(gameController.person.getFighterPoints() + 1);
            }
            gameController.person.setSkillPoints(gameController.person.getSkillPoints() - 1);
        }
        updateTextFields();
    }
    public void incrementDown(ActionEvent actionEvent){
        if (actionEvent.getSource() == engineerMinus) {
            gameController.person.setEngineeringPoints(gameController.person.getEngineeringPoints() - 1);
        } else if (actionEvent.getSource() == merchantMinus) {
            gameController.person.setMerchantPoints(gameController.person.getMerchantPoints() - 1);
        } else if (actionEvent.getSource() == pilotMinus) {
            gameController.person.setPilotPoints(gameController.person.getPilotPoints() - 1);
        } else if (actionEvent.getSource() == fighterMinus) {
            gameController.person.setFighterPoints(gameController.person.getFighterPoints() - 1);
        }
        gameController.person.setSkillPoints(gameController.person.getSkillPoints() + 1);
        updateTextFields();
    }
    public void updateTextFields() {
        engineeringField.setText(String.valueOf(gameController.person.getEngineeringPoints()));
        pilotField.setText(String.valueOf(gameController.person.getPilotPoints()));
        fighterField.setText(String.valueOf(gameController.person.getFighterPoints()));
        merchantField.setText(String.valueOf(gameController.person.getMerchantPoints()));
        remainPoints.setText("Remaining Points: " + String.valueOf(gameController.person.getSkillPoints()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
