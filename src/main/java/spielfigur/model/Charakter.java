package spielfigur.model;

public abstract class Charakter extends Spielfigur {
    public Charakter(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
    }
}
