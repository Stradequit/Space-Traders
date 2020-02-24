package spacetraders.classes;

public enum Good {
    WOOD ("Wood", 50, 50, "fuelCapacity"),
    OIL ("Oil", 100, 50, "fuelCapacity"),
    PLUTONIUM ("Plutonium", 300, 100,"fuelCapacity"),
    GODFUEL ("God Fuel", 500, 200, "fuelCapacity"),

    SMALLHULL ("Small Hull", 50, 2, "cargoCapacity"),
    BIGHULL ("Big Hull", 200, 3, "cargoCapacity"),
    ATTACHABLE ("Attachable Storage Container", 400, 5, "cargoCapacity"),
    TARDIS ("Tardis Extension", 600, 10, "cargoCapacity"),

    LIGHTFORCEFIELD ("Light Force Field", 200, 2,"health"),
    MEDIUMFORCEFIELD ("Medium Force Field", 400, 4, "health"),
    HEAVYFORCEFIELD ("Heavy Force Field", 600, 6, "health"),
    DYSONSPHERE ("Dyson Sphere", 800, 8, "health"),

    LASERS ("Lasers", 100, 2, "fighterPoints"),
    MISSILES ("Missiles", 200, 4, "fighterPoints"),
    LASERMISSILES ("Laser Missiles", 400, 6, "fighterPoints"),
    SPACENUKES ("Space Nukes", 1000, 10, "fighterPoints");
    private int basePrice;
    private String name;
    private int modFactor;
    private String modStat;
    Good(String name, int basePrice, int modFactor, String modStat) {
        this.name = name;
        this.basePrice = basePrice;
        this.modFactor = modFactor;
        this.modStat = modStat;
    }
}
