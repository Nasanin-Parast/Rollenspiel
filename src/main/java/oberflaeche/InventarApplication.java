package oberflaeche;

import javafx.application.Application;
import javafx.stage.Stage;
import oberflaeche.InventarView;
import spielfigur.controller.GegenstaendeController;

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
