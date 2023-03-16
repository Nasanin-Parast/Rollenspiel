package gegenstand.gegenstandFactory;

import gegenstand.Gegenstand;
import gegenstand.GegenstandFactory;
import gegenstand.ruestung.Kettenpanzer;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class GegenstandFactoryTest {

    Gegenstand gegenstand;

    @Test
    void testRuestung(){
        gegenstand = GegenstandFactory.newGegenstand("Kettenpanzer");
//        assertEquals("wear", gegenstand.);
    }
}
