package spielfigur.model;

public abstract class Charakter extends Spielfigur {
    protected Charakter(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
    }
}
