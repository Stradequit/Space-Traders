package spacetraders.classes;

import java.util.HashMap;

public class Ship {
    private String name;
    private int cargoCapacity;
    private int fuelCapacity;
    private int health;
    private ItemInventory itemInventory;
    public void addItem(Good good){
        this.itemInventory.addGood(good);
    }
    public void removeItem(Good good) {
        this.itemInventory.removeGood(good);
    }
}
