package spacetraders.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import spacetraders.classes.Person;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegionController implements Initializable {
    private @FXML Label regionNameField, regionTechField, regionDescField;
    private @FXML Button marketplace;
    final Pane[] root = {null};

    public void openMarketplace(javafx.event.ActionEvent actionEvent) {
        try {
            root[0] = FXMLLoader.load(getClass().getResource(
                    "..//screens//Marketplace.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene marketPage = new Scene(root[0], 720, 360);
        GameController gameController = new GameController();
        gameController.changeStage(marketPage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Person person = new Person();
        regionNameField.setText("Welcome to " + person.getCurrRegion().getName());
        System.out.println(person.getCurrRegion().getName());
        regionTechField.setText(person.getCurrRegion().getTechLevel().toString());
        regionDescField.setText(person.getCurrRegion().getDescription());
    }

}
