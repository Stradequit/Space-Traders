package spacetraders;

import javafx.scene.Scene;
import javafx.stage.Stage;
import spacetraders.classes.Person;
import spacetraders.classes.Region;


public class GameController {


    private Stage stage = new Stage();



    public void changeStage(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public Person getPerson() {
        return person;
    }

    private Person person = new Person();
    private Region instantia = new Region("Instantia", "Agricultural", "Riddled with domestic wars, this region has never been able to evolve.", 0,0);
    private Region neverthirst = new Region("Neverthirst", "Pre-agricultural", "The newest planet in the galaxy",0,0);
    private Region dell = new Region("Dell", "Early Industrial", "A region full of laptop people",0,0);
    private Region godhaven = new Region("Godhaven", "Industrial", "People here have a bit of an ego, maybe that explains the name.",0,0);
    private Region borkland = new Region("Borkland", "Post Industrial", "The only planet with more dogs than people",0,0);
    Region lazda = new Region("Lazda", "High Tech", "By far the most advanced galaxy. Control all of space travel",0,0);
    Region formenos = new Region("Formenos", "Early Industrial","A fully underwater planet. This make their industrial standing quite impressive.",0,0);
    Region catolus = new Region("Catolus", "Industrial", "Cats have taken over. Expect stingy traders.",0,0);
    Region caladria = new Region("Caladria", "Agricultural", "People are finally settling down here, don't expect much.",0,0);
    Region arcana = new Region("Arcana", "Pre-agricultural", "A society solely based on magic, making no progress in other categories",0,0);
    Region harmonia = new Region("Harmonia", "Early Industrial","A society that exists in complete peace, for now.",0,0);
    Region araboozia = new Region("Araboozia", "High Tech", "Working on their international space travel, the government is halting their progress though.",0,0);
    Region sacaguwea5 = new Region("Sacaguwea5", "Agricultural", "A planet of explorers. The planet is 30x bigger than the average, so there's a lot to explore.",0,0);
    Region corudine = new Region("Corudine", "Industrial", "Lava, everywhere, beware",0,0);
    Region pauladeen = new Region("Pauladeen", "Industrial", "A cooking planet.",0,0);
    Region[] regionArray = new Region[]{instantia, neverthirst, dell,godhaven,borkland,lazda,formenos,catolus,caladria,arcana,harmonia,araboozia,sacaguwea5,corudine,pauladeen};
    public Region[] getRegionArray() {
        return regionArray;
    }
}
