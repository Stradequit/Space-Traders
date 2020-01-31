package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Initializes height and width variables
        int height = 480;
        int width = 720;

        //Initializes welcome screen
        primaryStage.setTitle("Space Traders");
        Button startButton = new Button("Start");
        BorderPane startScreenPane = new BorderPane();
        startScreenPane.setCenter(startButton);
        Scene startScreen = new Scene(startScreenPane, width, height);
        primaryStage.setScene(startScreen);
        primaryStage.show();

        //Initializes the Scene for Configuration Screen
        BorderPane configurationPane = new BorderPane();
        Scene configurationScreen = new Scene(configurationPane, width,height);
        Button configurationScreenDone = new Button("Done");
        configurationPane.setBottom(configurationScreenDone);

        //Initialize the Scene for Character Sheet Screen
        BorderPane characterSheetPane = new BorderPane();
        Scene characterSheetScreen = new Scene(characterSheetPane, width, height);
        
        //Event for Welcome Screen Button and Configuration Screen Button
        startButton.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                primaryStage.setScene(configurationScreen);
            }
        });
        configurationScreenDone.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                primaryStage.setScene(characterSheetScreen);
            }
       });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
