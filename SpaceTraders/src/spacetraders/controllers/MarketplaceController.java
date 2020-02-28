package spacetraders.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import spacetraders.classes.Person;
import spacetraders.classes.Good;

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
    private @FXML Label currentCredits;
    private @FXML Label inventorySpaceLabel;
    private @FXML Label afterPurchaseLabel;
    private @FXML Label itemInventoryLabel;

    private Person person = new Person();
    private Good good = null;
    private int buyPriceInt = 0;
    private int sellPriceInt = 0;
    private boolean hullTaken = false;
    private int size = 0;

    public void buyItem(ActionEvent actionEvent) {
        if (person.getCredits() >= buyPriceInt) {
            if (size < person.getShip().getCargoCapacity()) {
                if (good.getModStat() == "cargoCapacity") {
                    if (hullTaken) {
                        afterPurchaseLabel.setText("Your ship already has a Hull");
                        return;
                    } else {
                        hullTaken = true;
                    }
                } else {
                    size++;
                }
                int oldCredit = person.getCredits();
                int newCredit = oldCredit - buyPriceInt;
                person.setCredits(newCredit);
                person.getShip().addItem(good);
                afterPurchaseLabel.setText("Purchase Successful");
                update();
            } else {
                afterPurchaseLabel.setText("Not enough space");
            }
        } else {
            afterPurchaseLabel.setText("Not enough credits");
        }
    }

    public void sellItem(ActionEvent actionEvent) {
        if (person.getShip().getItemInventory().getNumberOfGood(good) > 0) {
            if (good.getModStat() == "cargoCapacity") {
                if (person.getShip().getCargoCapacity() - size >= good.getModFactor()) {
                    hullTaken = false;
                } else {
                    afterPurchaseLabel.setText("This Hull is Currently Holding Items");
                    return;
                }
            } else {
                size--;
            }
            int oldCredit = person.getCredits();
            int newCredit = oldCredit + sellPriceInt;
            person.setCredits(newCredit);
            person.getShip().removeItem(good);
            afterPurchaseLabel.setText("Sale Successful");
            update();
        } else {
            afterPurchaseLabel.setText("No item to sell");
        }
    }

    public void showItem(ActionEvent actionEvent) {
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
        buyPriceInt = good.getBasePrice() - ((person.getMerchantPoints()));
        sellPriceInt = good.getBasePrice() + (((person.getMerchantPoints()))) - 20;
        itemName.setText(good.getName());
        descItem.setText(good.getModStat() + " " + good.getModFactor());
        buyPrice.setText(String.valueOf(buyPriceInt));
        sellPrice.setText(String.valueOf(sellPriceInt));
        numInv.setText(String.valueOf(person.getShip().getItemInventory().
                    getNumberOfGood(good)));
        currentCredits.setText("" + person.getCredits());
        inventorySpaceLabel.setText("" + (person.getShip().getCargoCapacity() - size));
        itemInventoryLabel.setText("Item Inventory: " + person.getShip().getItemInventory()
                .toString());
    }
    public void update() {
        numInv.setText(String.valueOf(person.getShip().getItemInventory().
                getNumberOfGood(good)));
        currentCredits.setText("" + person.getCredits());
        inventorySpaceLabel.setText("" + (person.getShip().getCargoCapacity() - size));
        itemInventoryLabel.setText("Item Inventory: " + person.getShip().getItemInventory()
                .toString());
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
