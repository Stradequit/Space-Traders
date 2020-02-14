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
    @FXML Label regionNameField, regionCoordinatesField, regionTechLevel, regionDescription;
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
            root = FXMLLoader.load(getClass().getResource("Screens/mapPage.fxml"));
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
        Person person = new Person ();
        regionNameField.setText(person.getCurrRegion().getName());
        regionCoordinatesField.setText(person.getCurrRegion().getCoordinates());
        regionTechLevel.setText(person.getCurrRegion().getTechLevel());
        regionDescription.setText(person.getCurrRegion().getDescription());
        travelUniverse(ActionEvent e).isClicked();

        }

    }

}
