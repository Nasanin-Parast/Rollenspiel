package builder;

import spielfigur.Charakter;

public abstract class CharakterBuilder {
    protected int intelligenz;
    protected int staerke;
    protected String name;
    protected int weisheit;
    protected int geschicklichkeit;
    protected int konstitution;

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

    public CharakterBuilder withWeisheit(int weisheit) {
        this.weisheit = weisheit;
        return this;
    }

    public CharakterBuilder withGeschicklichkeit(int geschicklichkeit) {
        this.geschicklichkeit = geschicklichkeit;
        return this;
    }
    public CharakterBuilder withKonstitution(int kostitution){
        this.konstitution=konstitution;
        return this;
    }

    public abstract Charakter build();

}
