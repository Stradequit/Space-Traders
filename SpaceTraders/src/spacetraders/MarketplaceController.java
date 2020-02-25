package spacetraders;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MarketplaceController implements Initializable {

    private @FXML Button buy;
    private @FXML Button sell;
    private @FXML Button fuelGoodConfirm;
    private @FXML Button cargoGoodConfirm;
    private @FXML Button healthGoodConfirm;
    private @FXML Button fighterGoodConfirm;
    private @FXML Label fuelGood;
    private @FXML Label cargoGood;
    private @FXML Label healthGood;
    private @FXML Label fighterGood;

    public static void basePrice() {

    }

//    public static void addGood(Good good, int i) {
//
//    }
//
//    public static void removeGood(Good good, int i) {
//
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buy.setText("Buy");
        sell.setText("Sell");


    }
}
