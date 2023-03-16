package spielfigur.repository;

import spielfigur.model.Charakter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CharakterRepository {

    private ObjectOutputStream output;

    public CharakterRepository() {
        try {
            FileOutputStream file = new FileOutputStream("src/main/resources/character/character.txt", true);
            output = new ObjectOutputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(Charakter charakter) {
        try {
            output.writeObject(charakter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Charakter> getAll() {
        List<Charakter> charaktere = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/character/character.txt");
            ObjectInputStream input = new ObjectInputStream(file);
            Charakter charakter = (Charakter) input.readObject();
            System.out.println("erfolgreicher inputstream");
            while (charakter != null) {
                System.out.println("Charakter found: " + charakter.getName());
                charaktere.add(charakter);
                charakter = (Charakter) input.readObject();
            }
            System.out.println("End of file");
        } catch (EOFException e) {
            System.out.println("EOF-Exception");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            return charaktere;
        }
    }

}
