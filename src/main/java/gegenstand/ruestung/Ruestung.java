//Autor: Melissa Maas
package gegenstand.ruestung;

import gegenstand.Gegenstand;

public abstract class Ruestung extends Gegenstand {

    private int ruestungsklasse;
    private char ruestungsklasseModefizierer;
    private double preis;
    private double gewichtInPfund;

    public Ruestung(int ruestungsklasse, char ruestungsklasseModefizierer,double preis, double gewichtInPfund){

    }

    public int getRuestungsklasse() {return ruestungsklasse;}

    public char getRuestungsklasseModefizierer() {return ruestungsklasseModefizierer;}

    public double getPreis() {return preis;}

    public double getGewichtInPfund() {return gewichtInPfund;}

    public void setRuestungsklasse(int ruestungsklasse) {this.ruestungsklasse = ruestungsklasse;}

    public void setRuestungsklasseModefizierer(char ruestungsklasseModefizierer) {this.ruestungsklasseModefizierer = ruestungsklasseModefizierer;}

    public void setPreis(double preis) {this.preis = preis;}

    public void setGewichtInPfund(double gewichtInPfund) {this.gewichtInPfund = gewichtInPfund;}

    @Override
    public String interagiereMitGegenstand() {
        return "Rüstung: " + this.getClass().getSimpleName();
    }
}
