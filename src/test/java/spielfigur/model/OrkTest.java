package spielfigur.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrkTest {
    private static final String NAME = "Ork";
    private static final int INTELLIGENZ = 10;
    private static final int STAERKE = 11;
    private static final int KONSTITUTION = 12;
    private static final int WEISHEIT = 13;
    private static final int GESCHICKLICHKEIT = 14;
    private static final int LEBENSPUENKTEMAX = 9;

    @Test
    void testKonstruktor() {
        Monster ork = new Ork();
        assertEquals(NAME, ork.getName());
        assertEquals(INTELLIGENZ, ork.getIntelligenz());
        assertEquals(STAERKE, ork.getStaerke());
        assertEquals(KONSTITUTION, ork.getKonstitution());
        assertEquals(WEISHEIT, ork.getWeisheit());
        assertEquals(GESCHICKLICHKEIT, ork.getGeschicklichkeit());
        assertEquals(LEBENSPUENKTEMAX, ork.getLebenspuenkteMax());
        assertEquals(LEBENSPUENKTEMAX, ork.getLebenspuenkteAktuell());
    }
}
