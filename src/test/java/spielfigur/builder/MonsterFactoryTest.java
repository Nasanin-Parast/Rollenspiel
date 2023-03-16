package spielfigur.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spielfigur.model.Drache;
import spielfigur.model.Ork;
import spielfigur.model.Troll;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterFactoryTest {
    private static final String TROLL = "Troll";
    private static final String DRACHE = "Drache";
    private static final String ORK = "Ork";
    private static final String WRONGDATA = "irgendwas";


    @DisplayName("Should successfuly create troll")
    @Test
    void testCreateTrollSuccess() {
        assertTrue(MonsterFactory.createMonster(TROLL) instanceof Troll);
    }

    @DisplayName("Should successfuly create ork")
    @Test
    void testCreateOrkSuccess() {
        assertTrue(MonsterFactory.createMonster(ORK) instanceof Ork);
    }

    @DisplayName("Should successfuly create dragon")
    @Test
    void testCreateDracheSuccess() {
        assertTrue(MonsterFactory.createMonster(DRACHE) instanceof Drache);
    }

    @DisplayName("Should be throw error in case of unequal specifications")
    @Test
    void testInvalidString() {
        assertThrows(IllegalArgumentException.class, ()-> MonsterFactory.createMonster(WRONGDATA));
    }

}
