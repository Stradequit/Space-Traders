package spacetraders.classes;

public class Person {
    private String name = "placeholder";
    private String difficulty = "easy";
    private int credits = 0;
    private int skillPoints = 0;
    private int pilotPoints = 0;
    private int engineeringPoints = 0;
    private int fighterPoints = 0;
    private int merchantPoints = 0;
    private Region currRegion;
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
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
