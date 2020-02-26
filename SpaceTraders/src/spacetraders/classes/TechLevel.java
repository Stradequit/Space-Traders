package spacetraders.classes;
public enum TechLevel {
    AGRICULTURAL(Good.WOOD, Good.SMALLHULL, Good.LIGHTFORCEFIELD, Good.LASERS),
    INDUSTRIAL(Good.OIL, Good.BIGHULL, Good.MEDIUMFORCEFIELD, Good.MISSILES),
    POSTINDUSTRIAL(Good.PLUTONIUM, Good.ATTACHABLE, Good.HEAVYFORCEFIELD, Good.LASERMISSILES),
    HIGHTECH(Good.GODFUEL, Good.TARDIS,Good.DYSONSPHERE,Good.SPACENUKES);
    private Good fuel;
    private Good capacity;
    private Good defense;
    private Good weapon;
    TechLevel(Good fuel, Good capacity, Good defense, Good weapon) {
        this.fuel = fuel;
        this.capacity = capacity;
        this.defense = defense;
        this.weapon = weapon;
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
}
