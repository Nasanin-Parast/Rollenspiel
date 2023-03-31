package spielfigur.builder;

import spielfigur.model.Charakter;
import spielfigur.model.Kaempfer;
/**
 * @author Nasanin Parast
 */
public class KaempferBuilder extends CharakterBuilder {
    @Override
    public Charakter createCharakter() {
        return new Kaempfer(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
