package spielfigur.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("UnitTest")
class CharakterTest {
    private static final String NAME = "Bob";
    private static final int INTELLIGENZ = 5;
    private static final int STAERKE = 4;
    private static final int KONSTITUTION = 12;
    private static final int WEISHEIT = 16;
    private static final int GESCHICKLICHKEIT = 8;
    private static final int LEBENSPUENKTEMAX = 7;
    private static final int BASIS_LP = 6;
    Spielfigur spielfigur;

    @Test
    void checkConstructor(){
        spielfigur = Mockito.mock(Charakter.class, Mockito.withSettings().defaultAnswer(Answers.CALLS_REAL_METHODS)
                .useConstructor(NAME, INTELLIGENZ, STAERKE, KONSTITUTION, WEISHEIT, GESCHICKLICHKEIT, BASIS_LP));
        assertEquals(NAME, spielfigur.getName());
        assertEquals(INTELLIGENZ, spielfigur.getIntelligenz());
        assertEquals(STAERKE, spielfigur.getStaerke());
        assertEquals(KONSTITUTION, spielfigur.getKonstitution());
        assertEquals(WEISHEIT, spielfigur.getWeisheit());
        assertEquals(GESCHICKLICHKEIT, spielfigur.getGeschicklichkeit());
        assertEquals(LEBENSPUENKTEMAX, spielfigur.getLebenspuenkteMax());
        assertEquals(LEBENSPUENKTEMAX,spielfigur.getLebenspuenkteAktuell()); {

        }
    }

}
