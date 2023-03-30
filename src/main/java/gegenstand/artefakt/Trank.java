//Autor: Melissa Maas
package gegenstand.artefakt;

import gegenstand.artefakt.Artefakt;

public abstract class Trank extends Artefakt {

    public Trank(String formDerAnwendung) {super(formDerAnwendung);}

    @Override
    public abstract int Auswirkung(int lebenspuenkteAktuell);

    @Override
    public String interagiereMitGegenstand() {
        return "Trank: " + this.getClass().getSimpleName();
    }
}
