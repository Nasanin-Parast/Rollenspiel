package gegenstand.artefakt;

import gegenstand.Gegenstand;

public abstract class Artefakt extends Gegenstand {

    String formDerAnwendung;

    protected Artefakt(String formDerAnwendung){

    }
    @Override
    public void interagiereMitGegenstand() {    }

    public int Auswirkung() {
        return 0;
    }

    public String getFormDerAnwendung() {return formDerAnwendung;}

    public void setFormDerAnwendung(String formDerAnwendung){this.formDerAnwendung = formDerAnwendung;}
}
