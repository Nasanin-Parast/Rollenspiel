package spielfigur.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DracheTest {
    private static final String NAME = "Drache";
    private static final int INTELLIGENZ = 9;
    private static final int STAERKE = 17;
    private static final int KONSTITUTION = 9;
    private static final int WEISHEIT = 8;
    private static final int GESCHICKLICHKEIT = 10;
    private static final int LEBENSPUENKTEMAX = 15;

    @Test
    void testKonstruktor() {
        Monster drache = new Drache();
        assertEquals(NAME, drache.getName());
        assertEquals(INTELLIGENZ, drache.getIntelligenz());
        assertEquals(STAERKE, drache.getStaerke());
        assertEquals(KONSTITUTION, drache.getKonstitution());
        assertEquals(WEISHEIT, drache.getWeisheit());
        assertEquals(GESCHICKLICHKEIT, drache.getGeschicklichkeit());
        assertEquals(LEBENSPUENKTEMAX, drache.getLebenspuenkteMax());
        assertEquals(LEBENSPUENKTEMAX, drache.getLebenspuenkteAktuell());
    }
}
