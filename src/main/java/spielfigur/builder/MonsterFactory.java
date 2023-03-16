package spielfigur.builder;

import spielfigur.model.Drache;
import spielfigur.model.Monster;
import spielfigur.model.Ork;
import spielfigur.model.Troll;

public class MonsterFactory {
    public static Monster createMonster(String arten){
        return switch (arten){
            case "Ork" -> new Ork();
            case "Troll" -> new Troll();
            case "Drache" -> new Drache();
            default -> throw new IllegalArgumentException("Monster kann nicht erzeugt werden");
        };
    }
}
