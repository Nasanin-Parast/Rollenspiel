package spielfigur.builder;

import org.junit.jupiter.api.Tag;
import spielfigur.model.Charakter;
import spielfigur.model.Dieb;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
class DiebBuilderTest {

    private static final String NAME = "Dieb";
    private static final int INTELLIGENZ = 9;
    private static final int STAERKE = 12;
    private static final int KONSTITUTION = 8;
    private static final int WEISHEIT = 4;
    private static final int GESCHICKLICHKEIT = 5;
    private static final Rasse RASSE = Rasse.MENSCH;

    @Test
    void createDiebWithBuilder() {
       CharakterBuilder builder = new DiebBuilder().withName(NAME)
               .withIntelligenz(INTELLIGENZ)
               .withStaerke(STAERKE)
               .withKonstitution(KONSTITUTION)
               .withWeisheit(WEISHEIT)
               .withGeschicklichkeit(GESCHICKLICHKEIT)
               .withRasse(RASSE);

       Charakter dieb = builder.build();

        Assertions.assertTrue(dieb instanceof Dieb);
    }
}
