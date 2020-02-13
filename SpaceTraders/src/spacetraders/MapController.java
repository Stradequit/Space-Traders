package spacetraders;

import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import spacetraders.classes.Person;
import spacetraders.classes.Region;

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
        for (int i = 0; i < 10; i++) {
            int x = (int) randomBetween(0, 14);
            int y = (int) randomBetween(0, 14);
            Region region = new Region(("r" + i), "tech", "desc", x, y);
            regions.add(region);
            Button button = new Button(region.getName());
            button.setTooltip(new Tooltip(x + "," + y));
            regionPane.add(button, x, y);
        }
    }
}

