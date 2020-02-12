package spacetraders;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {
    int width = 720;
    int height = 480;
    Stage stage = new Stage();
    public void changeStage(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}
