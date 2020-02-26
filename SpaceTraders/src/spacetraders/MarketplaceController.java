package spacetraders;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import spacetraders.classes.Good;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MarketplaceController implements Initializable {

    private @FXML Button fuelGoodConfirm;
    private @FXML Button cargoGoodConfirm;
    private @FXML Button healthGoodConfirm;
    private @FXML Button fighterGoodConfirm;
    private @FXML Button miscGoodConfirm;
    private @FXML Button buy;
    private @FXML Button sell;
    private @FXML Label itemName;
    private @FXML Label numInv;
    private @FXML Label buyPrice;
    private @FXML Label sellPrice;
    private @FXML Label descItem;


    public void buyItem() {

    }
    public void sellItem() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Pick goods based on Tech Level
        Button[] buttons = new Button[]{fuelGoodConfirm, cargoGoodConfirm, healthGoodConfirm,
            fighterGoodConfirm, miscGoodConfirm};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnAction(buttonEvent -> {
                itemName.setText("ITEM NAME GOES HERE");
                descItem.setText("ITEM DESC GOES HERE");
                buyPrice.setText("BUY PRICE GOES HERE");
                sellPrice.setText("SELL PRICE GOES HERE");
                numInv.setText("NUMBER GOES HERE");
            });
        }
    }
}
