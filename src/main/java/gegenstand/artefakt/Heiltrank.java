package gegenstand.artefakt;

public class Heiltrank extends Trank {

    public Heiltrank(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    //+ 2xd4 + 2 LP
    public int Auswirkung() {
        return 0;
    }
}
