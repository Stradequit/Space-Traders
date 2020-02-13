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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegionController implements Initializable {
    @FXML Label regionNameField;
    @FXML Label regionCoordinatesField;
    @FXML Label regionTechLevel;
    @FXML ListView visitedRegionList;

    Pane root = null;
    public void setRegionNameField() {
        regionNameField.setText("");
    }
    public void setRegionTechLevel() {
        regionTechLevel.setText("");
    }
    public void setRegionCoordinatesField() {
        regionCoordinatesField.setText("");
    }
    public void setVisitedRegionList() {
        //ObservableList<T> regions = ...            list of regions visited
        //visitedRegionList.setItems(regions);
    }

    public void travelUniverse (ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Screens/Region.fxml"));   // placeholder for now
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene universeCreation = new Scene(root, 720, 480);
        GameController universe = new GameController();
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        universe.changeStage(universeCreation);
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
