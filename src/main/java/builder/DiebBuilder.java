package builder;

import spielfigur.Charakter;
import spielfigur.Dieb;

public class DiebBuilder extends CharakterBuilder {

    @Override
    public Charakter build() {
        return new Dieb(name,intelligenz,staerke,konstitution,weisheit,geschicklichkeit);
    }
}
