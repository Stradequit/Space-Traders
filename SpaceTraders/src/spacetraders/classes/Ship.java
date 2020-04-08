package spacetraders.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import spacetraders.controllers.GameController;

import java.io.IOException;

public class Ship {
    private String name;
    private int cargoCapacity;
    private int fuelCapacity;
    private int maxHealth;
    private int currHealth;
    private ItemInventory itemInventory = new ItemInventory();
    private Person person = new Person();

    public void refuel(int fuelCapacity) {
        person.setCurrFuel(fuelCapacity);
    }

    public void addItem(Good good) {
        switch (good.getModStat()) {
        case "fuel capacity":
            this.fuelCapacity += good.getModFactor();
            break;
        case "cargo capacity":
            this.cargoCapacity += good.getModFactor();
            break;
        case "max health":
            this.maxHealth += good.getModFactor();
            break;
        case "fighter points":
            person.setFighterPoints(person.getFighterPoints() + good.getModFactor());
            break;
        case "pilot points":
            person.setPilotPoints(person.getPilotPoints() + good.getModFactor());
            break;
        case "merchant points":
            person.setMerchantPoints(person.getMerchantPoints() + good.getModFactor());
            break;
        case "engineer points":
            person.setEngineeringPoints(person.getEngineeringPoints() + good.getModFactor());
            break;
        default: break;
        }
        this.itemInventory.addGood(good);
    }
    public void removeItem(Good good) {
        switch (good.getModStat()) {
        case "fuel capacity":
            this.fuelCapacity -= good.getModFactor();
            break;
        case "cargo capacity":
            this.cargoCapacity -= good.getModFactor();
            break;
        case "max health":
            this.maxHealth -= good.getModFactor();
            break;
        case "fighter points":
            person.setFighterPoints(person.getFighterPoints() - good.getModFactor());
            break;
        case "pilot points":
            person.setPilotPoints(person.getPilotPoints() - good.getModFactor());
            break;
        case "merchant points":
            person.setMerchantPoints(person.getMerchantPoints() - good.getModFactor());
            break;
        case "engineer points":
            person.setEngineeringPoints(person.getEngineeringPoints() - good.getModFactor());
            break;

        default: break;
        }
        this.itemInventory.removeGood(good);
    }
    public Ship() {
        name = "Ship";
        cargoCapacity = 3;
        fuelCapacity = 2000000000;
        maxHealth = 3;
        currHealth = 3;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public void setItemInventory(ItemInventory itemInventory) {
        this.itemInventory = itemInventory;
    }
    public void changeItemInventory(int modFactor) {

    }
    public void takeDamage() {
        currHealth--;
        if (currHealth == 0) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("..//screens//GameOver.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene gameOver = new Scene(root, 720, 480);
            GameController gameController = new GameController();
            gameController.changeStage(gameOver);
        }
    }
}
