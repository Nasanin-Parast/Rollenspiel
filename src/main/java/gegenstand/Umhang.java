package gegenstand;

public class Umhang extends MagischerGegenstand {

    public Umhang(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    //Unsichtbar - nicht angreifbar - schleichen und verstecken erfolgreich
    public int Auswirkung(int lebenspuenkteAktuell) {

        System.out.println("Unsichtbar - nicht angreifbar - schleichen und verstecken erfolgreich");
        return lebenspuenkteAktuell;
    }
}
