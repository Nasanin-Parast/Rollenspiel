package spielfigur.util;

import java.util.*;

public class RandomUtils {

    private static Random random = new Random();

    public static int[] getCharakterWerte() {
        int[] werte = new int[5];
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
