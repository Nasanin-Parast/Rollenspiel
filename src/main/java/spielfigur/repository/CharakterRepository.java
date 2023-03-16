package spielfigur.repository;

import spielfigur.model.Charakter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CharakterRepository {

    public void save(Charakter charakter) {
        try {
            FileOutputStream file = new FileOutputStream("src/main/resources/character/character.txt", true);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(charakter);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
