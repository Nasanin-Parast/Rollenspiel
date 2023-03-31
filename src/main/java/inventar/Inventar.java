package inventar;

import gegenstand.Gegenstand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventar implements Serializable {

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

}
