package gegenstand;

public class Ring extends MagischerGegenstand {

    public Ring(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung(int lebenspuenkteAktuell) {
        return lebenspuenkteAktuell;
    }
}
