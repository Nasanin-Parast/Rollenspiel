//Autor: Melissa Maas
package gegenstand.waffe;

public class Wurfpfeil extends Waffe {

    private int anzahlGeschosse;

    public Wurfpfeil() {
        super('D', 4, .1, .25);
        setAnzahlGeschosse(20);
    }

    public int getAnzahlGeschosse() {
        return anzahlGeschosse;
    }

    public void setAnzahlGeschosse(int anzahlGeschosse) {
        this.anzahlGeschosse = anzahlGeschosse;
    }
}
