package spielfigur.controller;

import spielfigur.builder.CharakterBuilder;
import spielfigur.builder.NullBuilder;
import spielfigur.builder.SpielfigurFactory;
import spielfigur.model.Charakter;
import spielfigur.builder.Rasse;
import spielfigur.util.RandomUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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

    public void createCharakter() {
        Charakter charakter = charBuilder.checkWerte(verfuegbareWerte).build();

        try {
            FileOutputStream file = new FileOutputStream("src/save/file.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(charakter);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        verfuegbareWerte = RandomUtils.getCharakterWerte();
    }

}
