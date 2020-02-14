package spacetraders.classes;

public class Person {
    private static String name = "placeholder";
    private static String difficulty = "easy";
    private static int credits = 0;
    private static int skillPoints = 0;
    private static int pilotPoints = 0;
    private static int engineeringPoints = 0;
    private static int fighterPoints = 0;
    private static int merchantPoints = 0;
    private static Region currRegion;
    public Person() {
    }
    public Person(Person person) {
    }

    public String getName() {
        return this.name;
    }
    public Region getCurrRegion() { return this.currRegion; }
    public void setName(String name1) {
        this.name = name1;
    }
    public void setCurrRegion(Region region) { this.currRegion = region; }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String diff) {
        difficulty = diff;
        skillPoints = 16;
        credits = 1000;
        if (difficulty == "Medium") {
            skillPoints += 4;
            credits = 1200;
        } else if (difficulty == "Hard") {
            skillPoints += 8;
            credits = 1300;
        } else {
            skillPoints = 16;
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
}