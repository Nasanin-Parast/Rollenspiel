package inventar;

import gegenstand.Amulett;
import gegenstand.Gegenstand;

import java.util.ArrayList;
import java.util.List;

public class Inventar {

    private int inventarId;
    private List<Gegenstand> gegenstaende;

    public Inventar() {
        gegenstaende = new ArrayList<>();
    }

    public void add(Gegenstand gegenstand) {
        gegenstaende.add(gegenstand);
    }

    public List<Gegenstand> getGegenstaende() {
        return gegenstaende;
    }

    public List<Gegenstand> getAmulette() {
        return gegenstaende.stream().filter(e -> e instanceof Amulett).toList();
    }
}
