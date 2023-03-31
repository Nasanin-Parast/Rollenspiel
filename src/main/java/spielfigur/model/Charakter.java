package spielfigur.model;

import inventar.Inventar;

public abstract class Charakter extends Spielfigur {
    protected Inventar inventar;
    protected Charakter(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
        this.inventar = inventar;
    }

}
