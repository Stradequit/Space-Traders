package spacetraders;

import javafx.scene.Scene;
import javafx.stage.Stage;
import spacetraders.classes.Region;
import spacetraders.classes.TechLevel;

public class GameController {
    private Stage stage = new Stage();

    public void changeStage(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
    //Creating Regions
    private Region instantia = new Region("0", "Instantia",
            TechLevel.AGRICULTURAL,
            "Riddled with domestic wars, this region has never been able to evolve.", 0, 0);
    private Region neverthirst = new Region("1", "Neverthirst",
            TechLevel.AGRICULTURAL, "The newest planet in the galaxy", 0, 0);
    private Region dell = new Region("2", "Dell",
            TechLevel.POSTINDUSTRIAL, "A region full of laptop people", 0, 0);
    private Region godhaven = new Region("3", "Godhaven",
            TechLevel.HIGHTECH, "People here have a bit of an ego, maybe that explains the name.", 0, 0);
    private Region borkland = new Region("4", "Borkland",
            TechLevel.POSTINDUSTRIAL, "The only planet with more dogs than people", 0, 0);
    private Region lazda = new Region("5", "Lazda",
            TechLevel.HIGHTECH, "By far the most advanced galaxy. Control all of space travel", 0, 0);
    private Region formenos = new Region("6", "Formenos",
            TechLevel.INDUSTRIAL,
            "A fully underwater planet. This make their industrial standing quite impressive.",
            0, 0);
    private Region catolus = new Region("7", "Catolus",
            TechLevel.HIGHTECH, "Cats have taken over. Expect stingy traders.", 0, 0);
    private Region caladria = new Region("8", "Caladria",
            TechLevel.INDUSTRIAL, "People are finally settling down here, don't expect much.", 0, 0);
    private Region arcana = new Region("9", "Arcana",
            TechLevel.AGRICULTURAL,
            "A society solely based on magic, making no progress in other categories", 0, 0);
    private Region harmonia = new Region("10", "Harmonia",
            TechLevel.POSTINDUSTRIAL, "A society that exists in complete peace, for now.", 0, 0);
    private Region araboozia = new Region("11", "Araboozia",
            TechLevel.HIGHTECH,
            "Working on their international space travel, "
                    + "the government is halting their progress though.", 0, 0);
    private Region sacaguwea5 = new Region("12", "Sacaguwea5",
            TechLevel.AGRICULTURAL,
            "A planet of explorers. "
                    + "The planet is 30x bigger than the average, so there's a lot to explore.",
            0, 0);
    private Region corudine = new Region("13", "Corudine",
            TechLevel.INDUSTRIAL, "Lava, everywhere, beware", 0, 0);
    private Region pauladeen = new Region("14", "Pauladeen",
            TechLevel.INDUSTRIAL, "A cooking planet.", 0, 0);
    private Region[] regionArray = new Region[]
        {instantia, neverthirst, dell, godhaven, borkland, lazda, formenos, catolus, caladria,
            arcana, harmonia, araboozia, sacaguwea5, corudine, pauladeen};
    public Region[] getRegionArray() {
        return regionArray;
    }
}
