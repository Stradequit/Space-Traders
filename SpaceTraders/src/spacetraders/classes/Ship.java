package spacetraders.classes;

public class Ship {
    private String name;
    private int cargoCapacity;
    private int fuelCapacity;
    private int health;
    private ItemInventory itemInventory = new ItemInventory();
    Person person = new Person();
    public void addItem(Good good) {
        switch (good.getModStat()) {
            case ("fuelCapacity"): this.fuelCapacity += good.getModFactor(); break;
            case ("cargoCapacity"): this.cargoCapacity += good.getModFactor(); break;
            case ("health"): this.health += good.getModFactor(); break;
            case ("fighterPoints"): person.setFighterPoints(person.getFighterPoints() + good.getModFactor()); break;
        }
        this.itemInventory.addGood(good);
    }
    public void removeItem(Good good) {
        switch (good.getModStat()) {
            case ("fuelCapacity"): this.fuelCapacity -= good.getModFactor(); break;
            case ("cargoCapacity"): this.cargoCapacity -= good.getModFactor(); break;
            case ("health"): this.health -= good.getModFactor(); break;
            case ("fighterPoints"): person.setFighterPoints(person.getFighterPoints() - good.getModFactor()); break;
        }
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
