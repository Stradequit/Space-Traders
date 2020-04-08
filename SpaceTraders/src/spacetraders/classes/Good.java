package spacetraders.classes;

public enum Good {
    WOOD("Wood", 50, 50, "fuel capacity", 70),
    OIL("Oil", 100, 50, "fuel capacity", 140),
    PLUTONIUM("Plutonium", 300, 100, "fuel capacity", 420),
    GODFUEL("God Fuel", 500, 200, "fuel capacity", 700),

    SMALLHULL("Small Hull", 50, 2, "cargo capacity", 70),
    BIGHULL("Big Hull", 200, 3, "cargo capacity", 280),
    ATTACHABLE("Attachable Storage Container", 400, 5, "cargo capacity", 560),
    TARDIS("Tardis Extension", 600, 10, "cargo capacity", 840),

    LIGHTFORCEFIELD("Light Force Field", 200, 2, "max health", 280),
    MEDIUMFORCEFIELD("Medium Force Field", 400, 4, "max health", 560),
    HEAVYFORCEFIELD("Heavy Force Field", 600, 6, "max health", 840),
    DYSONSPHERE("Dyson Sphere", 800, 8, "max health", 1120),

    LASERS("Lasers", 100, 2, "fighter points", 140),
    MISSILES("Missiles", 200, 4, "fighter points", 280),
    LASERMISSILES("Laser Missiles", 400, 6, "fighter points", 560),
    SPACENUKES("Space Nukes", 1000, 10, "fighter points", 1400),

    NAVSYSTEM("Navigation System", 500, 4, "pilot points", 0),
    TARGETSYSTEM("Targeting System", 500, 4, "fighter points", 0),
    AUTOTRANSLATOR("Auto Translator", 500, 4, "merchant points", 0),
    AUTOREPAIR("Auto-Repair System", 500, 4, "engineer points", 0),

    WINITEM("Win Item",500,0,"pilot points",0);

    private int basePrice;
    private int traderPrice;
    private String name;
    private int modFactor;
    private String modStat;
    Good(String name, int basePrice, int modFactor, String modStat, int traderPrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.modFactor = modFactor;
        this.modStat = modStat;
        this.traderPrice = traderPrice;
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

    public int getTraderPrice() {
        return traderPrice;
    }
}
