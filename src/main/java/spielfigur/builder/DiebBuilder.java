package spielfigur.builder;

import spielfigur.model.Charakter;
import spielfigur.model.Dieb;

public class DiebBuilder extends CharakterBuilder {

    @Override
    public Charakter createCharakter() {
        return new Dieb(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
