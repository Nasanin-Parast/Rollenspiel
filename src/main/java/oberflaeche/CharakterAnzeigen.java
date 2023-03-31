package oberflaeche;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import spielfigur.controller.CharakterController;
import spielfigur.model.Charakter;

import java.util.List;

public class CharakterAnzeigen {

    private Charakter character;

    private Scene scene;
    private GridPane grid;

    private Image bannerImage;
    private Image diebImage;
    private Image kaempferImage;
    private Image magierImage;
    private ImageView klasseView;

    private Label nameWert;
    private Label intWert;
    private Label strWert;
    private Label konWert;
    private Label wisWert;
    private Label gesWert;

    private HelloApplication app;
    private CharakterController controller;

    public CharakterAnzeigen(HelloApplication app, CharakterController controller, Charakter character) {
        this.character = character;
        this.app = app;
        this.controller = controller;

        loadView();
    }

    private void setKlasseImage(String klasse) {
        switch(klasse) {
            case "Dieb" -> klasseView.setImage(diebImage);
            case "Kaempfer" -> klasseView.setImage(kaempferImage);
            case "Magier" -> klasseView.setImage(magierImage);
            default -> klasseView.setImage(bannerImage);
        }
    }

    private void setWerte(Charakter charakter) {
        nameWert.setText(charakter.getName());
        intWert.setText(Integer.toString(charakter.getIntelligenz()));
        strWert.setText(Integer.toString(charakter.getStaerke()));
        konWert.setText(Integer.toString(charakter.getKonstitution()));
        wisWert.setText(Integer.toString(charakter.getWeisheit()));
        gesWert.setText(Integer.toString(charakter.getGeschicklichkeit()));
    }

    public Scene getScene() {
        return scene;
    }

    private void loadView() {
        grid = new GridPane();

        bannerImage = new Image("file:src/main/resources/image/banner.png");
        diebImage = new Image("file:src/main/resources/image/bannerDieb.png");
        kaempferImage = new Image("file:src/main/resources/image/bannerKaempfer.png");
        magierImage = new Image("file:src/main/resources/image/bannerMagier.png");
        klasseView = new ImageView();
        klasseView.setImage(bannerImage);

        Button backButton = new Button("Zurück");
        backButton.setPadding(new Insets(10, 10, 10, 20));
        grid.add(backButton, 0, 0);

        Stage stage = (Stage)(scene.getWindow());

        backButton.setOnMouseClicked(e -> {stage.close();});
        List<Charakter> alle = controller.getAlleCharakter();
        for (int i = 1; i <= alle.size(); i++) {
            CharakterLabel cLabel = new CharakterLabel(character);
            grid.add(cLabel, 0, i, 2, 1);
            cLabel.setOnMouseClicked(e -> {
                setKlasseImage(cLabel.getCharakter().getClass().getSimpleName());
                setWerte(cLabel.getCharakter());
            });
        }

        grid.add(klasseView, 2, 0, 1, 7);

        Label nameAnzeige = new Label("Name");
        nameAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(nameAnzeige, 3, 0);
        nameWert = new Label("-");
        grid.add(nameWert, 4, 0);

        Label intAnzeige = new Label("Intelligenz");
        intAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(intAnzeige, 3, 1);
        intWert = new Label("-");
        grid.add(intWert, 4, 1);

        Label strAnzeige = new Label("Stärke");
        strAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(strAnzeige, 3, 2);
        strWert = new Label("-");
        grid.add(strWert, 4, 2);

        Label konAnzeige = new Label("Konstitution");
        konAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(konAnzeige, 3, 3);
        konWert = new Label("-");
        grid.add(konWert, 4, 3);

        Label wisAnzeige = new Label("Weisheit");
        wisAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(wisAnzeige, 3, 4);
        wisWert = new Label("-");
        grid.add(wisWert, 4, 4);

        Label gesAnzeige = new Label("Geschicklichkeit");
        gesAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(gesAnzeige, 3, 5);
        gesWert = new Label("-");
        grid.add(gesWert, 4, 5);

        scene = new Scene(grid, 600, 400);
    }

    private class CharakterLabel extends Label {

        private Charakter charakter;

        public CharakterLabel(Charakter charakter) {
            super(charakter.getName());
            this.charakter = charakter;
            setPadding(new Insets(3, 30, 3, 10));
        }

        public Charakter getCharakter() {
            return charakter;
        }
    }

}
