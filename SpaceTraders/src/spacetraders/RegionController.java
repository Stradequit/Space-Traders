package spacetraders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spacetraders.classes.Person;
import spacetraders.classes.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegionController implements Initializable {
    @FXML Label regionNameField, regionTechField, regionDescField;
    @FXML ListView visitedRegionList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Person person = new Person ();
        regionNameField.setText("Welcome to " + person.getCurrRegion().getName());
        System.out.println(person.getCurrRegion().getName());
        regionTechField.setText("Tech Level: " + person.getCurrRegion().getTechLevel());
        regionDescField.setText("Description: " + person.getCurrRegion().getDescription());
    }

}
