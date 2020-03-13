package spacetraders.classes;

import javafx.scene.image.Image;
import spacetraders.controllers.MapController;

public enum Encounter {
    POLICE("","Forfeit the items",
            "Fight the police","Flee to previous region",
            "", Images.getPoliceImage()),
    TRADER("b","","","","", Images.getMerchantImage()),
    BANDIT("\"Hey, you! This here is a toll booth of sorts. " +
            "How's abouts ya pay a little coin so I don't rob you blind?\" [the bandit demands 15 coins]",
            "Pay the bandit","Fight the bandit","Flee to previous region",
            "", Images.getBanditsImage());

    Encounter(String description, String optionOneText, String optionTwoText, String optionThreeText, String optionFourText, Image image) {
        this.description = description;
        this.optionOneText = optionOneText;
        this.optionTwoText = optionTwoText;
        this.optionThreeText = optionThreeText;
        this.optionFourText = optionFourText;
        this.image = image;
    }


    private String description;
    private String optionOneText;
    private String optionTwoText;
    private String optionThreeText;
    private String optionFourText;
    private Image image;
    private Images images;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptionOneText() {
        return optionOneText;
    }

    public String getOptionTwoText() {
        return optionTwoText;
    }

    public String getOptionThreeText() {
        return optionThreeText;
    }

    public String getOptionFourText() {
        return optionFourText;
    }

    public Image getImage() {
        return image;
    }
}
