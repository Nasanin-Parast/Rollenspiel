package spielfigur.builder;
import spielfigur.model.Charakter;
import spielfigur.model.Magier;

public class MagierBuilder extends CharakterBuilder {
    @Override
    public Charakter createCharakter() {
        return new Magier(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
