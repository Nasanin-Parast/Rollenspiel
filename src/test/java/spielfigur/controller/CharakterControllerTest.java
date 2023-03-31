package spielfigur.controller;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import spielfigur.builder.CharakterBuilder;
import spielfigur.builder.Rasse;
import spielfigur.builder.SpielfigurFactory;
import spielfigur.model.Charakter;
import spielfigur.util.RandomUtils;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("UnitTest")
class CharakterControllerTest {

    private final static String KLASSE = "DIEB";
    private final static String NAME = "James Bond";
    private final static int EIGENSCHAFT = 11;
    private final static Rasse RASSE = Rasse.HOBBIT;
    private final static int ANZAHL_EIGENSCHAFTEN = 5;

    private static MockedStatic<SpielfigurFactory> factory;
    private static MockedStatic<RandomUtils> utils;
    private static CharakterBuilder builder;
    private @Mock Charakter charakter;
    private @InjectMocks CharakterController controller;

    @BeforeAll
    static void setUpClass() {
        builder = mock(CharakterBuilder.class);
        factory = mockStatic(SpielfigurFactory.class);
        utils = mockStatic(RandomUtils.class);
    }

    @BeforeEach
    void setUp() {
        factory.when(() -> SpielfigurFactory.createCharakter(KLASSE)).thenReturn(builder);
        utils.when(RandomUtils::getCharakterWerte).thenReturn(new int[ANZAHL_EIGENSCHAFTEN])
                .thenReturn(new int[ANZAHL_EIGENSCHAFTEN]);
        controller = new CharakterController();
        controller.setCharakterKlasse(KLASSE);
    }

    @AfterEach
    void tearDown() {
        factory.reset();
    }

    @AfterAll
    static void tearDownClass() {
        factory.close();
        utils.close();
    }

    @Test
    void charakterKlasseShouldBeSet() {
        factory.verify(() -> SpielfigurFactory.createCharakter(KLASSE), times(1));
    }

    @Test
    void shouldSetName() {
        controller.setName(NAME);

        verify(builder, times(1)).withName(NAME);
    }

    @Test
    void shouldSetIntelligenz() {
        controller.setIntelligenz(EIGENSCHAFT);

        verify(builder, times(1)).withIntelligenz(EIGENSCHAFT);
    }

    @Test
    void shouldSetStaerke() {
        controller.setStaerke(EIGENSCHAFT);

        verify(builder, times(1)).withStaerke(EIGENSCHAFT);
    }

    @Test
    void shouldSetKonstitution() {
        controller.setKonstitution(EIGENSCHAFT);

        verify(builder, times(1)).withKonstitution(EIGENSCHAFT);
    }

    @Test
    void shouldSetWeisheit() {
        controller.setWeisheit(EIGENSCHAFT);

        verify(builder, times(1)).withWeisheit(EIGENSCHAFT);
    }

    @Test
    void shouldSetGeschicklichkeit() {
        controller.setGeschicklichkeit(EIGENSCHAFT);

        verify(builder, times(1)).withGeschicklichkeit(EIGENSCHAFT);
    }

    @Test
    void shouldSetRasse() {
        controller.setRasse(RASSE);

        verify(builder, times(1)).withRasse(RASSE);
    }

    @Test
    void shouldGetVerfuegbareWerte() {
        int[] verfuegbareWerte = controller.getVerfuegbareWerte();

        assertNotNull(verfuegbareWerte);
        assertEquals(ANZAHL_EIGENSCHAFTEN, verfuegbareWerte.length);
    }

    @Test
    void shouldGetCharakter() {
        when(builder.checkWerte(any())).thenReturn(builder);
        when(builder.build()).thenReturn(this.charakter);
        int[] verfuegbareWerte = controller.getVerfuegbareWerte();

        Charakter charakter = controller.getCharakter();

        assertEquals(this.charakter, charakter);
        assertNotEquals(verfuegbareWerte, controller.getVerfuegbareWerte());
    }

}
