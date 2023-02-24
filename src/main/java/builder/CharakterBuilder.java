package builder;

import model.Rasse;

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

    public final Charakter build() {
        addRassenBoni();
        return createCharakter();
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
