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

    private Stage stage;
    private CharakterRepository charakterRepository;
    private CharakterController charakterController;

    private StartView startView;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        charakterRepository = new CharakterRepository();
        charakterController = new CharakterController(charakterRepository);

        startView = new StartView(this);
        changeToStartView();

        stage.show();
    }

    public void changeToCharakterErstellenView() {
        CharakterErstellenView charakterErstellenView = new CharakterErstellenView(this, charakterController);
        stage.setScene(charakterErstellenView.getScene());
        stage.setTitle("Charakter erstellen");
    }

    public void changeToCharaktereAnsehenView() {
        CharaktereAnsehenView view = new CharaktereAnsehenView(this, charakterController);
        stage.setScene(view.getScene());
        stage.setTitle("Alle Charaktere");
    }

    public void changeToStartView() {
        stage.setScene(startView.getScene());
        stage.setTitle("Willkommen Beschwörer");
    }

}
