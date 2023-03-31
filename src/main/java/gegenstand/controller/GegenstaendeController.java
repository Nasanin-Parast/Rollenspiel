package gegenstand.controller;


import gegenstand.Gegenstand;
import gegenstand.GegenstandFactory;
import spielfigur.model.Charakter;

public class GegenstaendeController {

    Charakter charakter;
    private String[] gegenstand;
    public GegenstaendeController(){
        Gegenstand gegenstand = getGegenstaende();
    }
    public Gegenstand getGegenstaende() {
        return null;
    }

    public void setMagisch(String magisch) {
//        charakter.useGegenstand(gegenstand);
    }

    public void setWaffe(String waffe) {
    }

    public void setRuesstung(String ruesstung) {
    }

    public void setTraenke(String traenke) {
    }

}
