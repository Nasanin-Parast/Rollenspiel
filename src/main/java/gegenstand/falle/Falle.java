package gegenstand.falle;

import gegenstand.Gegenstand;

public abstract class Falle extends Gegenstand {

    @Override
    public String interagiereMitGegenstand() {
        return "Falle: " + this.getClass().getSimpleName();
    }
}
