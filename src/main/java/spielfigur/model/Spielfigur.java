package spielfigur.model;

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

    protected Spielfigur(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit, int basisLP) {
        this.name=name;
        checkCharakterEigenschaft(intelligenz);
        this.intelligenz = intelligenz;
        checkCharakterEigenschaft(staerke);
        this.staerke = staerke;
        checkCharakterEigenschaft(konstitution);
        this.konstitution = konstitution;
        checkCharakterEigenschaft(weisheit);
        this.weisheit = weisheit;
        checkCharakterEigenschaft(geschicklichkeit);
        this.geschicklichkeit = geschicklichkeit;
        BASIS_LP = basisLP;
        berechneMaxLP();
        lebenspuenkteAktuell = lebenspuenkteMax;
    }

    private void checkCharakterEigenschaft(int eigenschaft) {
        if (eigenschaft < 3) {
            throw new IllegalArgumentException("Charaktereigenschaft zu gering");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getLebenspuenkteMax() {
        return lebenspuenkteMax;
    }

    public int getLebenspuenkteAktuell() {
        return lebenspuenkteAktuell;
    }

    public int getIntelligenz() {
        return intelligenz;
    }

    public int getStaerke() {
        return staerke;
    }

    public int getKonstitution() {
        return konstitution;
    }

    public int getWeisheit() {
        return weisheit;
    }

    public int getGeschicklichkeit() {
        return geschicklichkeit;
    }

    protected void berechneMaxLP() {
        lebenspuenkteMax = BASIS_LP + modifier(konstitution);
    }
    protected int modifier(int eigenschaft) {
        return (eigenschaft - MODIFICATIONVALUE) / 2;
    }


}
