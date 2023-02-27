package spielfigur.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UnitTest")
public class MagierTest {

    private static final String NAME = "Madiger Max";
    private static final int EIG_NORMAL = 10;
    private static final int LP_NORMAL = 6;

    @Test
    void testBasisLP() {
        Spielfigur magier = new Magier(NAME, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL);

        assertEquals(LP_NORMAL, magier.getLebenspuenkteMax());
    }
}
