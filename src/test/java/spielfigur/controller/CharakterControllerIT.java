package spielfigur.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spielfigur.builder.Rasse;
import spielfigur.exception.MissingAttributeException;
import spielfigur.model.Charakter;
import spielfigur.model.Dieb;
import spielfigur.model.Kaempfer;
import spielfigur.model.Magier;

import static org.junit.jupiter.api.Assertions.*;

@Tag("IntegrationTest")
public class CharakterControllerIT {

    private static final String DIEB = "Dieb";
    private static final String KAEMPFER = "Kaempfer";
    private static final String MAGIER = "Magier";
    private static final String NAME = "FreshD";
    private static final Rasse RASSE = Rasse.Zwerg;

    private CharakterController controller;

    private int[] verfuegbareWerte;
    private Charakter charakter;

    @BeforeEach
    void setUpClass() {
        controller = new CharakterController();
    }

    @Test
    void createDieb() {
        controller.setCharakterKlasse(DIEB);
        controller.setName(NAME);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setIntelligenz(verfuegbareWerte[1]);
        controller.setStaerke(verfuegbareWerte[3]);
        controller.setKonstitution(verfuegbareWerte[2]);
        controller.setWeisheit(verfuegbareWerte[0]);
        controller.setGeschicklichkeit(verfuegbareWerte[4]);
        controller.setRasse(RASSE);

        charakter = controller.getCharakter();

        assertNotNull(charakter);
        assertTrue(charakter instanceof Dieb);
        assertEquals(NAME, charakter.getName());
        assertEquals(verfuegbareWerte[1] + RASSE.getIntBonus(), charakter.getIntelligenz());
        assertEquals(verfuegbareWerte[3] + RASSE.getStrBonus(), charakter.getStaerke());
        assertEquals(verfuegbareWerte[2] + RASSE.getKonBonus(), charakter.getKonstitution());
        assertEquals(verfuegbareWerte[0] + RASSE.getWisBonus(), charakter.getWeisheit());
        assertEquals(verfuegbareWerte[4] + RASSE.getGesBonus(), charakter.getGeschicklichkeit());
    }

    @Test
    void createKaempfer() {
        controller.setCharakterKlasse(KAEMPFER);
        controller.setName(NAME);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setIntelligenz(verfuegbareWerte[2]);
        controller.setStaerke(verfuegbareWerte[3]);
        controller.setKonstitution(verfuegbareWerte[1]);
        controller.setWeisheit(verfuegbareWerte[4]);
        controller.setGeschicklichkeit(verfuegbareWerte[0]);
        controller.setRasse(RASSE);

        charakter = controller.getCharakter();

        assertNotNull(charakter);
        assertTrue(charakter instanceof Kaempfer);
        assertEquals(NAME, charakter.getName());
        assertEquals(verfuegbareWerte[2] + RASSE.getIntBonus(), charakter.getIntelligenz());
        assertEquals(verfuegbareWerte[3] + RASSE.getStrBonus(), charakter.getStaerke());
        assertEquals(verfuegbareWerte[1] + RASSE.getKonBonus(), charakter.getKonstitution());
        assertEquals(verfuegbareWerte[4] + RASSE.getWisBonus(), charakter.getWeisheit());
        assertEquals(verfuegbareWerte[0] + RASSE.getGesBonus(), charakter.getGeschicklichkeit());
    }

    @Test
    void createMagier() {
        controller.setCharakterKlasse(MAGIER);
        controller.setName(NAME);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setIntelligenz(verfuegbareWerte[0]);
        controller.setStaerke(verfuegbareWerte[2]);
        controller.setKonstitution(verfuegbareWerte[4]);
        controller.setWeisheit(verfuegbareWerte[1]);
        controller.setGeschicklichkeit(verfuegbareWerte[3]);
        controller.setRasse(RASSE);

        charakter = controller.getCharakter();

        assertNotNull(charakter);
        assertTrue(charakter instanceof Magier);
        assertEquals(NAME, charakter.getName());
        assertEquals(verfuegbareWerte[0] + RASSE.getIntBonus(), charakter.getIntelligenz());
        assertEquals(verfuegbareWerte[2] + RASSE.getStrBonus(), charakter.getStaerke());
        assertEquals(verfuegbareWerte[4] + RASSE.getKonBonus(), charakter.getKonstitution());
        assertEquals(verfuegbareWerte[1] + RASSE.getWisBonus(), charakter.getWeisheit());
        assertEquals(verfuegbareWerte[3] + RASSE.getGesBonus(), charakter.getGeschicklichkeit());
    }

    @Test
    void missingCharakterKlasse() {
        controller.setName(NAME);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setIntelligenz(verfuegbareWerte[1]);
        controller.setStaerke(verfuegbareWerte[2]);
        controller.setKonstitution(verfuegbareWerte[3]);
        controller.setWeisheit(verfuegbareWerte[0]);
        controller.setGeschicklichkeit(verfuegbareWerte[4]);
        controller.setRasse(RASSE);

        assertThrows(MissingAttributeException.class, controller::getCharakter);
    }

    @Test
    void invalidCharakterEigenschaft() {
        controller.setCharakterKlasse(DIEB);
        controller.setName(NAME);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setStaerke(verfuegbareWerte[3]);
        controller.setKonstitution(verfuegbareWerte[2]);
        controller.setWeisheit(verfuegbareWerte[0]);
        controller.setGeschicklichkeit(verfuegbareWerte[4]);
        controller.setRasse(RASSE);

        assertThrows(IllegalArgumentException.class, controller::getCharakter);
        assertThrows(IllegalArgumentException.class, () -> {
            controller.setIntelligenz(verfuegbareWerte[4]);
            controller.setStaerke(verfuegbareWerte[4]);
            controller.setKonstitution(verfuegbareWerte[4]);
            controller.getCharakter();
        });
    }

    @Test
    void missingName() {
        controller.setCharakterKlasse(DIEB);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setIntelligenz(verfuegbareWerte[1]);
        controller.setStaerke(verfuegbareWerte[3]);
        controller.setKonstitution(verfuegbareWerte[2]);
        controller.setWeisheit(verfuegbareWerte[0]);
        controller.setGeschicklichkeit(verfuegbareWerte[4]);
        controller.setRasse(RASSE);

        assertThrows(MissingAttributeException.class, controller::getCharakter);
    }

    @Test
    void missingRasse() {
        controller.setCharakterKlasse(DIEB);
        verfuegbareWerte = controller.getVerfuegbareWerte();
        controller.setIntelligenz(verfuegbareWerte[1]);
        controller.setStaerke(verfuegbareWerte[3]);
        controller.setKonstitution(verfuegbareWerte[2]);
        controller.setWeisheit(verfuegbareWerte[0]);
        controller.setGeschicklichkeit(verfuegbareWerte[4]);
        controller.setName(NAME);

        assertThrows(MissingAttributeException.class, controller::getCharakter);
    }

}
