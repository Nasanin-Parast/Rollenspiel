package oberflaeche;

import gegenstand.controller.GegenstaendeController;
import javafx.application.Application;
import javafx.stage.Stage;
import spielfigur.controller.CharakterController;
import spielfigur.model.Charakter;

public class InventarApplication extends Application {
    @Override
    public void start(Stage stage) {
        CharakterController c = new CharakterController();
        InventarView view = new InventarView(c.getCharakter());
        stage.setTitle("Inventar erstellen");
        stage.setScene(view.getScene());

        stage.show();
    }
}
