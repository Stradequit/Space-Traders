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
                    }
                    encounterDescription.setText("\"Aww, you can't pay the toll? Then pay with your hard earned" +
                            "items!\" [The bandit steals literally all of your items]");
                } else {
                    ship.setCurrHealth(ship.getCurrHealth() - 1);
                    encounterDescription.setText("\"Boiii, you broke as hell. *stabs you*\" [You take 1 damage]");
                }
                person.travel();
                ;
            case POLICE:
                ship.removeItem(person.getRandomGood());
                encounterDescription.setText("\"Thank you, citizen. I'll be taking those." +
                        " Consider this time a warning.\" [You lose " + person.getRandomGood().getName() +"]");
                person.travel();
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
                if (wonFight()) {
                    encounterDescription.setText("\"Please stop! I won't tell the rest of the force! " +
                            "You can even keep your stuff!\"" + " [You continue your journey]");
                } else {
                    ship.removeItem(person.getRandomGood());
                    encounterDescription.setText("\"Trying to assault an officer, eh? I'll take those stolen goods. " +
                            "Now, get out of here before I arrest you. \" " +
                            "[You lose " + person.getRandomGood().getName() +"]");
                }
                person.travel();
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
                if (didFlee()) {
                    encounterDescription.setText("[You fled successfully].");
                    person.travel();
                } else {
                    person.setCredits(person.getCredits() - 15);
                    ship.removeItem(person.getRandomGood());
                    ship.setCurrHealth(ship.getCurrHealth() - 1);
                    encounterDescription.setText("\"Trying to evade the law is a 15 " +
                            "credit fine, and I'll be taking those items anyway.\" [You lose 15 credits and " +
                            person.getRandomGood().getName() + "]");
                }
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
