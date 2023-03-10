package gegenstand.artefakt;

import gegenstand.artefakt.Trank;

public class Unsichtbarkeitstrank extends Trank {

    public Unsichtbarkeitstrank(String formDerAnwendung) {
        super(formDerAnwendung);
    }

    @Override
    //Unsichtbar - nicht angreifbar - schleichen und verstecken erfolgreich
    public int Auswirkung() {
        return 0;
    }

}
