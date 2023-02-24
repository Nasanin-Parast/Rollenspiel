package controller;

import builder.CharakterBuilder;
import builder.NullBuilder;
import builder.SpielfigurFactory;
import builder.Charakter;
import model.Rasse;
import util.RandomUtils;

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

    public void speichern() {
        Charakter charakter = charBuilder.build();
        verfuegbareWerte = RandomUtils.getCharakterWerte();
    }

}
