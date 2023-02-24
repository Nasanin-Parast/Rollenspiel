package builder;
import model.Rasse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MagierBuilderTest {
    private static final String NAME = "Magier";
    private static final String NAME_EXPECTED = "Magier";
    private static final int INTELLIGENZ = 9;
    private static final int INTELLIGENZ_EXPECTED = 7;
    private static final int STAERKE = 2;
    private static final int STAERKE_EXPECTED = 2;
    private static final int KONSTITUTION = 8;
    private static final int KONSTITUTION_EXPECTED  = 8;
    private static final int WEISHEIT = 4;
    private static final int WEISHEIT_EXPECTED = 3;
    private static final int GESCHICKLICHKEIT = 5;
    private static final int GESCHICKLICHKEIT_EXPECTED = 3;
    Charakter charakterExpected;

    @Test
    void changeMagierWithBuilder(){
        charakterExpected= new MagierBuilder().withName(NAME_EXPECTED).withStaerke(STAERKE_EXPECTED).withGeschicklichkeit(GESCHICKLICHKEIT_EXPECTED).withWeisheit(WEISHEIT_EXPECTED).withIntelligenz(INTELLIGENZ_EXPECTED).withKonstitution(KONSTITUTION_EXPECTED).withRasse(Rasse.Elf).build();
        Assertions.assertEquals(NAME,charakterExpected.getName());
        Assertions.assertEquals(STAERKE,charakterExpected.getStaerke());
        Assertions.assertEquals(GESCHICKLICHKEIT,charakterExpected.getGeschicklichkeit());
        Assertions.assertEquals(WEISHEIT,charakterExpected.getWeisheit());
        Assertions.assertEquals(INTELLIGENZ,charakterExpected.getIntelligenz());
        Assertions.assertEquals(KONSTITUTION,charakterExpected.getKonstitution());
    }
}
