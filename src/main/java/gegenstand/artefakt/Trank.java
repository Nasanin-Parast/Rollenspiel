package gegenstand.artefakt;

import gegenstand.artefakt.Artefakt;

public class Trank extends Artefakt {

    public Trank(String formDerAnwendung) {
        super(formDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }

    @Override
    public void interagiereMitGegenstand() {

    }
}
