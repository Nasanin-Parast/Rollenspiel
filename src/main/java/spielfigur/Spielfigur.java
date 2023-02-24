package spielfigur;

public abstract class Spielfigur {
    private static final int MODIFICATIONVALUE = 10;
    private final int BASIS_LP;
    private String name;
    private int lebenspuenkteMax;
    private int lebenspuenkteAktuell;
    private int intelligenz;
    private int staerke;
    private int konstitution;
    private int weisheit;
    private int geschicklichkeit;

    public Spielfigur(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        this.name=name;
        this.intelligenz = intelligenz;
        this.staerke = staerke;
        this.konstitution = konstitution;
        this.weisheit = weisheit;
        this.geschicklichkeit = geschicklichkeit;
        BASIS_LP = basisLP;
        berechneMaxLP();
    }
    private void berechneMaxLP() {
        lebenspuenkteMax = BASIS_LP + modifier(konstitution);
    }
    private int modifier(int eigenschaft) {
        return (eigenschaft - MODIFICATIONVALUE) / 2;
    }


}
