package builder;

import model.Kaempfer;

public class KaempferBuilder extends CharakterBuilder {
    @Override
    public Charakter createCharakter() {
        return new Kaempfer(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
