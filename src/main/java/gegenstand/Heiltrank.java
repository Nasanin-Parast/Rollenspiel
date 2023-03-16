package gegenstand;

import java.util.Random;

public class Heiltrank extends Trank {

    public Heiltrank(String fromDerAnwendung) {
        super(fromDerAnwendung);
    }

    @Override
    //+ 2xd4 + 2 LP
    public int Auswirkung(int lebenspuenkteAktuell) {
        int min = 1;
        int max = 4;

        Random random = new Random();

        int d4_Nr1 = random.nextInt(max + min) + min;
        int d4_Nr2 = random.nextInt(max + min) + min;

        return lebenspuenkteAktuell + d4_Nr1 + d4_Nr2 + 2;
    }
}
