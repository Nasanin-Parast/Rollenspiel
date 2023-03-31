package spielfigur.builder;
import org.junit.jupiter.api.Tag;
import spielfigur.model.Charakter;
import spielfigur.model.Kaempfer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
class KaempferBuilderTest {

    private static final String NAME = "Kämpfer";
    private static final int INTELLIGENZ = 7;
    private static final int STAERKE = 12;
    private static final int KONSTITUTION = 9;
    private static final int WEISHEIT = 5;
    private static final int GESCHICKLICHKEIT = 5;
    private static final Rasse RASSE = Rasse.HOBBIT;

    @Test
    void createKaempferWithBuilder() {
        CharakterBuilder builder = new KaempferBuilder().withName(NAME)
                .withIntelligenz(INTELLIGENZ)
                .withStaerke(STAERKE)
                .withKonstitution(KONSTITUTION)
                .withWeisheit(WEISHEIT)
                .withGeschicklichkeit(GESCHICKLICHKEIT)
                .withRasse(RASSE);

        Charakter kaempfer = builder.build();

        Assertions.assertTrue(kaempfer instanceof Kaempfer);
    }
}
