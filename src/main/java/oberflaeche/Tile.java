package oberflaeche;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    Rectangle border = new Rectangle(45, 45);
    Color color;

    public Tile(Color color, int r, int c) {
        this.color = color;
        border.setFill(color);
        border.setStroke(Color.GREY);
        this.getChildren().add(border);

    }

    public void setColor(Color color) {
        this.color = color;
        border.setFill(this.color);
    }

    public Color getColor() {
        return color;
    }

}
