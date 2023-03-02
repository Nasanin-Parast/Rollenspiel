package spielfigur.builder;

import spielfigur.model.Charakter;
import spielfigur.model.Kaempfer;

public class KaempferBuilder extends CharakterBuilder {
    @Override
    public Charakter createCharakter() {
        return new Kaempfer(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
