package spielfigur.controller;

import spielfigur.builder.CharakterBuilder;
import spielfigur.builder.NullBuilder;
import spielfigur.builder.SpielfigurFactory;
import spielfigur.model.Charakter;
import spielfigur.builder.Rasse;
import spielfigur.repository.CharakterRepository;
import spielfigur.util.RandomUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class CharakterController {

    private CharakterRepository charakterRepository;

    private int[] verfuegbareWerte;
    private CharakterBuilder charBuilder;

    public CharakterController(CharakterRepository charakterRepository) {
        this.charakterRepository = charakterRepository;
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

    public void createCharakter() {
        Charakter charakter = charBuilder.checkWerte(verfuegbareWerte).build();
        charakterRepository.save(charakter);
        verfuegbareWerte = RandomUtils.getCharakterWerte();
    }

    public List<Charakter> getAlleCharakter() {
        return charakterRepository.getAll();
    }

}
