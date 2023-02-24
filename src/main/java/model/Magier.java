package model;

import builder.Charakter;

public class Magier extends Charakter {
    public Magier(String name, int intelligenz, int staerke, int konstitution, int weisheit, int geschicklichkeit) {
        super(name, intelligenz, staerke, konstitution, weisheit, geschicklichkeit, 6);
    }
}
