package oberflaeche;

import gegenstand.controller.GegenstaendeController;
import javafx.application.Application;
import javafx.stage.Stage;

public class InventarApplication extends Application {
    @Override
    public void start(Stage stage) {
        GegenstaendeController controller= new GegenstaendeController();
        InventarView view = new InventarView(controller);
        stage.setTitle("Inventar erstellen");
        stage.setScene(view.getScene());

        stage.show();
    }
}
