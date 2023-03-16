package gegenstand.waffe;

public class BogenMitPfeilen extends Waffe {

    private int anzahlGeschosse;

    public BogenMitPfeilen(char schadenUndAngriffModifizierer, double preis, int gewichtInPfund, int einsetzbarBisSpielfeld, int anzahlGeschosse) {
        super(schadenUndAngriffModifizierer, preis, gewichtInPfund, einsetzbarBisSpielfeld);
    }

    public int getAnzahlGeschosse() {return anzahlGeschosse;}

    public void setAnzahlGeschosse(int anzahlGeschosse) {this.anzahlGeschosse = anzahlGeschosse;}
}
