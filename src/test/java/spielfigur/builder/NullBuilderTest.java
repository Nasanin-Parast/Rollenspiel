package spielfigur.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spielfigur.exception.MissingAttributeException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("UnitTest")
public class NullBuilderTest {

    private static final String NAME = "Charakter";
    private static final Rasse RASSE = Rasse.Zwerg;
    private CharakterBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new NullBuilder().withName(NAME).withRasse(RASSE);
    }

    @Test
    void shouldThrowException() {
        assertThrows(MissingAttributeException.class, builder::build);
    }

}
