package spacetraders.classes;

public enum Good {
    WOOD("Wood", 50, 50, "fuel capacity"),
    OIL("Oil", 100, 50, "fuel capacity"),
    PLUTONIUM("Plutonium", 300, 100, "fuel capacity"),
    GODFUEL("God Fuel", 500, 200, "fuel capacity"),

    SMALLHULL("Small Hull", 50, 2, "cargo capacity"),
    BIGHULL("Big Hull", 200, 3, "cargo capacity"),
    ATTACHABLE("Attachable Storage Container", 400, 5, "cargo capacity"),
    TARDIS("Tardis Extension", 600, 10, "cargo capacity"),

    LIGHTFORCEFIELD("Light Force Field", 200, 2, "max health"),
    MEDIUMFORCEFIELD("Medium Force Field", 400, 4, "max health"),
    HEAVYFORCEFIELD("Heavy Force Field", 600, 6, "max health"),
    DYSONSPHERE("Dyson Sphere", 800, 8, "max health"),

    LASERS("Lasers", 100, 2, "fighter points"),
    MISSILES("Missiles", 200, 4, "fighter points"),
    LASERMISSILES("Laser Missiles", 400, 6, "fighter points"),
    SPACENUKES("Space Nukes", 1000, 10, "fighter points"),

    NAVSYSTEM("Navigation System", 500, 4, "pilot points"),
    TARGETSYSTEM("Targeting System", 500, 4, "fighter points"),
    AUTOTRANSLATOR("Auto Translator", 500, 4, "merchant points"),
    AUTOREPAIR("Auto-Repair System", 500, 4, "engineer points");


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

    public int getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public int getModFactor() {
        return modFactor;
    }

    public String getModStat() {
        return modStat;
    }
}
