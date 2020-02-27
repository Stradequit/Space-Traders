package spacetraders.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import spacetraders.classes.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class RegionController implements Initializable {
    private @FXML Label regionNameField;
    private @FXML Label regionTechField;
    private @FXML Label regionDescField;
    private @FXML ListView visitedRegionList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Person person = new Person();
        regionNameField.setText("Welcome to " + person.getCurrRegion().getName());
        System.out.println(person.getCurrRegion().getName());
        regionTechField.setText("Tech Level: " + person.getCurrRegion().getTechLevel().toString());
        regionDescField.setText("Description: " + person.getCurrRegion().getDescription());
    }

}
