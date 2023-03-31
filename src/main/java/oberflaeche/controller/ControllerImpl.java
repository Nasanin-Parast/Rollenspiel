package oberflaeche.controller;

import oberflaeche.model.Fenster;


public class ControllerImpl {
    private Fenster fenster = new Fenster();

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
}
