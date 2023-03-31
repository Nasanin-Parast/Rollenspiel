package spielfigur.builder;

import spielfigur.exception.MissingAttributeException;
import spielfigur.model.Charakter;
/**
 * @author Raphael Gardemann
 */
public class NullBuilder extends CharakterBuilder {

    @Override
    protected Charakter createCharakter() {
        throw new MissingAttributeException("Keine Charakterklasse ausgewählt");
    }

}
