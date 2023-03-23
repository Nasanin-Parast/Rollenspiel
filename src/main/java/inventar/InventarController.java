package inventar;

import gegenstand.Amulett;
import gegenstand.Gegenstand;
import gegenstand.MagischerGegenstand;
import gegenstand.Trank;
import gegenstand.ruestung.Kettenpanzer;
import gegenstand.ruestung.Lederruestung;
import gegenstand.ruestung.Schild;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventarController {

    Map<Integer, Inventar> inventare = new HashMap<>();

    public List<Gegenstand> getGegenstaende(int inventarId) {
        return inventare.get(inventarId).getGegenstaende();
    }

    public List<Gegenstand> getMagischeGegenstaende(int inventarId) {
        return inventare.get(inventarId).getGegenstaende().stream().filter(e -> e instanceof MagischerGegenstand).collect(Collectors.toList());
    }

    public void create() {
        Inventar inventar = new Inventar();
        inventar.add(new Kettenpanzer(1, 'E', 1., 1.));
        inventar.add(new Schild(1, 'E', 1., 1.));
        inventar.add(new Amulett("FromDer"));
        inventar.add(new Lederruestung(1, 'E', 1., 1.));
        inventare.put(1, inventar);
    }

}
