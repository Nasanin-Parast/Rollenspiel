package oberflaeche.controller;

import oberflaeche.model.Fenster;


public class ControllerImpl {
    private Fenster fenster = new Fenster();

    public boolean isReadyToSearch() {
        return fenster.isReadyToSearch();
    }

    public void wandPlatzieren(int r, int c) {
        fenster.wandPlatzieren(r, c);
    }

    public void wandLoeschen(int r, int c) {
        fenster.wandLoeschen(r, c);
    }

    public void generateEdges() {
        fenster.generateEdges();
    }

    public void clearEdges() {
        fenster.clearEdges();
    }

    public void clear() {
        fenster.clear();
    }

    public void setSourceCordinates(int r, int c) {
        fenster.setSourceCordinates(r, c);
    }

    public void setSinkCordinates(int r, int c) {
        fenster.setSinkCordinates(r, c);
    }


    public int getRowSize() {
        return fenster.getRowSize();

    }

    public int getColumnSize() {
        return fenster.getColumnSize();
    }

    public int getSourceXCordinate() {
        return fenster.getSourceXCordinate();
    }

    public int getSourceYCordinate() {
        return fenster.getSourceYCordinate();
    }

    public int getSinkXCordinate() {
        return fenster.getSinkXCordinate();
    }

    public int getSinkYCordinate() {
        return fenster.getSinkYCordinate();
    }
}
