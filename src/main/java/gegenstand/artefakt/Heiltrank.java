package gegenstand.artefakt;

public class Heiltrank extends Trank {

    public Heiltrank(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    public int Auswirkung() {
        return 0;
    }
}
