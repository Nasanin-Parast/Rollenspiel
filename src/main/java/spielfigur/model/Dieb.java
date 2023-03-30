package spielfigur.model;

import gegenstand.ruestung.Lederruestung;
import gegenstand.waffe.BogenMitPfeilen;
import gegenstand.waffe.Degen;
import gegenstand.waffe.Dolch;

public class Dieb extends Charakter {
    public Dieb(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, 8);
        inventar.add(new Lederruestung());
        inventar.add(new Dolch());
        inventar.add(new BogenMitPfeilen());
        inventar.add(new Degen());
    }
}
