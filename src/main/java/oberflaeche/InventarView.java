package oberflaeche;

import gegenstand.Gegenstand;
import gegenstand.artefakt.Amulett;
import gegenstand.artefakt.Ring;
import gegenstand.ruestung.*;
import gegenstand.waffe.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import spielfigur.model.Charakter;

import java.util.*;
/**
 * @author Nasanin Parast
 */

public class InventarView {
    private GridPane grid;
    Scene scene;
    Button abbrechenButton;
    Alert alert;
    ButtonType yesButton;
    ButtonType noButton;
    Label klasse;
    Label preis;
    Label gewicht;
    TilePane tilepane;
    Label anwendung;
    Charakter charakter;
    Stage stage;


    public InventarView(Charakter charakter, Stage stage) {
        this.stage = stage;
        this.charakter = charakter;
        erstelleFenster();
        zeigeInventar();
        createEigenschaftenanzeige();
        abbrechen();
        abbrechenButton.setOnMouseClicked(e -> abbrechen());
        BackgroundImage myBI= new BackgroundImage(new Image("file:src/main/resources/image/background.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        grid.setBackground(new Background(myBI));
        scene = new Scene(grid, 800, 700);
    }

    public Scene getScene() {
        return scene;
    }

    private void erstelleFenster() {
        grid = new GridPane();
        tilepane = new TilePane();
        grid.setAlignment(Pos.TOP_LEFT);
        tilepane.setAlignment(Pos.BOTTOM_LEFT);
        tilepane.setPadding(new Insets(10, 10, 10, 10));
        tilepane.setHgap(10);
        tilepane.setVgap(10);
        grid.setPadding(new Insets(20.0f, 40.0f, 60.0f, 70.0f));
        grid.setVgap(3);
    }

    public void abbrechen() {
        abbrechenButton = new Button("Abbrechen");
        abbrechenButton.setTextFill(Color.web("#ffd700"));
        abbrechenButton.setStyle("-fx-background-color: #ff0000; ");
        abbrechenButton.setId("abbrechen");
        grid.add(abbrechenButton, 20, 10);
        abbrechenButton.setMaxSize(500,500);
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Would You Like To Save Your Console Output?");
        alert.setContentText("Please choose an option.");
        yesButton = new ButtonType("Yes");
        noButton = new ButtonType("No");
        for (ButtonType bt : alert.getDialogPane().getButtonTypes()) {
            if (bt.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                Button cancelButton = (Button) alert.getDialogPane().lookupButton(bt);
                cancelButton.fire();
                break;
            }
        }
    }

    private void zeigeInventar() {
        Text inventarText = new Text("Inventar");
        inventarText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        inventarText.setFill(Color.GOLD);
        grid.add(inventarText, 1, 0);
        tilepane = new TilePane();
        tilepane.setPadding(new Insets(15));
        tilepane.setHgap(5);
        tilepane.setVgap(5);
        List<Gegenstand> alle = charakter.getInventar().getGegenstaende();
        for (int i = 0; i < 15; i++) {
            Image image = new Image("file:src/main/resources/image/emptySlot.png");
            if (i < alle.size()) {
                if (alle.get(i) instanceof Amulett) {
                    image = new Image("file:src/main/resources/image/gegenstand/amulett.png");
                } else if (alle.get(i) instanceof Kettenpanzer) {
                    image = new Image("file:src/main/resources/image/gegenstand/kettenpanzer.png");
                } else if (alle.get(i) instanceof Lederruestung) {
                    image = new Image("file:src/main/resources/image/gegenstand/lederruestung.png");
                } else if (alle.get(i) instanceof Schuppenpanzer) {
                    image = new Image("file:src/main/resources/image/gegenstand/schuppenpanzer.png");
                } else if (alle.get(i) instanceof Schild) {
                    image = new Image("file:src/main/resources/image/gegenstand/schild.png");
                } else if (alle.get(i) instanceof Dolch) {
                    image = new Image("file:src/main/resources/image/gegenstand/dolch.png");
                } else if (alle.get(i) instanceof Wurfpfeil) {
                    image = new Image("file:src/main/resources/image/gegenstand/wurfpfeil.png");
                } else if (alle.get(i) instanceof Handaxt) {
                    image = new Image("file:src/main/resources/image/gegenstand/handaxt.png");
                } else if (alle.get(i) instanceof Streitaxt) {
                    image = new Image("file:src/main/resources/image/gegenstand/streitaxt.png");
                } else if (alle.get(i) instanceof Speer) {
                    image = new Image("file:src/main/resources/image/gegenstand/speer.png");
                } else if (alle.get(i) instanceof Schwert) {
                    image = new Image("file:src/main/resources/image/gegenstand/schwert.png");
                } else if (alle.get(i) instanceof Degen) {
                    image = new Image("file:src/main/resources/image/gegenstand/degen.png");
                } else if (alle.get(i) instanceof BogenMitPfeilen) {
                    image = new Image("file:src/main/resources/image/gegenstand/bogen.png");
                } else if (alle.get(i) instanceof Ring) {
                    image = new Image("file:src/main/resources/image/gegenstand/Ring.png");
                }else if (alle.get(i) instanceof KeineWaffe) {
                    image = new Image("file:src/main/resources/image/gegenstand/emptySlot.png");
                }else if (alle.get(i) instanceof KeineRuestung) {
                    image = new Image("file:src/main/resources/image/gegenstand/emptySlot.png");
            }
            }
            ImageView imageView;
            if (i < alle.size()) {
                imageView = new GegenstandEventhaendler(image, alle.get(i));
            } else {
                imageView = new ImageView(image);
            }
            tilepane.getChildren().add(imageView);
        }
        grid.add(tilepane, 0, 20, 20, 1);
    }

    private void createEigenschaftenanzeige() {
        Label aklasse = new Label("Rüstungsklasse:  ");
        aklasse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        aklasse.setTextFill(Color.web("#ffd700"));
        aklasse.setPadding(new Insets(0));
        grid.add(aklasse, 3, 2);
        klasse = new Label("-");
        klasse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        klasse.setTextFill(Color.web("#ffd700"));
        grid.add(klasse, 8, 2);

        Label aPreis = new Label("Preis: ");
        aPreis.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        aPreis.setTextFill(Color.web("#ffd700"));
        aPreis.setPadding(new Insets(0));
        grid.add(aPreis, 3, 3);
        preis = new Label("-");
        preis.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        preis.setTextFill(Color.web("#ffd700"));
        grid.add(preis, 8, 3);

        Label aGewicht = new Label("Gewicht in Pfund:   ");
        aGewicht.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        aGewicht.setTextFill(Color.web("#ffd700"));
        aGewicht.setPadding(new Insets(0));
        grid.add(aGewicht, 3, 4);
        gewicht = new Label("-");
        gewicht.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        gewicht.setTextFill(Color.web("#ffd700"));
        grid.add(gewicht, 8, 4);
// Für weitere Eigenschaften
//        Label aStaerke = new Label("Stärke");
//        aStaerke.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
//        aStaerke.setTextFill(Color.web("#ffd700"));
//        aStaerke.setPadding(new Insets(0));
//        grid.add(aStaerke, 3, 5);
//        staerke = new Label("-");
//        staerke.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
//        staerke.setTextFill(Color.web("#ffd700"));
//        grid.add(staerke, 7, 5);

//        Label anzahlGeschosse = new Label("Anzahl Geschosse");
//        anzahlGeschosse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
//        anzahlGeschosse.setTextFill(Color.web("#ffd700"));
//        anzahlGeschosse.setPadding(new Insets(0));
//        grid.add(anzahlGeschosse, 3, 6);
//        geschosse = new Label("-");
//        geschosse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
//        geschosse.setTextFill(Color.web("#ffd700"));
//        grid.add(geschosse, 7, 6);

        Label aAnwendung = new Label("Anwendung: ");
        aAnwendung.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        aAnwendung.setTextFill(Color.web("#ffd700"));
        aAnwendung.setPadding(new Insets(0));
        grid.add(aAnwendung, 3, 5);
        anwendung = new Label("-");
        anwendung.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        anwendung.setTextFill(Color.web("#ffd700"));
        grid.add(anwendung, 8, 5);
    }

    private class GegenstandEventhaendler extends ImageView {
        Gegenstand gegenstand;
        Image image;

        public GegenstandEventhaendler(Image image, Gegenstand gegenstand) {
            super(image);
            this.gegenstand = gegenstand;
            setOnMouseClicked(e -> {
                klasse.setText(gegenstand.getClass().getSimpleName());
                preis.setText(Double.toString(gegenstand.getPreis()));
                gewicht.setText(Double.toString(gegenstand.getGewicht()));
                anwendung.setText(gegenstand.getFormDerAnwendung());
            });
        }
    }
}

