package gegenstand.artefakt;

public class Amulett extends MagischerGegenstand {

    public Amulett(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    //+ Verteidigungsbonus 2
    public int Auswirkung() {
        return 0;
    }
}

