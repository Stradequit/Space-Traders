package spacetraders.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import spacetraders.classes.Encounter;
import spacetraders.classes.Good;
import spacetraders.classes.Person;
import spacetraders.classes.Ship;

import java.util.Map;


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
        Person person = new Person();
        Ship ship = person.getShip();
        switch (encounter) {
            case BANDIT:
                if (person.getCredits() >= 15) {
                    person.setCredits(person.getCredits() - 15);
                    encounterDescription.setText("\"Thanks, chump! Now scram!\" [You lose 15 credits]");
                } else if (ship.getItemInventory().getSize() != 0) {
                    Map<Good, Integer> map = ship.getItemInventory().getGoodMap();
                    for (Good good : map.keySet()) {
                        ship.removeItem(good);
                        encounterDescription.setText("\"Aww, you can't pay the toll? Then pay with your hard earned" +
                                "items!\" [The bandit steals literally all of your items]");
                    }
                } else {
                    ship.setCurrHealth(ship.getCurrHealth() - 1);
                    encounterDescription.setText("\"Boiii, you broke as hell. *stabs you*\" [You take 1 damage]");
                }
                person.travel();
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
        optionOneButton.setVisible(false);
        optionTwoButton.setVisible(false);
        optionThreeButton.setVisible(false);
        optionFourButton.setVisible(false);
    }

    public void optionTwo(ActionEvent actionEvent) {
        Person person = new Person();
        Ship ship = person.getShip();
        switch (encounter) {
            case BANDIT:
                boolean won = wonFight();
                if (wonFight()) {
                    encounterDescription.setText("\"AGH! Take whatever you want, just please don't hit me again!\"" +
                            " [You take 25 coins from the bandit and continue your journey]");
                } else {
                    person.setCredits(0);
                    ship.setCurrHealth(ship.getCurrHealth() - 1);
                    encounterDescription.setText("\"Hehehe you thought you were tough, eh? Well get a load of this!\"" +
                            " [The bandit knocks you unconscious and takes all of your money." +
                            " You also lose 1 health]");
                }
                person.travel();
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
        optionOneButton.setVisible(false);
        optionTwoButton.setVisible(false);
        optionThreeButton.setVisible(false);
        optionFourButton.setVisible(false);
    }

    public void optionThree(ActionEvent actionEvent) {
        Person person = new Person();
        Ship ship = person.getShip();
        switch (encounter) {
            case BANDIT:
                if (didFlee()) {
                    encounterDescription.setText("[You fled successfully].");
                } else {
                    person.setCredits(0);
                    ship.setCurrHealth(ship.getCurrHealth() - 1);
                    encounterDescription.setText("\"Aww...wittle baby twying to wun to mama? How pathetic.\" " +
                            "[The bandit knocks you unconscious and takes all of your money." +
                            " You also lose 1 health]");
                    person.travel();
                }
                ;
            case POLICE:
                ;
            case TRADER:
                ;
        }
        optionOneButton.setVisible(false);
        optionTwoButton.setVisible(false);
        optionThreeButton.setVisible(false);
        optionFourButton.setVisible(false);
    }

    public void optionFour(ActionEvent actionEvent) { //only for trader
        optionOneButton.setVisible(false);
        optionTwoButton.setVisible(false);
        optionThreeButton.setVisible(false);
        optionFourButton.setVisible(false);
    }

    public boolean wonFight() {
        Person person = new Person();
        double random = (Math.random() * ((100 - 1) + 1)) + 1;
        switch (encounter) {
            case BANDIT:
                if (random < 50.0 + (5 * person.getFighterPoints())) {
                    return true;
                } else { return false; }
            case POLICE:
                if (random < 25.0 + (5 * person.getFighterPoints())) {
                    return true;
                } else { return false; }
            default:
                return false;
        }
    }

    public boolean didFlee() {
        Person person = new Person();
        double random = (Math.random() * ((100 - 1) + 1)) + 1;
        switch (encounter) {
            case BANDIT:
                if (random < 50.0 + (5 * person.getPilotPoints())) {
                    return true;
                } else { return false; }
            case POLICE:
                if (random < 25.0 + (5 * person.getPilotPoints())) {
                    return true;
                } else { return false; }
            default:
                return false;
        }
    }

    public void initialize() {
        if (!encounter.equals(Encounter.TRADER)) {
            optionFourButton.setVisible(false);
        }
        encounterLabel.setText(encounter.toString());
        encounterDescription.setText(encounter.getDescription());
        encounterDescription.setWrapText(true);
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
