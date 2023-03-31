package spielfigur.controller;

import spielfigur.builder.CharakterBuilder;
import spielfigur.builder.NullBuilder;
import spielfigur.builder.SpielfigurFactory;
import spielfigur.model.Charakter;
import spielfigur.builder.Rasse;
import spielfigur.util.RandomUtils;
/**
 * @author Raphael Gardemann
 */
public class CharakterController {

    private int[] verfuegbareWerte;
    private CharakterBuilder charBuilder;

    public CharakterController() {
        verfuegbareWerte = RandomUtils.getCharakterWerte();
        charBuilder = new NullBuilder();
    }

    public void setCharakterKlasse(String klasse) {
        charBuilder = SpielfigurFactory.createCharakter(klasse);
    }

    public void setName(String name) {
        charBuilder.withName(name);
    }

    public void setIntelligenz(int intelligenz) {
        charBuilder.withIntelligenz(intelligenz);
    }

    public void setStaerke(int staerke) {
        charBuilder.withStaerke(staerke);
    }

    public void setKonstitution(int konstitution) {
        charBuilder.withKonstitution(konstitution);
    }

    public void setWeisheit(int weisheit) {
        charBuilder.withWeisheit(weisheit);
    }

    public void setGeschicklichkeit(int geschicklichkeit) {
        charBuilder.withGeschicklichkeit(geschicklichkeit);
    }

    public void setRasse(Rasse rasse) {
        charBuilder.withRasse(rasse);
    }

    public int[] getVerfuegbareWerte() {
        return verfuegbareWerte;
    }

    public Charakter getCharakter() {
        Charakter charakter = charBuilder.checkWerte(verfuegbareWerte).build();
        verfuegbareWerte = RandomUtils.getCharakterWerte();
        return charakter;
    }

}
