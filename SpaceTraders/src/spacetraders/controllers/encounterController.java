package spacetraders.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import spacetraders.classes.Encounter;
import spacetraders.classes.Person;

public class encounterController {
    @FXML
    Label encounterLabel, encounterDescription;
    @FXML
    Button optionOneButton, optionTwoButton, optionThreeButton, optionFourButton;
    Encounter encounter = Person.getCurrentEncounter();
    public void optionOne(ActionEvent actionEvent) {
    }

    public void optionTwo(ActionEvent actionEvent) {
    }

    public void optionThree(ActionEvent actionEvent) {
    }

    public void optionFour(ActionEvent actionEvent) {
    }
    public void initialize() {
        encounterLabel.setText("WIP");
        encounterDescription.setText(encounter.getDescription());
        optionOneButton.setText(encounter.getOptionOneText());
        optionTwoButton.setText(encounter.getOptionTwoText());
        optionThreeButton.setText(encounter.getOptionThreeText());
        optionFourButton.setText(encounter.getOptionFourText());
    }
}
