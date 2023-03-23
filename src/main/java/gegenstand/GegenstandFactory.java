package gegenstand;

import gegenstand.ruestung.*;
import gegenstand.waffe.*;

public class GegenstandFactory {

    public static Gegenstand newGegenstand(String gegenstand){
        if(gegenstand.equals("Umhang")) {
            return new Umhang("wear");
        }
        if (gegenstand.equals("Amulett")) {
            return new Amulett("use");
        }
        if(gegenstand.equals("Ring")){
            return new Ring("waer");
        }
        if(gegenstand.equals("Heiltrank")){
            return new Heiltrank("drink");
        }
        if(gegenstand.equals("Gift")) {
            return new Gift("drink");
        }
        if(gegenstand.equals("Unsichtbarkeitstrank")) {
            return new Unsichtbarkeitstrank("drink");
        }
        if(gegenstand.equals("keineRuestung")) {
            return new KeineRuestung(0, ' ', 0, 0);
        }
        if(gegenstand.equals("Lederruestung")) {
            return new Lederruestung(1, 'D', 10, 10);
        }
        if(gegenstand.equals("Schuppenpanzer")) {
            return new Schuppenpanzer(4, 'D', 50, 45);
        }
        if(gegenstand.equals("Kettenpanzer")) {
            return new Kettenpanzer(6, ' ', 75, 55);
        }
        if(gegenstand.equals("Schild")) {
            return new Schild(2, ' ', 0, 6);
        }
        if(gegenstand.equals("keineWaffe")) {
            return new KeineWaffe('S', 0, 0, 0);
        }
        if(gegenstand.equals("Dolch")) {
            return new Dolch('D', 2, 1, 2);
        }
        if(gegenstand.equals("Wurfpfeile")) {
            return new Wurfpfeil('D', (1 / 20), (1 / 4), 2, 20);
        }
        if(gegenstand.equals("Knüppel")) {
            return new Knueppel('S', 1, 3, 1);
        }
        if(gegenstand.equals("Handaxt")) {
            return new Handaxt(' ', 5, 2, 2);
        }
        if(gegenstand.equals("Streitaxt")) {
            return new Streitaxt('S', 10, 4, 0);
        }
        if(gegenstand.equals("Speer")) {
            return new Speer(' ', 2, 3, 2);
        }
        if(gegenstand.equals("Schwert")) {
            return new Schwert('S', 15, 3, 0);
        }
        if(gegenstand.equals("Degen")) {
            return new Degen('D', 25, 2, 0);
        }
        if(gegenstand.equals("Bogen mit Pfeilen")) {
            return new BogenMitPfeilen('D', 15, 2, 6, 20);
        }

        return null;
    }
}
