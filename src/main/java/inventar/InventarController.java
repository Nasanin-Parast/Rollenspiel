package inventar;

import gegenstand.Amulett;
import gegenstand.Gegenstand;
import gegenstand.MagischerGegenstand;
import gegenstand.Trank;
import gegenstand.ruestung.Kettenpanzer;
import gegenstand.ruestung.Lederruestung;
import gegenstand.ruestung.Schild;
import gegenstand.ruestung.Schuppenpanzer;
import gegenstand.waffe.*;

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
        inventar.add(new Amulett("FromDer"));
        inventar.add(new Kettenpanzer(1, 'E', 1., 1.));
        inventar.add(new Lederruestung(1, 'E', 1., 1.));
        inventar.add(new Schuppenpanzer(5, 'D', 3., 3.));
        inventar.add(new Schild(1, 'E', 1., 1.));
        inventar.add(new Dolch('D', 4., 6, 5));
        inventar.add(new Wurfpfeil('D', 4., 6, 5, 3));
        inventar.add(new Handaxt('D', 2., 2, 2));
        inventar.add(new Streitaxt('D', 4., 6, 5));
        inventar.add(new Speer('D', 4., 6, 5));
        inventar.add(new Schwert('D', 4., 6, 5));
        inventar.add(new Degen('D', 4., 6, 5));
        inventar.add(new BogenMitPfeilen('D', 4., 6, 5, 3));
        inventare.put(1, inventar);
    }

}
