package gegenstand;

import gegenstand.ruestung.*;
import gegenstand.waffe.*;
/**
 * @author Melissa Maas, Nasanin Parast
 */
public class GegenstandFactory {

    public static Gegenstand newGegenstand(String gegenstand){
        if(gegenstand.equals("Umhang")) {
            return new Umhang();
        }
        if (gegenstand.equals("Amulett")) {
            return new Amulett();
        }
        if(gegenstand.equals("Ring")){
            return new Ring();
        }
        if(gegenstand.equals("Heiltrank")){
            return new Heiltrank();
        }
        if(gegenstand.equals("Gift")) {
            return new Gift();
        }
        if(gegenstand.equals("Unsichtbarkeitstrank")) {
            return new Unsichtbarkeitstrank();
        }
        if(gegenstand.equals("keineRuestung")) {
            return new KeineRuestung();
        }
        if(gegenstand.equals("Lederruestung")) {
            return new Lederruestung();
        }
        if(gegenstand.equals("Schuppenpanzer")) {
            return new Schuppenpanzer();
        }
        if(gegenstand.equals("Kettenpanzer")) {
            return new Kettenpanzer();
        }
        if(gegenstand.equals("Schild")) {
            return new Schild();
        }
        if(gegenstand.equals("keineWaffe")) {
            return new KeineWaffe();
        }
        if(gegenstand.equals("Dolch")) {
            return new Dolch();
        }
        if(gegenstand.equals("Wurfpfeile")) {
            return new Wurfpfeil();
        }
        if(gegenstand.equals("Knüppel")) {
            return new Knueppel();
        }
        if(gegenstand.equals("Handaxt")) {
            return new Handaxt();
        }
        if(gegenstand.equals("Streitaxt")) {
            return new Streitaxt();
        }
        if(gegenstand.equals("Speer")) {
            return new Speer();
        }
        if(gegenstand.equals("Schwert")) {
            return new Schwert();
        }
        if(gegenstand.equals("Degen")) {
            return new Degen();
        }
        if(gegenstand.equals("Bogen mit Pfeilen")) {
            return new BogenMitPfeilen();
        }

        return null;
    }
}
