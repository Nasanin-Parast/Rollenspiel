package spielfigur.repository;

import spielfigur.model.Charakter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CharakterRepository {


    public CharakterRepository() {
    }
    public void save(Charakter charakter) {
        try {
            List<Charakter> alle = getAll();
            alle.add(charakter);
            FileOutputStream file = new FileOutputStream("src/main/resources/character/character.txt");
            ObjectOutputStream output;
            output = new ObjectOutputStream(file);
            for (Charakter c : alle) {
                output.writeObject(c);
            }
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Charakter> getAll() {
        List<Charakter> charaktere = new ArrayList<>();
        ObjectInputStream input = null;
        try {
            FileInputStream file = new FileInputStream("src/main/resources/character/character.txt");
            input = new ObjectInputStream(file);
            Charakter charakter = (Charakter) input.readObject();
            System.out.println("erfolgreicher inputstream");
            while (charakter != null) {
                System.out.println("Charakter found: " + charakter.getName());
                charaktere.add(charakter);
                charakter = (Charakter) input.readObject();
            }
            System.out.println("End of file");
        } catch (EOFException e) {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            return charaktere;
        }
    }

}
