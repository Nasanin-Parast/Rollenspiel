package gegenstand.waffe;

import gegenstand.Gegenstand;

public abstract class Waffe extends Gegenstand {

    private int schadenwuerfel;
    private char schadenUndAngriffModifizierer;
    private double preis;
    private int gewichtInPfund;
    private int einsetzbarBisSpielfeld;

    public Waffe(char schadenUndAngriffModifizierer, double preis, int gewichtInPfund, int einsetzbarBisSpielfeld){

    }

    public int getSchadenwuerfel() {return schadenwuerfel;}

    public char getSchadenUndAngriffModifizierer() {return schadenUndAngriffModifizierer;}

    public double getPreis() {return preis;}

    public int getGewichtInPfund() {return gewichtInPfund;}

    public int getEinsetzbarBisSpielfeld() {return einsetzbarBisSpielfeld;}

    public void setSchadenwuerfel(int schadenwuerfel) {this.schadenwuerfel = schadenwuerfel;}

    public void setSchadenUndAngriffModifizierer(char schadenUndAngriffModifizierer) {
        this.schadenUndAngriffModifizierer = schadenUndAngriffModifizierer;
    }

    public void setPreis(double preis) {this.preis = preis;}

    public void setGewichtInPfund(int gewichtInPfund) {this.gewichtInPfund = gewichtInPfund;}

    public void setEinsetzbarBisSpielfeld(int einsetzbarBisSpielfeld) {
        this.einsetzbarBisSpielfeld = einsetzbarBisSpielfeld;
    }

    @Override
    public void interagiereMitGegenstand() {

    }
}
