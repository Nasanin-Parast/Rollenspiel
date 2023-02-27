package spielfigur.builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spielfigur.exception.MissingAttributeException;
import spielfigur.model.Charakter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@Tag("UnitTest")
public class CharakterBuilderTest {

    private static final String NAME = "Dumbo";
    private static final int INTELLIGENZ = 9;
    private static final int STAERKE = 12;
    private static final int KONSTITUTION = 8;
    private static final int WEISHEIT = 4;
    private static final int GESCHICKLICHKEIT = 5;
    private static final int BASIS_LP = 10;
    private static final Rasse rasse = Rasse.Mensch;

    @Test
    void createCharacter() {
        CharakterBuilder builder = new CharakterBuilderKlasse().withName(NAME)
                .withIntelligenz(INTELLIGENZ)
                .withStaerke(STAERKE)
                .withKonstitution(KONSTITUTION)
                .withWeisheit(WEISHEIT)
                .withGeschicklichkeit(GESCHICKLICHKEIT)
                .withRasse(rasse);

        Charakter charakter = builder.build();

        Assertions.assertEquals(NAME, charakter.getName());
        Assertions.assertEquals(INTELLIGENZ + rasse.getIntBonus(), charakter.getIntelligenz());
        Assertions.assertEquals(STAERKE + rasse.getStrBonus(), charakter.getStaerke());
        Assertions.assertEquals(KONSTITUTION + rasse.getKonBonus(), charakter.getKonstitution());
        Assertions.assertEquals(WEISHEIT + rasse.getWisBonus(), charakter.getWeisheit());
        Assertions.assertEquals(GESCHICKLICHKEIT + rasse.getGesBonus(), charakter.getGeschicklichkeit());
    }

    @Test
    void throwExceptionWhenAttributeNotSet() {
        CharakterBuilder builder = new CharakterBuilderKlasse();
        assertThrows(MissingAttributeException.class, builder::build);
        assertThrows(MissingAttributeException.class, () -> builder.withName(NAME).build());
    }

    @Test
    void checkWerte() {
        int[] werte = {9, 10, 11, 12, 13};
        CharakterBuilder builder = new CharakterBuilderKlasse()
                .withIntelligenz(werte[0])
                .withStaerke(werte[1])
                .withKonstitution(werte[2])
                .withWeisheit(werte[3])
                .withGeschicklichkeit(werte[4]);
        builder.checkWerte(werte);

        builder.withIntelligenz(werte[1]);

        assertThrows(IllegalArgumentException.class, () -> builder.checkWerte(werte));

    }

    static class CharakterBuilderKlasse extends CharakterBuilder {
        @Override
        protected Charakter createCharakter() {
            return mock(Charakter.class, withSettings().defaultAnswer(CALLS_REAL_METHODS)
                    .useConstructor(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, BASIS_LP));
        }
    }
}
