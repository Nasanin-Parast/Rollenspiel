package builder;
import spielfigur.Charakter;
import spielfigur.Magier;

public class MagierBuilder extends CharakterBuilder {
    @Override
    public Charakter createCharakter() {
        return new Magier(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit);
    }
}
