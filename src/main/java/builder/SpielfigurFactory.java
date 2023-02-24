package builder;

public class SpielfigurFactory {

    public static CharakterBuilder createCharakter(String typ){
        switch(typ) {
            case "Dieb":
                return new DiebBuilder();
            case "Kaempfer":
                return new KaempferBuilder();
            case "Magier":
                return new MagierBuilder();
            default:
                throw new IllegalArgumentException();
        }
    }

}
