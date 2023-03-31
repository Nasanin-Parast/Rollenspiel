package oberflaeche;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StartView {

    private HelloApplication app;
    private Scene scene;

    public StartView(HelloApplication app) {
        this.app = app;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setPadding(new Insets(50, 25, 25, 25));
        grid.setVgap(3);

        Button charakterErstellen = new Button("Charakter erstellen");
        Button charaktereAnsehen = new Button("Charaktere ansehen");
        Button spielVorbereiten = new Button("Spiel vorbereiten");

        grid.add(charakterErstellen, 0, 0);
        grid.add(charaktereAnsehen, 0, 1);
        grid.add(spielVorbereiten, 0, 2);

        charakterErstellen.setOnMouseClicked(event -> app.changeToCharakterErstellenView());
        charaktereAnsehen.setOnMouseClicked(event -> app.changeToCharaktereAnsehenView());
        spielVorbereiten.setOnMouseClicked(event -> app.startGame());

        scene = new Scene(grid, 300, 300);
    }

    public Scene getScene() {
        return scene;
    }

}
