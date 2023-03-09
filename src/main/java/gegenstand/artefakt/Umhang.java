package gegenstand.artefakt;

import gegenstand.artefakt.MagischerGegenstand;

public class Umhang extends MagischerGegenstand {

    public Umhang(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
