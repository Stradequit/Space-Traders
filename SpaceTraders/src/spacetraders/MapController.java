package spacetraders;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import spacetraders.classes.Person;
import spacetraders.classes.Region;
import spacetraders.GameController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MapController implements Initializable {
    @FXML GridPane regionPane;


    public static double randomBetween(double min, double max) {
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Region> regions = new ArrayList<Region>(0);
        ArrayList<Button> buttons = new ArrayList<Button>(0);
        double r=20;
        Person person = new Person();
        for (int i = 0; i < 10; i++) {
            int x = (int) randomBetween(0, 14);
            int y = (int) randomBetween(0, 14);
            Region region = new Region(("" + i), "tech", "desc", x, y);
            regions.add(region);
            Button button = new Button(region.getName());
            button.setTooltip(new Tooltip(x + "," + y));
            if (i == 0) {
                button.setStyle("-fx-background-color: #ffc300");
                person.setCurrRegion(region);
            } else {
                button.setStyle("-fx-background-color: #707070");
            }
            button.setShape(new Circle(r));
            button.setMinSize(2 * r, 2 * r);
            button.setMaxSize(2 * r, 2 * r);
            buttons.add(button);
            button.setOnAction(event -> {
                buttons.get(regions.indexOf(person.getCurrRegion())).setStyle("-fx-background-color: #707070");
                button.setStyle("-fx-background-color: #ffc300");
                person.setCurrRegion(regions.get(buttons.indexOf(button)));
            });
            regionPane.add(button, x, y);
        }
    }
}


