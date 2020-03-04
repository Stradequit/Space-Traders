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
import java.util.concurrent.atomic.AtomicReference;


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
            button.setStyle("-fx-background-color: #707070");
            if (i == 0) {
                person.setCurrRegion(region);
                person.addVisited(region);
                button.setStyle("-fx-background-color: #ffc300");
            }
            AtomicReference<Double> xdiff =
                    new AtomicReference<>((double) (x - person.getCurrRegion().getCoords()[0]));
            AtomicReference<Double> ydiff =
                    new AtomicReference<>((double) (y - person.getCurrRegion().getCoords()[1]));
            AtomicReference<Double> dist =
                    new AtomicReference<>(
                            Math.pow(Math.pow(xdiff.get(), 2.0) + Math.pow(ydiff.get(), 2.0), 0.5));
            button.setTooltip(
                    new Tooltip(("(" + x + ", " + (14 - y) + ")" + "\n distance: " + dist)));
            button.setShape(new Circle(r));
            button.setMinSize(2 * r, 2 * r);
            button.setMaxSize(2 * r, 2 * r);
            buttons.add(button);
            button.setOnAction(event -> {
                Button visit = new Button("Visit");
                Button viewInfo = new Button("View Info");
                Button marketplace = new Button("Marketplace");
                int fuelCost = (int) (
                        35 * dist.get() - 10 * person.getPilotPoints()); //Fuel Cost formula
                if (fuelCost > 0) {
                    person.setFuelCost(fuelCost);
                } else {
                    person.setFuelCost(0);
                }
                visit.setTooltip(new Tooltip("Fuel Cost: \n" + person.getFuelCost()));
                if (!regions.get(buttons.indexOf(button)).equals(person.getCurrRegion())) {
                    visit.setWrapText(true);
                    regionPane.add(visit, x, (y + 1));
                    visit.setOnAction(event1 -> { //When visited
                        if (person.getFuelCost() < person.getCurrFuel()) {
                            person.setCurrFuel(person.getCurrFuel() - person.getFuelCost());
                            buttons.get(regions.indexOf(
                                    person.getCurrRegion(
                                    ))).setStyle("-fx-background-color: #00ff00");
                            button.setStyle("-fx-background-color: #ffc300");
                            person.setCurrRegion(regions.get(buttons.indexOf(button)));
                            person.addVisited(person.getCurrRegion());
                            for (int j = 0; j < 10; j++) { //Corrects Distances
                                xdiff.set((double)
                                        (regions.get(j).getCoords()[0]
                                                - person.getCurrRegion().getCoords()[0]));
                                ydiff.set((double)
                                        (regions.get(j).getCoords()[1]
                                                - person.getCurrRegion().getCoords()[1]));
                                dist.set(Math.pow(Math.pow(xdiff.get(), 2.0)
                                        + Math.pow(ydiff.get(), 2.0), 0.5));
                                buttons.get(j).setTooltip(
                                        new Tooltip("(" + x + ", " + (14 - y) + ")"
                                        + "\n distance: " + dist));
                            }
                            visit.setVisible(false);
                            marketplace.setWrapText(false);
                            regionPane.add(marketplace, (x - 1), y);
                            viewInfo.setWrapText(true);
                            regionPane.add(viewInfo, x, (y - 1));
                            marketplace.setOnAction(event2 -> { //When marketplace is clicked
                                marketplace.setVisible(false);
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

                            //When viewInfo is clicked
                            viewInfo.setOnAction(event3 -> {
                                viewInfo.setVisible(false);
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

                        } else {
                            try {
                                root[0] = FXMLLoader.load(getClass().getResource(
                                        "..//screens//notEnoughFuelError.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene fuelErrorPage = new Scene(root[0], 600, 400);
                            GameController gameController = new GameController();
                            gameController.changeStage(fuelErrorPage);
                        }
                        regionPane.getChildren().remove(visit);
                    });
                }

            });
            regionPane.add(button, x, y);
        }
    }
}


