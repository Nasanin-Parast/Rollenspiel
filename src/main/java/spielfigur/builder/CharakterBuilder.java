package spielfigur.builder;

import spielfigur.exception.MissingAttributeException;
import spielfigur.model.Charakter;

public abstract class CharakterBuilder {
    protected String name;
    protected int intelligenz;
    protected int staerke;
    protected int konstitution;
    protected int weisheit;
    protected int geschicklichkeit;
    protected Rasse rasse;

    public CharakterBuilder() {
    }

    public CharakterBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CharakterBuilder withIntelligenz(int intelligenz) {
        this.intelligenz = intelligenz;
        return this;
    }

    public CharakterBuilder withStaerke(int staerke) {
        this.staerke = staerke;
        return this;
    }
    public CharakterBuilder withKonstitution(int konstitution){
        this.konstitution=konstitution;
        return this;
    }

    public CharakterBuilder withWeisheit(int weisheit) {
        this.weisheit = weisheit;
        return this;
    }

    public CharakterBuilder withGeschicklichkeit(int geschicklichkeit) {
        this.geschicklichkeit = geschicklichkeit;
        return this;
    }

    public CharakterBuilder withRasse(Rasse rasse) {
        this.rasse = rasse;
        return this;
    }

    public CharakterBuilder checkWerte(int[] werte) {
        int[] abgleich = new int[5];
        abgleich[0] = intelligenz;
        abgleich[1] = staerke;
        abgleich[2] = konstitution;
        abgleich[3] = weisheit;
        abgleich[4] = geschicklichkeit;
        outerloop:
        for (int gesuchteZahl : werte) {
            for (int i = 0; i < 5; i++) {
                if (abgleich[i] == gesuchteZahl) {
                    abgleich[i] = 0;
                    continue outerloop;
                }
            }
            throw new IllegalArgumentException("Ungültige Charakterwerte!");
        }
        return this;
    }

    public final Charakter build() {
        checkAttribute();
        addRassenBoni();
        return createCharakter();
    }

    private void checkAttribute() {
        if (name == null) {
            throw new MissingAttributeException("Kein Name eingetragen");
        }
        if (rasse == null) {
            throw new MissingAttributeException("Keine Rasse eingetragen");
        }
    }

    private void addRassenBoni() {
        this.intelligenz += this.rasse.getIntBonus();
        this.staerke += this.rasse.getStrBonus();
        this.konstitution += this.rasse.getKonBonus();
        this.weisheit += this.rasse.getWisBonus();
        this.geschicklichkeit += this.rasse.getGesBonus();
    }

    protected abstract Charakter createCharakter();

}
