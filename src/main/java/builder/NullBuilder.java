package builder;

import spielfigur.Charakter;

public class NullBuilder extends CharakterBuilder {

    @Override
    protected Charakter createCharakter() {
        throw new IllegalArgumentException("Keine Charakterklasse ausgewählt");
    }

}
