package gegenstand.artefakt;

import gegenstand.Gegenstand;

public abstract class Artefakt extends Gegenstand {

    private String fromDerAnwendung;

    public Artefakt(String fromDerAnwendung){

    }

    public abstract int Auswirkung();

    public String getFromDerAnwendung() {return fromDerAnwendung;}

    public void setFromDerAnwendung(String formDerAnwendung){this.fromDerAnwendung = formDerAnwendung;}
}
