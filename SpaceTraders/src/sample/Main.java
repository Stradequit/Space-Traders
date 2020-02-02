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
        BorderPane border = new BorderPane();
        BorderPane bottom = new BorderPane();
        BorderPane left = new BorderPane();
        Person person = new Person();
        border.setBottom(bottom);
        border.setLeft(left);
        Scene configurationScreen = new Scene(border, width,height);
        Button configurationScreenDone = new Button("Next");
        configurationScreenDone.setPrefSize(100, 40);
        //This is for the name entry box
        HBox hboxName = new HBox();
        hboxName.setPadding(new Insets(15, 12, 15, 12));
        hboxName.setSpacing(10);
        hboxName.setStyle("-fx-background-color: #336699;");
        Label nameEntryLabel = new Label("Name: ");
        TextField nameEntry = new TextField();
        Label checkNameEntry = new Label("");
        Button nameSubmit = new Button("Submit");
        nameSubmit.setPrefSize(100, 20);
        hboxName.getChildren().addAll(nameEntryLabel, nameEntry, nameSubmit, checkNameEntry);
        border.setTop(hboxName);
        hboxName.setAlignment(Pos.TOP_LEFT);
        //This is for the difficulty select box
        HBox hboxDiff = new HBox();
        hboxDiff.setPadding(new Insets(15, 12, 15, 12));
        hboxDiff.setSpacing(10);
        Label diffChoose = new Label("Choose your difficulty:");
        Button diffEasy = new Button("Easy");
        diffEasy.setPrefSize(100, 20);
        Button diffMed = new Button("Medium");
        diffMed.setPrefSize(100, 20);
        Button diffHard = new Button("Hard");
        diffHard.setPrefSize(100, 20);
        Label diffChoice = new Label("");
        hboxDiff.getChildren().addAll(diffChoose, diffEasy, diffMed, diffHard, diffChoice);
        final String[] diff = {""};
        final Integer[] credit = {0};
        final Integer[] skill = {0};
        //This is for incrementing skill points
        final Integer[] eng = {0};
        final Integer[] fig = {0};
        final Integer[] pil = {0};
        final Integer[] mer = {0};
        VBox vboxSkill = new VBox(50);
        HBox engH = new HBox(8);
        HBox figH = new HBox(8);
        HBox pilH = new HBox(8);
        HBox merH = new HBox(8);
        Label engL = new Label("        Engineer:");
        Label figL = new Label("        Fighter:");
        Label pilL = new Label("        Pilot:");
        Label merL = new Label("        Merchant:");
        Button engMinus = new Button("-");
        Button engPlus = new Button("+");
        Label engCount = new Label("0");
        engH.getChildren().addAll(engL, engMinus, engCount, engPlus);
        Button figMinus = new Button("-");
        Button figPlus = new Button("+");
        Label figCount = new Label("0");
        figH.getChildren().addAll(figL, figMinus, figCount, figPlus);
        Button pilMinus = new Button("-");
        Button pilPlus = new Button("+");
        Label pilCount = new Label("0");
        pilH.getChildren().addAll(pilL, pilMinus, pilCount, pilPlus);
        Button merMinus = new Button("-");
        Button merPlus = new Button("+");
        Label merCount = new Label("0");
        merH.getChildren().addAll(merL, merMinus, merCount, merPlus);
        vboxSkill.getChildren().addAll(engH, figH, pilH, merH);
        // This is for if you messed up your skills
        Label ripma = new Label("Must have zero skill points remaining to proceed");

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
                if (skill[0] == 0){
                    person.setName(nameEntry.getText());
                    person.setDifficulty(diff[0]);
                    person.setCredits(credit[0]);
                    person.setEngineeringPoints(eng[0]);
                    person.setFighterPoints(fig[0]);
                    person.setPilotPoints(pil[0]);
                    person.setMerchantPoints(mer[0]);
                    primaryStage.setScene(initCharSheet());
                } else {
                    bottom.setRight(ripma);
                }

            }

            private Scene initCharSheet() {
                HBox characterSheetPane = new HBox(8);
                Label nameLabel = new Label("Name: " + person.getName());
                Label difficultyLabel = new Label("Difficulty: " + person.getDifficulty());
                Label creditsLabel = new Label("Credits: " + person.getCredits());
                VBox charInfo = new VBox(8);
                charInfo.getChildren().addAll(nameLabel,difficultyLabel,creditsLabel);
                Label engineeringLabel = new Label("Engineering: " + person.getEngineeringPoints());
                Label fighterLabel = new Label("Fighter: " + person.getFighterPoints());
                Label pilotLabel = new Label("Pilot: " + person.getPilotPoints());
                Label merchantLabel = new Label("Merchant: " + person.getMerchantPoints());
                VBox skillInfo = new VBox(8);
                skillInfo.getChildren().addAll(engineeringLabel,fighterLabel,pilotLabel,merchantLabel);
                characterSheetPane.getChildren().addAll(charInfo, skillInfo);
                Scene characterSheetScreen = new Scene(characterSheetPane, width, height);
                return characterSheetScreen;
            }
        });
        nameSubmit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if ((nameEntry.getText() != null && !nameEntry.getText().isEmpty())) {
                    checkNameEntry.setText("        Your name is: " + nameEntry.getText());
                    left.setTop(hboxDiff);
                    hboxDiff.setAlignment(Pos.CENTER_LEFT);
                } else {
                    checkNameEntry.setText("        You did not enter a name.");
                }
            }
        });
        diffEasy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (diff[0] == "Easy") {
                } else if (diff[0] == "Medium") {
                    skill[0] += 4;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                    diff[0] = "Easy";
                    credit[0] = 1000;
                } else if (diff[0] == "Hard") {
                    skill[0] += 8;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                    diff[0] = "Easy";
                    credit[0] = 1000;
                } else {
                    diff[0] = "Easy";
                    credit[0] = 1000;
                    skill[0] = 16;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                }
                left.setCenter(vboxSkill);
            }
        });
        diffMed.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (diff[0] == "Medium") {
                } else if (diff[0] == "Easy") {
                    skill[0] -= 4;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                    diff[0] = "Medium";
                    credit[0] = 500;
                } else if (diff[0] == "Hard") {
                    skill[0] += 4;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                    diff[0] = "Medium";
                    credit[0] = 500;
                } else {
                    diff[0] = "Medium";
                    credit[0] = 500;
                    skill[0] = 12;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                }
                left.setCenter(vboxSkill);
            }
        });
        diffHard.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                if (diff[0] == "Hard") {
                } else if (diff[0] == "Easy") {
                    skill[0] -= 8;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                    diff[0] = "Hard";
                    credit[0] = 100;
                } else if (diff[0] == "Medium") {
                    skill[0] -= 4;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                    diff[0] = "Hard";
                    credit[0] = 100;
                } else {
                    diff[0] = "Hard";
                    credit[0] = 100;
                    skill[0] = 8;
                    diffChoice.setText(skill[0] + " Skill Points Left");
                }
                left.setCenter(vboxSkill);
            }
        });
        engMinus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ++skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                --eng[0];
                engCount.setText(eng[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        figMinus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ++skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                --fig[0];
                figCount.setText(fig[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        pilMinus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ++skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                --pil[0];
                pilCount.setText(pil[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        merMinus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                ++skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                --mer[0];
                merCount.setText(mer[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        engPlus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                --skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                ++eng[0];
                engCount.setText(eng[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        figPlus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                --skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                ++fig[0];
                figCount.setText(fig[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        pilPlus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                --skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                ++pil[0];
                pilCount.setText(pil[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });
        merPlus.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                --skill[0];
                diffChoice.setText(skill[0] + " Skill Points Left");
                ++mer[0];
                merCount.setText(mer[0] + "");
                bottom.setRight(configurationScreenDone);
            }
        });

    }





    public static void main(String[] args) {
        launch(args);
    }
}
