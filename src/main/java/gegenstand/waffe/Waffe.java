//Autor: Melissa Maas
package gegenstand.waffe;

import gegenstand.Gegenstand;

public abstract class Waffe extends Gegenstand {

    private final int schadenwuerfel;
    private final char schadenUndAngriffModifizierer;

    protected Waffe(char modifier, int schaden, double preis, double gewicht) {
        super("use", preis, gewicht);
        this.schadenwuerfel = schaden;
        this.schadenUndAngriffModifizierer = modifier;
    }

    public int getSchadenwuerfel() {
        return schadenwuerfel;
    }

    public char getSchadenUndAngriffModifizierer() {
        return schadenUndAngriffModifizierer;
    }
}
