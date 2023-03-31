package spielfigur.model;

import java.io.Serializable;

public abstract class Charakter extends Spielfigur implements Serializable {
    protected Charakter(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
    }
}
