package spacetraders.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import spacetraders.classes.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class FuelErrorController implements Initializable {
    private @FXML Label currFuel;
    private @FXML Label fuelCost;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person person = new Person();
        currFuel.setText("" + person.getCurrFuel());
        fuelCost.setText("" + person.getFuelCost());
    }
}
