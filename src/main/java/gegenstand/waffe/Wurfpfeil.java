package gegenstand.waffe;

public class Wurfpfeil extends Waffe {

    private int anzahlGeschosse;

    public Wurfpfeil(char schadenUndAngriffModifizierer, double preis, int gewichtInPfund, int einsetzbarBisSpielfeld, int anzahlGeschosse) {
        super(schadenUndAngriffModifizierer, preis, gewichtInPfund, einsetzbarBisSpielfeld);
        setAnzahlGeschosse(anzahlGeschosse);
    }

    public int getAnzahlGeschosse() {return anzahlGeschosse;}

    public void setAnzahlGeschosse(int anzahlGeschosse) {this.anzahlGeschosse = anzahlGeschosse;}
}
