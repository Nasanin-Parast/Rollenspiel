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
            FileOutputStream file = new FileOutputStream("./Rollenspiel/src/main/resources/character/character.txt");
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

    public void delete(Charakter charakter) {
        try {
            List<Charakter> alle = getAll();
            for (int i = 0; i < alle.size(); i++) {
                if (charakter.getName().trim().equals(alle.get(i).getName().trim()) &&
                        charakter.getIntelligenz() == alle.get(i).getIntelligenz() &&
                        charakter.getStaerke() == alle.get(i).getStaerke() &&
                        charakter.getKonstitution() == alle.get(i).getKonstitution() &&
                        charakter.getWeisheit() == alle.get(i).getWeisheit() &&
                        charakter.getGeschicklichkeit() == alle.get(i).getGeschicklichkeit()) {
                    alle.remove(i);
                    break;
                }
            }
            FileOutputStream file = new FileOutputStream("./Rollenspiel/src/main/resources/character/character.txt");
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
            FileInputStream file = new FileInputStream("./Rollenspiel/src/main/resources/character/character.txt");
            input = new ObjectInputStream(file);
            Charakter charakter = (Charakter) input.readObject();
            while (charakter != null) {
                charaktere.add(charakter);
                charakter = (Charakter) input.readObject();
            }
        } catch (EOFException e) {
            System.out.println("EOF Detected");
            input.close();
        } catch (IOException e) {
            System.out.println("IOE Detected");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound Detected");
            throw new RuntimeException(e);
        } finally {
            return charaktere;
        }
    }

}
