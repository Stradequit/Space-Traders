package spacetraders;

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

    private void buyItem(int price, Good good, Person person) {
        int oldCredit = person.getCredits();
        int newCredit = oldCredit - price;
        person.setCredits(newCredit);

        person.getShip().addItem(good);
    }
    private void sellItem(int price, Good good, Person person) {
        int oldCredit = person.getCredits();
        int newCredit = oldCredit + price;
        person.setCredits(newCredit);

        person.getShip().removeItem(good);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person person = new Person();
        //Pick goods based on Tech Level
        Button[] buttons = new Button[]{fuelGoodConfirm, cargoGoodConfirm, healthGoodConfirm,
            fighterGoodConfirm, miscGoodConfirm};
        for (int i = 0; i < buttons.length; i++) {
            if (i == 0) {           // button is for fuel
                buttons[i].setOnAction(buttonEvent -> {
                    int buyFuelPrice = person.getCurrRegion().getTechLevel().getFuel().
                            getBasePrice() - (person.getMerchantPoints());
                    int sellFuelPrice = person.getCurrRegion().getTechLevel().
                            getFuel().getBasePrice() + ((person.getMerchantPoints()) - 20);
                    itemName.setText(person.getCurrRegion().getTechLevel().getFuel().getName());
                    descItem.setText(person.getCurrRegion().getTechLevel().getFuel().getModStat()
                            + " " + person.getCurrRegion().getTechLevel().getFuel().getModFactor());
                    buyPrice.setText(String.valueOf(buyFuelPrice));
                    sellPrice.setText(String.valueOf(sellFuelPrice));
                    numInv.setText(String.valueOf(person.getShip().getItemInventory().
                            getNumberOfGood(person.getCurrRegion().getTechLevel().getFuel())));
                    buy.setOnAction(buyEvent -> {
                        if (person.getCredits() >= buyFuelPrice) {
                            buyItem(buyFuelPrice,
                                    person.getCurrRegion().getTechLevel().getFuel(), person);
                        }
                    });
                    sell.setOnAction(sellEvent -> {
                        if ((person.getShip().getItemInventory()).getNumberOfGood(
                                person.getCurrRegion().getTechLevel().getFuel()) > 0) {
                            sellItem(sellFuelPrice,
                                    person.getCurrRegion().getTechLevel().getFuel(), person);
                        }
                    });
                });
            } else if (i == 1) {        // button is for cargo (CAPACITY)
                buttons[i].setOnAction(buttonEvent -> {
                    int buyCapacityPrice = person.getCurrRegion().getTechLevel().
                            getCapacity().getBasePrice() - (person.getMerchantPoints());
                    int sellCapacityPrice = person.getCurrRegion().getTechLevel().
                            getCapacity().getBasePrice() + ((person.getMerchantPoints()) - 20);
                    itemName.setText(person.getCurrRegion().getTechLevel().getCapacity().getName());
                    descItem.setText(person.getCurrRegion().getTechLevel().getCapacity().
                            getModStat() + " " + person.getCurrRegion().getTechLevel().
                            getCapacity().getModFactor());
                    buyPrice.setText(String.valueOf(buyCapacityPrice));
                    sellPrice.setText(String.valueOf(sellCapacityPrice));
                    numInv.setText(String.valueOf(person.getShip().getItemInventory().
                            getNumberOfGood(person.getCurrRegion().getTechLevel().getCapacity())));
                    buy.setOnAction(buyEvent -> {
                        if (person.getCredits() >= buyCapacityPrice) {
                            buyItem(buyCapacityPrice,
                                    person.getCurrRegion().getTechLevel().getCapacity(), person);
                        }
                    });
                    sell.setOnAction(sellEvent -> {
                        if ((person.getShip().getItemInventory()).getNumberOfGood(
                                person.getCurrRegion().getTechLevel().getCapacity()) > 0) {
                            sellItem(sellCapacityPrice,
                                    person.getCurrRegion().getTechLevel().getCapacity(), person);
                        }
                    });
                });
            } else if (i == 2) {        // button is for health (DEFENSE)
                buttons[i].setOnAction(buttonEvent -> {
                    int buyDefensePrice = person.getCurrRegion().getTechLevel().
                            getDefense().getBasePrice() - (person.getMerchantPoints());
                    int sellDefensePrice = person.getCurrRegion().getTechLevel().
                            getDefense().getBasePrice() + (person.getMerchantPoints() - 20);

                    itemName.setText(person.getCurrRegion().getTechLevel().getDefense().getName());
                    descItem.setText(person.getCurrRegion().getTechLevel().getDefense().
                            getModStat() + " " + person.getCurrRegion().getTechLevel().
                            getDefense().getModFactor());
                    buyPrice.setText(String.valueOf(buyDefensePrice));
                    sellPrice.setText(String.valueOf(sellDefensePrice));
                    numInv.setText(String.valueOf(person.getShip().getItemInventory().
                            getNumberOfGood(person.getCurrRegion().getTechLevel().getDefense())));
                    buy.setOnAction(buyEvent -> {
                        if (person.getCredits() >= buyDefensePrice) {
                            buyItem(buyDefensePrice,
                                    person.getCurrRegion().getTechLevel().getDefense(), person);
                        }
                    });
                    sell.setOnAction(sellEvent -> {
                        if ((person.getShip().getItemInventory()).getNumberOfGood(
                                person.getCurrRegion().getTechLevel().getDefense()) > 0) {
                            sellItem(sellDefensePrice,
                                    person.getCurrRegion().getTechLevel().getDefense(), person);
                        }
                    });
                });
            } else if (i == 3) {        // button is for fighter (WEAPONS)
                buttons[i].setOnAction(buttonEvent -> {
                    int buyWeaponsPrice = person.getCurrRegion().getTechLevel().
                            getWeapon().getBasePrice() - (person.getMerchantPoints());
                    int sellWeaponsPrice = person.getCurrRegion().getTechLevel().
                            getWeapon().getBasePrice() + ((person.getMerchantPoints()) - 20);
                    itemName.setText(person.getCurrRegion().getTechLevel().getWeapon().getName());
                    descItem.setText(person.getCurrRegion().getTechLevel().getWeapon().getModStat()
                            + " " + person.getCurrRegion().getTechLevel().
                            getWeapon().getModFactor());
                    buyPrice.setText(String.valueOf(buyWeaponsPrice));
                    sellPrice.setText(String.valueOf(sellWeaponsPrice));
                    numInv.setText(String.valueOf(person.getShip().getItemInventory().
                            getNumberOfGood(person.getCurrRegion().getTechLevel().getWeapon())));

                    buy.setOnAction(buyEvent -> {
                        if (person.getCredits() >= buyWeaponsPrice) {
                            buyItem(buyWeaponsPrice,
                                    person.getCurrRegion().getTechLevel().getWeapon(), person);
                        }
                    });
                    sell.setOnAction(sellEvent -> {
                        if ((person.getShip().getItemInventory()).getNumberOfGood(
                                person.getCurrRegion().getTechLevel().getWeapon()) > 0) {
                            sellItem(sellWeaponsPrice,
                                    person.getCurrRegion().getTechLevel().getWeapon(), person);
                        }
                    });
                });
            } else {                // button is for misc (CHARACTER UPGRADES) change this later!!!
                buttons[i].setOnAction(buttonEvent -> {
                    int buyUpgradesPrice = person.getCurrRegion().getTechLevel().getFuel().
                            getBasePrice() * ((person.getMerchantPoints()) / 10);
                    int sellUpgradesPrice = person.getCurrRegion().getTechLevel().
                            getFuel().getBasePrice() * ((person.getMerchantPoints()) / 10);
                    itemName.setText(person.getCurrRegion().getTechLevel().getFuel().getName());
                    descItem.setText(person.getCurrRegion().getTechLevel().getFuel().getModStat());
                    buyPrice.setText(String.valueOf(buyUpgradesPrice));
                    sellPrice.setText(String.valueOf(sellUpgradesPrice));
                    numInv.setText(String.valueOf(person.getShip().getItemInventory().
                            getNumberOfGood(person.getCurrRegion().getTechLevel().getFuel())));
                    buy.setOnAction(buyEvent -> {
                        if (person.getCredits() >= buyUpgradesPrice) {
                            buyItem(buyUpgradesPrice, person.getCurrRegion().
                                    getTechLevel().getFuel(), person); // FIX IT!!
                        }
                    });
                    sell.setOnAction(sellEvent -> {
                        if ((person.getShip().getItemInventory()).getNumberOfGood(
                                person.getCurrRegion().getTechLevel().getFuel()) > 0) {
                            sellItem(sellUpgradesPrice, person.getCurrRegion().
                                    getTechLevel().getFuel(), person);   // FIX IT!!
                        }
                    });
                });
            }
        }
    }
}
