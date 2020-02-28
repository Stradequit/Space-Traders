package spacetraders.classes;
public enum TechLevel {
    AGRICULTURAL(Good.WOOD, Good.SMALLHULL, Good.LIGHTFORCEFIELD, Good.LASERS, Good.NAVSYSTEM),
    INDUSTRIAL(Good.OIL, Good.BIGHULL, Good.MEDIUMFORCEFIELD, Good.MISSILES, Good.TARGETSYSTEM),
    POSTINDUSTRIAL(Good.PLUTONIUM, Good.ATTACHABLE, Good.HEAVYFORCEFIELD, Good.LASERMISSILES, Good.AUTOTRANSLATOR),
    HIGHTECH(Good.GODFUEL, Good.TARDIS, Good.DYSONSPHERE, Good.SPACENUKES, Good.AUTOREPAIR);
    private Good fuel;
    private Good capacity;
    private Good defense;
    private Good weapon;
    private Good upgrades;
    TechLevel(Good fuel, Good capacity, Good defense, Good weapon, Good upgrades) {
        this.fuel = fuel;
        this.capacity = capacity;
        this.defense = defense;
        this.weapon = weapon;
        this.upgrades = upgrades;
    }

    public Good getFuel() {
        return fuel;
    }

    public Good getCapacity() {
        return capacity;
    }

    public Good getDefense() {
        return defense;
    }

    public Good getWeapon() {
        return weapon;
    }

    public Good getUpgrades() {
        return upgrades;
    }
}
