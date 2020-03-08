package spacetraders.classes;

import javafx.scene.image.Image;
import spacetraders.controllers.MapController;

public enum Encounter {
    POLICE("a","","","","", Images.getPoliceImage()),
    TRADER("b","","","","", Images.getMerchantImage()),
    BANDIT("c","","","","", Images.getBanditsImage());

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
