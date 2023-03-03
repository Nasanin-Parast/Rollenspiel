package gegenstand;

import gegenstand.artefakt.Artefakt;

public class Trank extends Artefakt {

    public Trank(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
