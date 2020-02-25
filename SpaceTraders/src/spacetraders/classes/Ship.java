package spacetraders.classes;

public class Ship {
    private String name;
    private int cargoCapacity;
    private int fuelCapacity;
    private int health;
    private ItemInventory itemInventory;
    public void addItem(Good good) {
        this.itemInventory.addGood(good);
    }
    public void removeItem(Good good) {
        this.itemInventory.removeGood(good);
    }
    public Ship() {
        name = "Ship";
        cargoCapacity = 3;
        fuelCapacity = 100;
        health = 3;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ItemInventory getItemInventory() {
        return itemInventory;
    }

    public void setItemInventory(ItemInventory itemInventory) {
        this.itemInventory = itemInventory;
    }
    public void changeItemInventory(int modFactor) {

    }
}
