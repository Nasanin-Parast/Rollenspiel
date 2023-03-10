package gegenstand.artefakt;

import gegenstand.Gegenstand;

public abstract class Artefakt extends Gegenstand {

    String formDerAnwendung;

    protected Artefakt(String formDerAnwendung){

    }
    @Override
    public String interagiereMitGegenstand() {
        return "Artefakt: " + this.getClass().getSimpleName();
    }

    public abstract int Auswirkung();

    public String getFormDerAnwendung() {return formDerAnwendung;}

    public void setFormDerAnwendung(String formDerAnwendung){this.formDerAnwendung = formDerAnwendung;}
}
