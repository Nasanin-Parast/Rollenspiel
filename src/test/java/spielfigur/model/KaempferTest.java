package spielfigur.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UnitTest")
class KaempferTest {

    private static final String NAME = "Kleinlicher Kevin";
    private static final int EIG_NORMAL = 10;
    private static final int LP_NORMAL = 10;

    @Test
    void testBasisLP() {
        Spielfigur kaempfer = new Kaempfer(NAME, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL);

        assertEquals(LP_NORMAL, kaempfer.getLebenspuenkteMax());
    }
}
