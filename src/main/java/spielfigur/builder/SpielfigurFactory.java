package spielfigur.builder;

public class SpielfigurFactory {

    public static CharakterBuilder createCharakter(String typ){
        return switch(typ) {
            case "Dieb" -> new DiebBuilder();
            case "Kaempfer" -> new KaempferBuilder();
            case "Magier" -> new MagierBuilder();
            default -> throw new IllegalArgumentException();
        };
    }

}
