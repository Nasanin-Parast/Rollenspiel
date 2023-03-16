package gegenstand.gegenstandFactory;

import gegenstand.Gegenstand;
import gegenstand.GegenstandFactory;
import gegenstand.artefakt.*;
import gegenstand.ruestung.Kettenpanzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spielfigur.builder.MonsterFactory;
import spielfigur.model.Troll;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GegenstandFactoryTest {

    Gegenstand gegenstand;

    @DisplayName("Should successfuly create Umhang")
    @Test
    void testCreateUmhangSuccess(){assertTrue(GegenstandFactory.newGegenstand("Umhang") instanceof Umhang);}

    @DisplayName("Should successfuly create Amulett")
    @Test
    void testCreateAmulettSuccess(){assertTrue((GegenstandFactory.newGegenstand("Amulett") instanceof Amulett));}

    @DisplayName("Should successfuly create Ring")
    @Test
    void testCreateRingSuccess(){assertTrue(GegenstandFactory.newGegenstand("Ring") instanceof Ring);}

    @DisplayName("Should successfuly create Heiltrank")
    @Test
    void testCreateHeiltrankSuccess(){assertTrue((GegenstandFactory.newGegenstand("Heiltrank") instanceof Heiltrank));}

    @DisplayName("Should successfuly create Gift")
    @Test
    void testCreateGiftSuccess(){assertTrue(GegenstandFactory.newGegenstand("Gift") instanceof Gift);}

    @DisplayName("Should successfuly create Unsichtbarkeitstrank")
    @Test
    void testCreateUnsichtbarkeitstrankSuccess(){assertTrue(GegenstandFactory.newGegenstand("Unsichtbarkeitstrank") instanceof Unsichtbarkeitstrank);}



}
