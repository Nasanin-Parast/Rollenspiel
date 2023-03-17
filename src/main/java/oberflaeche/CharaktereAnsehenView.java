package oberflaeche;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import spielfigur.controller.CharakterController;
import spielfigur.model.Charakter;

import java.util.List;

public class CharaktereAnsehenView {

    private Scene scene;

    private HelloApplication app;
    private CharakterController controller;

    public CharaktereAnsehenView(HelloApplication app, CharakterController controller) {
        this.app = app;
        this.controller = controller;

        GridPane grid = new GridPane();

        Button backButton = new Button("Zurück");
        grid.add(backButton, 0, 0);

        backButton.setOnMouseClicked(e -> app.changeToStartView());

        List<Charakter> alle = controller.getAlleCharakter();
        for (int i = 1; i <= alle.size(); i++) {
            grid.add(new Label(alle.get(i - 1).getName()), 0, i);
        }
        scene = new Scene(grid, 300, 300);
    }

    public Scene getScene() {
        return scene;
    }

}
