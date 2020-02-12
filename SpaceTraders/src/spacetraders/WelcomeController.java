package spacetraders;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import spacetraders.GameController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    Pane root = null;
    @FXML public void openConfigScreen(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Screens/characterCreation.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Button Pressed");
        Scene characterCreation = new Scene(root, 720, 480);
        GameController gameController = new GameController();
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        gameController.changeStage(characterCreation);
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
