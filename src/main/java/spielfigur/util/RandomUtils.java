package spielfigur.util;

import java.util.*;

public class RandomUtils {

    public static int[] getCharakterWerte() {
        int[] werte = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            werte[i] = random.nextInt(16) + 3;
        }
        while (Arrays.stream(werte).sum() < 60) {
            Arrays.sort(werte);
            werte[0] = random.nextInt(16) + 3;
        }
        return werte;
    }

}
