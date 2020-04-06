package spacetraders.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import spacetraders.classes.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class ShipController implements Initializable {
    private @FXML Label name;
    private @FXML Label health;
    private @FXML Label cargoCapacity;
    private @FXML Label fuelCapacity;
    private @FXML Label itemInventory;
    private @FXML Label currFuel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person person = new Person();
        name.setText(person.getShip().getName());
        health.setText("" + person.getShip().getMaxHealth());
        cargoCapacity.setText("" + person.getShip().getCargoCapacity());
        fuelCapacity.setText("" + person.getShip().getFuelCapacity());
        itemInventory.setText(person.getShip().getItemInventory().toString());
        currFuel.setText(person.getShip().getFuelCapacity() + "");
    }
}
