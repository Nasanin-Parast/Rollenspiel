//Autor: Melissa Maas
package gegenstand.falle;

import gegenstand.Gegenstand;

public abstract class Falle extends Gegenstand {

    protected Falle(double preis, double gewicht) {
        super("use", preis, gewicht);
    }
}
