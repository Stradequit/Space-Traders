package spacetraders;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class CharacterPageController {
    Parent root;
    public void openMap(javafx.event.ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Screens/mapPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene mapPage = new Scene(root, 720, 480);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        gameController.changeStage(mapPage);
        stage.close();
    }
}
