package spacetraders.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import spacetraders.classes.Person;
import spacetraders.classes.Region;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MapController implements Initializable {
    private @FXML StackPane stackPane;
    private @FXML GridPane regionPane;


    public static double randomBetween(double min, double max) {
        double x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
            Button button = new Button(region.getId());
            button.setWrapText(true);
            if (i == 0) {
                button.setStyle("-fx-background-color: #ffc300");
                person.setCurrRegion(region);
                person.addVisited(region);
            } else {
                button.setStyle("-fx-background-color: #707070");
            }
            double xdiff = Double.valueOf(x - person.getCurrRegion().getCoordinates()[0]);
            double ydiff = Double.valueOf(y - person.getCurrRegion().getCoordinates()[1]);
            double distance = Math.pow(Math.pow(xdiff, 2.0) + Math.pow(ydiff, 2.0), 0.5);
            button.setTooltip(new Tooltip("(" + x + ", " + (14 - y) + ")"
                    + "\n distance: " + distance));
            button.setShape(new Circle(r));
            button.setMinSize(2 * r, 2 * r);
            button.setMaxSize(2 * r, 2 * r);
            buttons.add(button);
            button.setOnAction(event -> {
                final boolean[] clicked = {false};
                Button visit = new Button("Visit");
                Button viewInfo = new Button("View Info");
                Button marketplace = new Button("Marketplace");
                if (!regions.get(buttons.indexOf(button)).equals(person.getCurrRegion())) {
                    visit.setWrapText(true);
                    regionPane.add(visit, x, (y + 1));
                    visit.setOnAction(event1 -> {
                        buttons.get(regions.indexOf(
                                person.getCurrRegion())).setStyle("-fx-background-color: #00ff00");
                        button.setStyle("-fx-background-color: #ffc300");
                        person.setCurrRegion(regions.get(buttons.indexOf(button)));
                        person.addVisited(person.getCurrRegion());
                        regionPane.getChildren().remove(visit);
                    });
                }

                if (person.visitedContains((regions.get(buttons.indexOf(button))))) {
                    viewInfo.setWrapText(true);
                    marketplace.setWrapText(false);
                    regionPane.add(viewInfo, x, (y - 1));
                    regionPane.add(marketplace, (x - 1), y);
                    marketplace.setOnAction(event2 -> {
                        try {
                            root[0] = FXMLLoader.load(getClass().getResource(
                                    "..//screens//Marketplace.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene marketPage = new Scene(root[0], 720, 360);
                        GameController gameController = new GameController();
                        gameController.changeStage(marketPage);
                        regionPane.getChildren().remove(marketplace);
                    });
                    viewInfo.setOnAction(event3 -> {
                        try {
                            root[0] = FXMLLoader.load(getClass().getResource(
                                    "..//screens//RegionPage.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene regionPage = new Scene(root[0], 720, 480);
                        GameController gameController = new GameController();
                        gameController.changeStage(regionPage);
                        regionPane.getChildren().remove(viewInfo);
                    });
                }
            });
            regionPane.add(button, x, y);
        }
    }
}


