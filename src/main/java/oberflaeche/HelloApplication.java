package oberflaeche;

import javafx.application.Application;
import javafx.stage.Stage;
import spielfigur.controller.CharakterController;
import spielfigur.model.Charakter;
import spielfigur.repository.CharakterRepository;
import oberflaeche.Tile;

public class HelloApplication extends Application {

    private Stage stage;
    private CharakterRepository charakterRepository;
    private CharakterController charakterController;

    private StartView startView;

    public static void main(String[] args){
        HelloApplication.launch(args);
    }

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

    public void startGame(){
        GamemasterView view = new GamemasterView(this);
        stage.setScene(view.getScene());
    }

    public void startPlayerUI(Tile[][] tiles, Charakter character){
        PlayerView view = new PlayerView(tiles, character);
        stage.setScene(view.getScene());
    }

}
