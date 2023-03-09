package gegenstand.artefakt;

import gegenstand.artefakt.Trank;

public class Unsichtbarkeitstrank extends Trank {

    public Unsichtbarkeitstrank(String formDerAnwendung) {
        super(formDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
