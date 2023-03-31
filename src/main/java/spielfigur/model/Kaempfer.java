package spielfigur.model;

import gegenstand.Gegenstand;
import gegenstand.ruestung.Kettenpanzer;
import gegenstand.ruestung.Lederruestung;
import gegenstand.waffe.BogenMitPfeilen;
import gegenstand.waffe.Handaxt;
import gegenstand.waffe.Waffe;

public class Kaempfer extends Charakter {
    public Kaempfer(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, 10);
        inventar.add(new Kettenpanzer());
        inventar.add(new Lederruestung());
        inventar.add(new BogenMitPfeilen());
        inventar.add(new Handaxt());
    }
}
