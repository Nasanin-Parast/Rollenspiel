package spielfigur.model;

import inventar.Inventar;

import java.io.Serializable;

public abstract class Charakter extends Spielfigur implements Serializable {

    protected Inventar inventar;
    protected Charakter(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
        inventar = new Inventar();
    }

    public final Inventar getInventar() {
        return inventar;
    }
}
