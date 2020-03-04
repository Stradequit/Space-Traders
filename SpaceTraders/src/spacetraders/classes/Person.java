package spacetraders.classes;

import java.util.ArrayList;

public class Person {
    private static String name = "placeholder";
    private static String difficulty = "Easy";
    private static int credits = 0;
    private static int skillPoints = 16;
    private static int pilotPoints = 0; //Distance your ship can travel
    private static int engineeringPoints = 0; //Increases effectiveness of repairing your own ship
    private static int fighterPoints = 0; //Strength in combat
    //A high merchant stat can buy goods for less and sell for more
    private static int merchantPoints = 0;
    private static Region currRegion;
    private static ArrayList<Region> visited = new ArrayList<Region>(0);
    private static Ship ship = new Ship();
    private static int currFuel = ship.getFuelCapacity();
    private static int fuelCost = 0;

    public Person() {
    }
    public Person(Person person) {
    }

    public String getName() {
        return this.name;
    }
    public Region getCurrRegion() {
        return this.currRegion;
    }
    public void setName(String name1) {
        this.name = name1;
    }
    public void setCurrRegion(Region region) {
        this.currRegion = region;
    }
    public void setCurrFuel(int fuel) { this.currFuel = fuel; }
    public Integer getCurrFuel() { return this.currFuel; }
    public String getDifficulty() {
        return difficulty;
    }
    public void addVisited(Region region) {
        visited.add(region);
    }
    public ArrayList<Region> getVisited() {
        return this.visited;
    }
    public boolean visitedContains(Region region) {
        return visited.contains(region);
    }
    public Integer getFuelCost() {
        return this.fuelCost;
    }
    public void setFuelCost(int fuelCost) {
        this.fuelCost = fuelCost;
    }
    public void setDifficulty(String diff) {
        if (diff == "Easy") {
            if (difficulty == "Medium") {
                skillPoints += 4;
            }
            if (difficulty == "Hard") {
                skillPoints += 8;
            }
            difficulty = diff;
        }
        credits = 1400;
        if (diff == "Medium") {
            if (difficulty == "Easy") {
                skillPoints -= 4;
            }
            if (difficulty == "Hard") {
                skillPoints += 4;
            }
            difficulty = diff;
            credits = 1200;
        }
        if (diff == "Hard") {
            if (difficulty == "Easy") {
                skillPoints -= 8;
            }
            if (difficulty == "Medium") {
                skillPoints -= 4;
            }
            difficulty = diff;
            credits = 1000;
        }
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public int getEngineeringPoints() {
        return engineeringPoints;
    }

    public void setEngineeringPoints(int engineeringPoints) {
        this.engineeringPoints = engineeringPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public int getMerchantPoints() {
        return merchantPoints;
    }

    public void setMerchantPoints(int merchantPoints) {
        this.merchantPoints = merchantPoints;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        Person.ship = ship;
    }
}