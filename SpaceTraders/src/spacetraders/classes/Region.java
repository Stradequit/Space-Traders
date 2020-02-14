package spacetraders.classes;

public class Region {
    private String name = "placeholder";
    private int[] coordinates = new int[]{ 0, 0};
    private String techLevel;
    private String description;
    public Region(String regionName, String tlevel, String desc, int x, int y) {
        this.name = regionName;
        this.techLevel = tlevel;
        this.description = desc;
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }
    public String getName() {
        return name;
    }

    public void setXCoordinate(int x) {
        this.coordinates[0] = x;
    }
    public void setYCoordinate(int y) {
        this.coordinates[1] = y;
    }
    public int[] getCoordinates() {
        return coordinates;
    }

    public String getTechLevel() {
        return techLevel;
    }

    public String getDescription() {
        return description;
    }
}
