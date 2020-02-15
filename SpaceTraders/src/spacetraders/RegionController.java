package spacetraders;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import spacetraders.classes.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class RegionController implements Initializable {
    @FXML Label regionNameField;
    @FXML Label regionTechField;
    @FXML Label regionDescField;
    @FXML ListView visitedRegionList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Person person = new Person();
        regionNameField.setText("Welcome to " + person.getCurrRegion().getName());
        System.out.println(person.getCurrRegion().getName());
        regionTechField.setText("Tech Level: " + person.getCurrRegion().getTechLevel());
        regionDescField.setText("Description: " + person.getCurrRegion().getDescription());
    }

}
