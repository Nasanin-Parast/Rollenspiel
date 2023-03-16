package gegenstand;

public class MagischerGegenstand extends Artefakt {

    public MagischerGegenstand(String formDerAnwendung) {
        super(formDerAnwendung);
    }

    @Override
    public int Auswirkung(int lebenspuenkteAktuell) {
        return lebenspuenkteAktuell;
    }
}
