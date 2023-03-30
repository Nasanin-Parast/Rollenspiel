package spielfigur.model;

public abstract class Monster extends Spielfigur {
    public Monster(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, basisLP);
    }
//    private Feld feld;
//    public Feld zufaelligePositionierung(){
//
//        return null;
//    }

    public void angriff() {
    }

    public void verfolgungEndeckterSpieler() {
    }


}
