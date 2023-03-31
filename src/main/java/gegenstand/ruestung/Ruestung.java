package gegenstand.ruestung;

import gegenstand.Gegenstand;
/**
 * @author Melissa Maas, Nasanin Parast
 */
public abstract class Ruestung extends Gegenstand {

    private final int ruestungsklasse;
    private final char ruestungsklasseModefizierer;

    protected Ruestung(char modifier, int ruestungsklasse, double preis, double gewicht) {
        super("wear", preis, gewicht);
        this.ruestungsklasseModefizierer = modifier;
        this.ruestungsklasse = ruestungsklasse;
    }


    public int getRuestungsklasse() {
        return ruestungsklasse;
    }

    public char getRuestungsklasseModefizierer() {
        return ruestungsklasseModefizierer;
    }
}
