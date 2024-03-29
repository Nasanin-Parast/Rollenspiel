package oberflaeche.model;


public class Fenster {
    private final int rows = 20;
    private final int columns = 20;
    private int sourceStartRow = -1;
    private int sourceStartColumn = -1;
    private int sinkEndRow = -1;
    private int sinkEndColumn = -1;

    Knoten[][] graph = new Knoten[rows][columns];

    public Fenster() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                graph[r][c] = new Knoten(r, c);
            }
        }
    }

    public boolean checkEdge(int r, int c) {
        if (r >= rows || c >= columns || r < 0 || c < 0)
            return false;

        if (graph[r][c].isRock)
            return false;

        return true;
    }

    public void safeAddEdge(int r, int c, int x, int y) {
        if (checkEdge(x, y)) {
            graph[r][c].addEdge(graph[x][y]);
        }
    }

    public void clear() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                graph[r][c] = new Knoten(r, c);
            }
        }
    }

    public void setSourceCordinates(int r, int c) {
        if (sourceStartRow != -1 && sourceStartColumn != -1) {
            graph[sourceStartRow][sourceStartColumn] = new Knoten(sourceStartRow, sourceStartColumn);
        }
        if (r != -1 && c != -1)
            graph[r][c] = new Knoten(r, c);

        sourceStartRow = r;
        sourceStartColumn = c;
    }


    public void setSinkCordinates(int r, int c) {
        if (sinkEndRow != -1 && sinkEndColumn != -1) {
            graph[sinkEndRow][sinkEndColumn] = new Knoten(sinkEndRow, sinkEndColumn);
        }
        if (r != -1 && c != -1)
            graph[r][c] = new Knoten(r, c);

        sinkEndRow = r;
        sinkEndColumn = c;
    }

    public int getRowSize() {
        return rows;
    }

    public int getColumnSize() {
        return columns;
    }
}
