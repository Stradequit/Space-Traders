package spacetraders.classes;

public class Ship {
    private String name;
    private int cargoCapacity;
    private int fuelCapacity;
    private int maxHealth;
    private int currHealth;
    private ItemInventory itemInventory = new ItemInventory();
    private Person person = new Person();

    public void refuel(){
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
        fuelCapacity = 100;
        maxHealth = 3;
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
}
