package oberflaeche;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import spielfigur.controller.CharakterController;
import spielfigur.repository.CharakterRepository;

import java.util.Arrays;
import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        CharakterRepository charakterRepository = new CharakterRepository();
        CharakterController controller = new CharakterController(charakterRepository);
        CharakterErstellenView view = new CharakterErstellenView(controller);
        stage.setTitle("Charakter erstellen");
        stage.setScene(view.getScene());



        stage.show();
    }

}
