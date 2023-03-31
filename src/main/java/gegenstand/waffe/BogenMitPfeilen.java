package gegenstand.waffe;
/**
 * @author Melissa Maas, Nasanin Parast
 */
public class BogenMitPfeilen extends Waffe {

    private int anzahlGeschosse;

    public BogenMitPfeilen() {
        super('D', 8, 15., 2.);
        setAnzahlGeschosse(20);
    }

    public int getAnzahlGeschosse() {
        return anzahlGeschosse;
    }

    public void setAnzahlGeschosse(int anzahlGeschosse) {
        this.anzahlGeschosse = anzahlGeschosse;
    }
}
