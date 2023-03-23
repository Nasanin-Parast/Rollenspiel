package spielfigur.model;

import gegenstand.ruestung.Lederruestung;
import gegenstand.waffe.BogenMitPfeilen;
import gegenstand.waffe.Degen;
import gegenstand.waffe.Dolch;

public class Dieb extends Charakter {
    public Dieb(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, 8);
        inventar.add(new Lederruestung(1,'e',1.,1.));
        inventar.add(new Dolch('e',1.,1,1));
        inventar.add(new BogenMitPfeilen('a',1.,1,1,1));
        inventar.add(new Degen('a',1.,1,1));
    }
}
