package oberflaeche.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Knoten implements Comparable<Knoten> {
    ArrayList<Knoten> edges = new ArrayList<>();
    int row = -1;
    int estimatedDistance = 0;

    int column = -1;
    boolean isRock = false;
    public Knoten(int r, int c) {
        row = r;
        column = c;
    }

    public void addEdge(Knoten edge) {
        edges.add(edge);
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
