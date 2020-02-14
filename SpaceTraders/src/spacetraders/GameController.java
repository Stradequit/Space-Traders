package spacetraders;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import spacetraders.classes.Person;
import spacetraders.classes.Region;

import java.util.ArrayList;

public class GameController {
    int width = 720;
    int height = 480;
    Stage stage = new Stage();

    public void changeStage(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    Person person = new Person();
}
