package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Initializes height and width variables
        int height = 480;
        int width = 720;
        //Initializes welcome screen
        primaryStage.setTitle("Space Traders");
        BorderPane startScreenPane = new BorderPane();
        startScreenPane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#301934"),
                                                                CornerRadii.EMPTY, Insets.EMPTY)));

        //Background for welcome screen
        ImageView background = new ImageView(new Image("file:src/sample/Background.png"));
        startScreenPane.setCenter(background);

        //Start Button
        HBox buttonBox = new HBox();
        Button startButton = new Button("START");
        startButton.setStyle("-fx-background-color: #301934;"
                            + "-fx-font-size: 3em;"
                            + "-fx-text-fill: #FFFFFF;"
                            + "-fx-font-weight: bold");
        startButton.setPrefSize(150, 50);
        buttonBox.getChildren().add(startButton);
        buttonBox.setAlignment(Pos.TOP_CENTER);
        startScreenPane.setBottom(buttonBox);

        Scene startScreen = new Scene(startScreenPane, width, height);
        primaryStage.setScene(startScreen);
        primaryStage.show();

        //Initializes the Scene for Configuration Screen
        BorderPane configurationPane = new BorderPane();
        Scene configurationScreen = new Scene(configurationPane, width, height);
        Button configurationScreenDone = new Button("Done");
        configurationPane.setBottom(configurationScreenDone);
        Person person = new Person();
        //Initialize the Scene for Character Sheet Screen
        HBox characterSheetPane = new HBox(8);
        Label nameLabel = new Label("Name: " + person.getName());
        Label difficultyLabel = new Label("Difficulty: " + person.getDifficulty());
        Label creditsLabel = new Label("Credits: " + String.valueOf(person.getCredits()));
        VBox charInfo = new VBox(8);
        charInfo.getChildren().addAll(nameLabel, difficultyLabel, creditsLabel);
        Label engineeringLabel = new Label("Engineering: " + person.getEngineeringPoints());
        Label fighterLabel = new Label("Fighter: " + person.getFighterPoints());
        Label pilotLabel = new Label("Pilot: " + person.getPilotPoints());
        Label merchantLabel = new Label("Merchant: " + person.getMerchantPoints());
        VBox skillInfo = new VBox(8);
        skillInfo.getChildren().addAll(engineeringLabel, fighterLabel, pilotLabel, merchantLabel);
        characterSheetPane.getChildren().addAll(charInfo, skillInfo);
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
