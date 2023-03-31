//Autor: Melissa Maas
package gegenstand;

public abstract class Gegenstand {
    private final String formDerAnwendung;
    private final double preis;
    private final double gewicht;

    protected Gegenstand(String formDerAnwendung, double preis, double gewicht) {
        this.formDerAnwendung = formDerAnwendung;
        this.preis = preis;
        this.gewicht = gewicht;
    }

    public final String getFormDerAnwendung() {
        return formDerAnwendung;
    }

    public final double getPreis() {
        return preis;
    }
    public final double getGewicht() {
        return gewicht;
    }
}