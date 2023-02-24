package builder;

import spielfigur.Charakter;
import spielfigur.Kaempfer;

public class KaempferBuilder extends CharakterBuilder {
    @Override
    public Charakter createCharakter() {
        return new Kaempfer(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
