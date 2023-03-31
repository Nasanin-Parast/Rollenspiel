package inventar;

import gegenstand.*;
import gegenstand.artefakt.Amulett;
import gegenstand.artefakt.MagischerGegenstand;
import gegenstand.artefakt.Ring;
import gegenstand.falle.Stein;
import gegenstand.ruestung.*;
import gegenstand.waffe.*;
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
        inventar.add(new Kettenpanzer());
        inventar.add(new Schild());
        inventar.add(new Amulett());
        inventar.add(new Lederruestung());
        inventar.add(new Ring());
        inventar.add(new Dolch());
        inventar.add(new BogenMitPfeilen());
        inventar.add(new Wurfpfeil());
        inventar.add(new Handaxt());
        inventar.add(new Streitaxt());
        inventar.add(new Speer());
        inventar.add(new Schwert());
        inventar.add(new Degen());
        inventar.add(new KeineWaffe());
        inventar.add(new KeineRuestung());
        inventare.put(1, inventar);

    }

}
