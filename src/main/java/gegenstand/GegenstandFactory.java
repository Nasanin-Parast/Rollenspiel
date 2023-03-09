package gegenstand;

import gegenstand.artefakt.*;
import gegenstand.ruestung.*;
import gegenstand.waffe.*;

public class GegenstandFactory {

    public static Gegenstand newGegenstand(String gegenstand){
        if(){
            switch(gegenstand) {
                case "Umhang":
                    return new Umhang("wear");
                break;
                case "Amulett":
                    return new Amulett("use");
                break;
                case "Ring":
                    return new Ring("waer");
                break;
                case "Heiltrank":
                    return new Heiltrank("drink");
                break;
                case "Gift":
                    return new Gift("drink");
                break;
                case "Unsichtbarkeitstrank":
                    return new Unsichtbarkeitstrank("drink");
                break;
                case "keineRuestung":
                    return new KeineRuestung(0, ' ', 0, 0);
                break;
                case "Lederruestung":
                    return new Lederruestung(1, 'D', 10, 10);
                break;
                case "Schuppenpanzer":
                    return new Schuppenpanzer(4, 'D', 50, 45);
                break;
                case "Kettenpanzer":
                    return new Kettenpanzer(6, ' ', 75, 55);
                break;
                case "Schild":
                    return new Schild(2, ' ', 0, 6);
                break;
                case "keineWaffe":
                    return new KeineWaffe('S', 0, 0, 0);
                case "Dolch":
                    return new Dolch('D', 2, 1, 2);
                break;
                case "Wurfpfeile":
                    return new Wurfpfeil('D', (1 / 20), (1 / 4), 2, 20);
                break;
                case "Knüppel":
                    return new Knueppel('S', 1, 3, 1);
                break;
                case "Handaxt":
                    return new Handaxt(' ', 5, 2, 2);
                break;
                case "Streitaxt":
                    return new Streitaxt('S', 10, 4, 0);
                break;
                case "Speer":
                    return new Speer(' ', 2, 3, 2);
                break;
                case "Schwert":
                    return new Schwert('S', 15, 3, 0);
                break;
                case "Degen":
                    return new Degen('D', 25, 2, 0);
                break;
                case "Bogen mit Pfeilen":
                    return new BogenMitPfeilen('D', 15, 2, 6, 20);
                break;
                default:
                    new IllegalAccessException("Falscher Gegenstand");

            }
        }
        return null;
    }
}
