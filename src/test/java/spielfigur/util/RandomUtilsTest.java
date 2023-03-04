package spielfigur.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("UnitTest")
class RandomUtilsTest {

    @Test
    void testValues() {
        int[] werte = RandomUtils.getCharakterWerte();

        assertTrue(Arrays.stream(werte).sum() >= 60);
        assertTrue(werte[0] > 2);
        assertTrue(werte[1] > 2);
        assertTrue(werte[2] > 2);
        assertTrue(werte[3] > 2);
        assertTrue(werte[4] > 2);
    }

}
