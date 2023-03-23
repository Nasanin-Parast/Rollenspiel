package spielfigur.model;

import gegenstand.waffe.Dolch;
import gegenstand.waffe.Wurfpfeil;

public class Magier extends Charakter {
    public Magier(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, 6);
        inventar.add(new Dolch('d',1.,1,1));
        inventar.add(new Wurfpfeil('f',1.,1,1,1));
        inventar.add(new Dolch('d',1.,1,1));
    }
}
