//Autor: Melissa Maas
package gegenstand.artefakt;

import gegenstand.Gegenstand;

public abstract class Artefakt extends Gegenstand {

    protected Artefakt(String formDerAnwendung, double preis, double gewicht) {
        super(formDerAnwendung, preis, gewicht);
    }
}
