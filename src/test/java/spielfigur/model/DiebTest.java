package spielfigur.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UnitTest")
class DiebTest {

    private static final String NAME = "Dreckiger Dan";
    private static final int EIG_NORMAL = 10;
    private static final int LP_NORMAL = 8;

    @Test
    void testBasisLP() {
        Spielfigur dieb = new Dieb(NAME, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL, EIG_NORMAL);

        assertEquals(LP_NORMAL, dieb.getLebenspuenkteMax());
    }
}
