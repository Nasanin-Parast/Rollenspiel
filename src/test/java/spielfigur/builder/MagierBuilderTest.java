package spielfigur.builder;
import org.junit.jupiter.api.Tag;
import spielfigur.model.Charakter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spielfigur.model.Magier;

@Tag("UnitTest")
public class MagierBuilderTest {

    private static final String NAME = "Magier";
    private static final int INTELLIGENZ = 9;
    private static final int STAERKE = 7;
    private static final int KONSTITUTION = 8;
    private static final int WEISHEIT = 4;
    private static final int GESCHICKLICHKEIT = 5;
    private static final Rasse RASSE = Rasse.Elf;

    @Test
    void createMagierWithBuilder() {
        CharakterBuilder builder = new MagierBuilder().withName(NAME)
                .withStaerke(STAERKE)
                .withGeschicklichkeit(GESCHICKLICHKEIT)
                .withWeisheit(WEISHEIT)
                .withIntelligenz(INTELLIGENZ)
                .withKonstitution(KONSTITUTION)
                .withRasse(RASSE);

        Charakter magier = builder.build();

        Assertions.assertTrue(magier instanceof Magier);
    }
}
