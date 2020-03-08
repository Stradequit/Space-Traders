package spacetraders.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import spacetraders.classes.Encounter;
import spacetraders.classes.Person;


public class encounterController {
    @FXML
    Label encounterLabel, encounterDescription;
    @FXML
    Button optionOneButton, optionTwoButton, optionThreeButton, optionFourButton;
    @FXML
    ImageView encounterImage, scroll;
    private static Encounter encounter;
    public static Encounter getEncounter(Encounter encounter) {
        return encounter;
    }
    public static void setEncounter(Encounter encounter) {
        encounterController.encounter = encounter;
    }

    public void optionOne(ActionEvent actionEvent) {
        switch (encounter) {
            case BANDIT:
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
    }

    public void optionTwo(ActionEvent actionEvent) {
        switch (encounter) {
            case BANDIT:
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
    }

    public void optionThree(ActionEvent actionEvent) {
        switch (encounter) {
            case BANDIT:
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
    }

    public void optionFour(ActionEvent actionEvent) {
        switch (encounter) {
            case BANDIT:
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
    }
    public void initialize() {
        encounterLabel.setText(encounter.toString());
        encounterDescription.setText(encounter.getDescription());
        optionOneButton.setText(encounter.getOptionOneText());
        optionTwoButton.setText(encounter.getOptionTwoText());
        optionThreeButton.setText(encounter.getOptionThreeText());
        optionFourButton.setText(encounter.getOptionFourText());
        encounterImage.setImage(encounter.getImage());
        String path = encounterController.class.getResource("..//images//Scroll.jpg").toString();
        Image scrollImage = new Image(path);
        scroll.setImage(scrollImage);
    }
}
