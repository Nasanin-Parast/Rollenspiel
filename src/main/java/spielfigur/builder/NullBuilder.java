package spielfigur.builder;

import spielfigur.exception.MissingAttributeException;
import spielfigur.model.Charakter;

public class NullBuilder extends CharakterBuilder {

    @Override
    protected Charakter createCharakter() {
        throw new MissingAttributeException("Keine Charakterklasse ausgewählt");
    }

}
