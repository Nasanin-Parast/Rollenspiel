package oberflaeche.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Knoten implements Comparable<Knoten> {
    ArrayList<Knoten> edges = new ArrayList<Knoten>();
    int row = -1;
    int estimatedDistance = 0;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    int column = -1;
    boolean isRock = false;
    public Knoten(int r, int c) {
        row = r;
        column = c;
    }

    public Knoten(int r, int c, boolean rock) {
        row = r;
        column = c;
        isRock = rock;
    }

    public void addEdge(Knoten edge) {
        edges.add(edge);
    }


    public void removeEdge(Knoten edge) {
        edges.remove(edge);
    }

    public void clearEdges() {
        edges.clear();
    }

    public Iterator<Knoten> keySet() {
        return edges.iterator();
    }

    @Override
    public int compareTo(Knoten o) {
        if (estimatedDistance > o.estimatedDistance) {
            return 1;
        } else if (estimatedDistance == o.estimatedDistance) {
            return 0;
        } else {
            return -1;
        }
    }

}
