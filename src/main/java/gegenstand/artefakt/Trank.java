//Autor: Melissa Maas
package gegenstand.artefakt;

import gegenstand.artefakt.Artefakt;

public abstract class Trank extends Artefakt {

    public Trank(double preis) {
        super("use", preis, 0.2);
    }
}
