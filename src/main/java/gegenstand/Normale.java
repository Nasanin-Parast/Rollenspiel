package gegenstand;

import gegenstand.artefakt.Artefakt;

public class Normale extends Artefakt {

    public Normale(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
