//Autor: Melissa Maas
package gegenstand.artefakt;

import gegenstand.artefakt.Artefakt;

public class Normale extends Artefakt {

    public Normale(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung(int lebenspuenkteAktuell) {
        return lebenspuenkteAktuell;
    }
}
