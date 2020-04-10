package spacetraders.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import spacetraders.classes.Encounter;
import spacetraders.classes.Person;
import spacetraders.classes.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class MapController implements Initializable {
    private @FXML StackPane stackPane;
    private @FXML GridPane regionPane;
    private @FXML Button police;
    private @FXML Button bandit;
    private @FXML Button trader;
    private static Region selectedRegion;
    Random random = new Random();

    public Region getSelectedRegion() {
        return selectedRegion;
    }
    public static double randomBetween(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int randomInteger = random.nextInt(10);
        String path = MapController.class.getResource("..//images//spaceBG.jpg").toString();
        Image image = new Image(path);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(800);
        imageView.setFitWidth(1350);
        stackPane.getChildren().add(imageView);
        imageView.toBack();
        GameController gc = new GameController();
        Region[] regionArray = gc.getRegionArray();
        ArrayList<Region> regions = new ArrayList<Region>(0);
        ArrayList<Button> buttons = new ArrayList<Button>(0);
        double r = 20;
        Person person = new Person();
        final Pane[] root = {null};
        Button toShipScreen = new Button("Ship Status");
        toShipScreen.setOnAction(event0 -> {
            try {
                root[0] = FXMLLoader.load(getClass().getResource(
                        "..//screens//Ship.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene shipPage = new Scene(root[0], 600, 400);
            GameController gameController = new GameController();
            gameController.changeStage(shipPage);
        });
        regionPane.add(toShipScreen, 0, 14);
        for (int i = 0; i < 10; i++) {
            int x = (int) randomBetween(1, 13);
            int y = (int) randomBetween(1, 13);
            regionArray[i].setXCoordinate(x);
            regionArray[i].setYCoordinate(y);
            Region region = regionArray[i];
            regions.add(region);
            Button button = new Button("");
            button.setWrapText(true);
            button.setStyle("-fx-background-color: #707070");
            button.setShape(new Circle(r));
            button.setMinSize(2 * r, 2 * r);
            button.setMaxSize(2 * r, 2 * r);
            if (i == 0) {
                person.setCurrRegion(region);
                person.addVisited(region);
                button.setStyle("-fx-background-color: #ffc300");
                button.setShape(new Rectangle(20.0, 20.0));
                person.setCurrButton(button);
            }
            buttons.add(button);
            button.setOnAction(event -> {
                person.setPrevRegion(person.getCurrRegion());
                person.setPrevButton(person.getCurrButton());
                person.setNextRegion(regions.get(buttons.indexOf(button)));
                person.setNextButton(button);
                //If not currRegion
                if (!regions.get(buttons.indexOf(button)).equals(person.getCurrRegion())) {
                    //If haven't visited
                    if (!person.visitedContains((regions.get(buttons.indexOf(button))))) {
                        try {
                            root[0] = FXMLLoader.load(getClass().getResource(
                                    "..//screens//UnknownVisit.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene unknownVisit = new Scene(root[0], 600, 400);
                        GameController gameController = new GameController();
                        gameController.changeStage(unknownVisit);
                    } else {
                        try {
                            root[0] = FXMLLoader.load(getClass().getResource(
                                    "..//screens//KnownVisit.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene knownVisit = new Scene(root[0], 600, 400);
                        GameController gameController = new GameController();
                        gameController.changeStage(knownVisit);
                    }
                } else {
                    try {
                        root[0] = FXMLLoader.load(getClass().getResource(
                                "..//screens//RegionPage.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene regionPage = new Scene(root[0], 720, 480);
                    GameController gameController = new GameController();
                    gameController.changeStage(regionPage);
                }
            });
            regionPane.add(button, x, y);
        }
        selectedRegion = regions.get(randomInteger);
        System.out.println(selectedRegion.getName());
    }
    public void encounter(ActionEvent actionEvent) {
        Person person = new Person();
        if (actionEvent.getSource() == bandit) {
            EncounterController.setEncounter(Encounter.BANDIT);
        }
        if (actionEvent.getSource() == trader) {
            EncounterController.setEncounter(Encounter.TRADER);
        }
        if (actionEvent.getSource() == police) {
            EncounterController.setEncounter(Encounter.POLICE);
            Encounter.POLICE.setDescription("\"STOP IN THE NAME OF THE LAW, MISCREANT. "
                    + "YOU ARE IN POSSESSION OF STOLEN GOODS. "
                    + "PLEASE TURN THEM OVER IMMEDIATELY OR BE PUNISHED TO THE FULLEST"
                    + " EXTENT OF THE LAW.\" [The officer demands "
                    + "that you turn over the following: " + person.getShip().getItemInventory().
                    toString() + "]");
        }
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(
                    "..//screens//encounterPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene encounterPage = new Scene(root, 600, 400);
        GameController gameController = new GameController();
        gameController.changeStage(encounterPage);
    }

    public void takeDamage(ActionEvent actionEvent) {
        Person person = new Person();
        person.getShip().takeDamage();
    }
}


