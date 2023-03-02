package spielfigur.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("UnitTest")
public class SpielfigurTest {
    private static final String NAME = "Bob";
    private static final int INTELLIGENZ = 5;
    private static final int STAERKE = 4;
    private static final int KONSTITUTION = 12;
    private static final int WEISHEIT = 17;
    private static final int GESCHICKLICHKEIT = 8;
    private static final int LEBENSPUENKTEMAX = 7;
    private static final int EIGENSCHAFT_ZU_GERING = 2;
    private static final int BASIS_LP = 6;

    @DisplayName("Teste Konstruktor, berechneMaxLP() und modifier()")
    @Test
    void constructorTest() {
        Spielfigur spielfigur = Mockito.mock(Spielfigur.class, Mockito.withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS)
                .useConstructor(NAME, INTELLIGENZ, STAERKE, KONSTITUTION, WEISHEIT, GESCHICKLICHKEIT, BASIS_LP));
        assertEquals(NAME, spielfigur.getName());
        assertEquals(INTELLIGENZ, spielfigur.getIntelligenz());
        assertEquals(STAERKE, spielfigur.getStaerke());
        assertEquals(KONSTITUTION, spielfigur.getKonstitution());
        assertEquals(WEISHEIT, spielfigur.getWeisheit());
        assertEquals(GESCHICKLICHKEIT, spielfigur.getGeschicklichkeit());
        assertEquals(LEBENSPUENKTEMAX, spielfigur.getLebenspuenkteMax());
        assertEquals(LEBENSPUENKTEMAX,spielfigur.getLebenspuenkteAktuell());
    }

    @Test
    @DisplayName("Teste Konstruktor mit zu geringen Werten")
    void constructorTest2() {
        assertThrows(IllegalArgumentException.class, () ->
                new SpielfigurKlasse(NAME, EIGENSCHAFT_ZU_GERING, STAERKE, KONSTITUTION, WEISHEIT, GESCHICKLICHKEIT, BASIS_LP));
        assertThrows(IllegalArgumentException.class, () ->
                new SpielfigurKlasse(NAME, INTELLIGENZ, EIGENSCHAFT_ZU_GERING, KONSTITUTION, WEISHEIT, GESCHICKLICHKEIT, BASIS_LP));
        assertThrows(IllegalArgumentException.class, () ->
                new SpielfigurKlasse(NAME, INTELLIGENZ, STAERKE, EIGENSCHAFT_ZU_GERING, WEISHEIT, GESCHICKLICHKEIT, BASIS_LP));
        assertThrows(IllegalArgumentException.class, () ->
                new SpielfigurKlasse(NAME, INTELLIGENZ, STAERKE, KONSTITUTION, EIGENSCHAFT_ZU_GERING, GESCHICKLICHKEIT, BASIS_LP));
        assertThrows(IllegalArgumentException.class, () ->
                new SpielfigurKlasse(NAME, INTELLIGENZ, STAERKE, KONSTITUTION, WEISHEIT, EIGENSCHAFT_ZU_GERING, BASIS_LP));
    }

    static class SpielfigurKlasse extends Spielfigur {
        public SpielfigurKlasse(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
            super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
        }
    }

}
