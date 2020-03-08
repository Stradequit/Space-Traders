package spacetraders.classes;

import javafx.scene.image.Image;

public class Images {
    private static Image policeImage = new Image(Encounter.class.getResource("..//images//policeInSpace.jpg").toString());
    private static Image merchantImage = new Image(Encounter.class.getResource("..//images//merchantImage.jpg").toString());
    private static Image banditsImage = new Image(Encounter.class.getResource("..//images//SpaceBandits.jpg").toString());

    public static Image getPoliceImage() {
        return policeImage;
    }

    public static Image getMerchantImage() {
        return merchantImage;
    }

    public static Image getBanditsImage() {
        return banditsImage;
    }
}
