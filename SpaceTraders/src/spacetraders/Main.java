package spacetraders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spacetraders.controllers.GameController;

public class Main extends Application {
    private GameController gameController = new GameController();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("screens/Welcome.fxml"));
        //Initializes height and width variables
        int height = 480;
        int width = 720;
        //Initializes welcome screen
        Scene scene = new Scene(root, width, height);
        gameController.changeStage(scene);
    }
    public static void main(String[] args) {
        launch(args);
    }
}