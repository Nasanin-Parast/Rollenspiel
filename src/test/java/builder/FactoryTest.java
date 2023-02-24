package builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactoryTest {
    private static final String DIEB = "Dieb";
    private static final String MAGIER = "Magier";
    private static final String KAEMPFER = "Kaempfer";
    private static final String WRONGDATA = "irgendwas";
    CharakterBuilder charakterBuilder;
    Factory factory;

    @DisplayName("Should successfuly create thief")
    @Test
    void testCreateDiebSuccess() {
        charakterBuilder = factory.createCharakter(DIEB);
        assertTrue(charakterBuilder instanceof DiebBuilder);
    }

    @DisplayName("Should successfuly create magician")
    @Test
    void testCreateMagierSuccess() {
        charakterBuilder = factory.createCharakter(MAGIER);
        assertTrue(charakterBuilder instanceof MagierBuilder);
    }

    @DisplayName("Should successfuly create fighter")
    @Test
    void testCreateKaempferSuccess() {
        charakterBuilder = factory.createCharakter(KAEMPFER);
        assertTrue(charakterBuilder instanceof KaempferBuilder);
    }

    @DisplayName("Should be throw error in case of unequal specifications")
    @Test
    void testInvalidString() {
        assertThrows(IllegalArgumentException.class, ()-> factory.createCharakter(WRONGDATA));
    }

}
