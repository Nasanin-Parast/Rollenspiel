package gegenstand;

import gegenstand.artefakt.Artefakt;

public class MagischerGegenstand extends Artefakt {

    public MagischerGegenstand(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
