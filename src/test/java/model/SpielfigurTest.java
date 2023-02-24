package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpielfigurTest {
    private static final String NAME = "Bob";
    private static final int INTELLIGENZ = 5;
    private static final int STAERKE = 4;
    private static final int KONSTITUTION = 12;
    private static final int WEISHEIT = 1;
    private static final int GESCHICKLICHKEIT = 8;
    private static final int LEBENSPUENKTEMAX = 7;
    private static final int BASIS_LP = 6;
    private Spielfigur spielfigur;

    @DisplayName("Teste Konstruktor, berechneMaxLP() und modifier()")
    @Test
    void constructorTest() {
        spielfigur = Mockito.mock(Spielfigur.class, Mockito.withSettings().useConstructor(NAME, INTELLIGENZ, STAERKE, KONSTITUTION, WEISHEIT, GESCHICKLICHKEIT, BASIS_LP).defaultAnswer(Answers.CALLS_REAL_METHODS));
        assertEquals(NAME, spielfigur.getName());
        assertEquals(INTELLIGENZ, spielfigur.getIntelligenz());
        assertEquals(STAERKE, spielfigur.getStaerke());
        assertEquals(KONSTITUTION, spielfigur.getKonstitution());
        assertEquals(WEISHEIT, spielfigur.getWeisheit());
        assertEquals(GESCHICKLICHKEIT, spielfigur.getGeschicklichkeit());
        assertEquals(LEBENSPUENKTEMAX, spielfigur.getLebenspuenkteMax());
        assertEquals(LEBENSPUENKTEMAX,spielfigur.getLebenspuenkteAktuell());
    }

}
