package oberflaeche;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class KampfrundeView {

    private HelloApplication app;
    private Scene scene;

    public KampfrundeView(HelloApplication app) {
        this.app = app;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setVgap(3);

        Image spieler = new Image("file:src/main/resources/image/geist.png");
        ImageView sView = new ImageView(spieler);
        grid.add(sView, 0, 0);

        Image kampf = new Image("file:src/main/resources/image/kampf.png");
        ImageView kView = new ImageView(kampf);
        grid.add(kView, 1, 0);

        Image ork = new Image("file:src/main/resources/image/ork.png");
        ImageView oView = new ImageView(ork);
        grid.add(oView, 2, 0);

        scene = new Scene(grid, 400, 400);
    }

    public Scene getScene() {
        return scene;
    }

}
