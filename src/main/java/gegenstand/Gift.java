package gegenstand;

public class Gift extends Trank {

    public Gift(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    //-6 LP
    public int Auswirkung(int lebenspuenkteAktuell) {
        return lebenspuenkteAktuell - 6;
    }
}
