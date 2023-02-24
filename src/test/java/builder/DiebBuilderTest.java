package builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spielfigur.Charakter;
import spielfigur.Dieb;
import spielfigur.Rasse;

public class DiebBuilderTest {
    Dieb dieb;
    CharakterBuilder charakterBuilder;
    Charakter charakterActual;
    Charakter charakterExpected;
    @Test
    void changePlayerWithBuilder(){
       charakterActual= new DiebBuilder().withName("Dieb").withStaerke(2).withGeschicklichkeit(3).withWeisheit(3).withIntelligenz(7).withKonstitution(8).withRasse(Rasse.Elf).build();
       charakterExpected=new DiebBuilder().withName("Dieb").withStaerke(2).withGeschicklichkeit(3).withWeisheit(3).withIntelligenz(7).withKonstitution(8).withRasse(Rasse.Elf).build();
        Assertions.assertEquals(charakterActual.getName(), "Dieb");
    }
}
