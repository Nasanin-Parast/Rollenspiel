package spielfigur.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrollTest {
    private static final String NAME = "Troll";
    private static final int INTELLIGENZ = 10;
    private static final int STAERKE = 13;
    private static final int KONSTITUTION = 9;
    private static final int WEISHEIT = 7;
    private static final int GESCHICKLICHKEIT = 3;
    private static final int LEBENSPUENKTEMAX = 5;

    @Test
    void testKonstruktor() {
        Monster troll = new Troll();
        assertEquals(NAME, troll.getName());
        assertEquals(INTELLIGENZ, troll.getIntelligenz());
        assertEquals(STAERKE, troll.getStaerke());
        assertEquals(KONSTITUTION, troll.getKonstitution());
        assertEquals(WEISHEIT, troll.getWeisheit());
        assertEquals(GESCHICKLICHKEIT, troll.getGeschicklichkeit());
        assertEquals(LEBENSPUENKTEMAX, troll.getLebenspuenkteMax());
        assertEquals(LEBENSPUENKTEMAX, troll.getLebenspuenkteAktuell());
    }
}
