package gegenstand.artefakt;

import gegenstand.artefakt.Artefakt;

public class MagischerGegenstand extends Artefakt {

    public MagischerGegenstand(String formDerAnwendung) {
        super(formDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
