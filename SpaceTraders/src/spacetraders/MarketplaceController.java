package spacetraders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import spacetraders.classes.Person;
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
    public void showItem(ActionEvent actionEvent) {
        Person person = new Person();
        Good good = null;
        if (actionEvent.getSource() == fuelGoodConfirm) {           // button is for fuel
            good = person.getCurrRegion().getTechLevel().getFuel();
        }
        if (actionEvent.getSource() == cargoGoodConfirm) {
            good = person.getCurrRegion().getTechLevel().getCapacity();
        }
        if (actionEvent.getSource() == healthGoodConfirm) {
            good = person.getCurrRegion().getTechLevel().getDefense();
        }
        if (actionEvent.getSource() == fighterGoodConfirm) {
            good = person.getCurrRegion().getTechLevel().getWeapon();
        }
        if (actionEvent.getSource() == miscGoodConfirm) {
            good = person.getCurrRegion().getTechLevel().getFuel();
        }
        int buyPriceInt = good.getBasePrice() - ((person.getMerchantPoints()));
        int sellPriceInt = good.getBasePrice() + (((person.getMerchantPoints()))) - 20;
        itemName.setText(good.getName());
        descItem.setText(good.getModStat() + " " + good.getModFactor());
        buyPrice.setText(String.valueOf(buyPriceInt));
        sellPrice.setText(String.valueOf(sellPriceInt));
        numInv.setText(String.valueOf(person.getShip().getItemInventory().
                getNumberOfGood(good)));

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
