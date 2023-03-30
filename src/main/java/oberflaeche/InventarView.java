package oberflaeche;

import gegenstand.Amulett;
import gegenstand.Artefakt;
import gegenstand.Gegenstand;
import gegenstand.Ring;
import gegenstand.controller.GegenstaendeController;
import gegenstand.ruestung.Kettenpanzer;
import gegenstand.ruestung.Lederruestung;
import gegenstand.ruestung.Schild;
import gegenstand.ruestung.Schuppenpanzer;
import gegenstand.waffe.*;
import inventar.Inventar;
import inventar.InventarController;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.*;


public class InventarView {
    private GegenstaendeController controller;
    private GridPane grid;
    Scene scene;
    RadioButton useButton;
    RadioButton wearButton;
    Button abbrechenButton;
    RadioButton unsichtbarButton;
    RadioButton nichtAngreifbarButton;
    ToggleGroup auswirkungGroup;
    ToggleGroup anwendungGroup;
    Alert alert;
    ButtonType yesButton;
    ButtonType noButton;
    InventarController con;
    Label klasse;
    Label preis;
    Label gewicht;
    Label staerke;
    Label geschosse;
    TilePane tilepane;
    Label anwendung;
    Label auswirkung;


    public InventarView(GegenstaendeController controller) {
        this.controller = controller;
        erstelleFenster();
        //anwendungAuswirkung();
        zeigeInventar();
        createEigenschaftenanzeige();

        abbrechenButton = new Button("Abbrechen");
        abbrechenButton.setId("abbrechen");
        grid.add(abbrechenButton, 20, 10);
        abbrechenButton.setMaxSize(500,500);
        abbrechenButton.setOnMouseClicked(e -> abbrechen());
        scene = new Scene(grid, 800, 700);

        BackgroundFill background_fill = new BackgroundFill(Color.PINK,
                CornerRadii.EMPTY, Insets.EMPTY);
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

//    private void anwendungAuswirkung() {
//        Text anwendungText = new Text("Anwendung");
//        anwendungText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(anwendungText, 10, 4);
//
//        anwendungGroup = new ToggleGroup();
//        useButton = new RadioButton("use");
//        useButton.setToggleGroup(anwendungGroup);
//        grid.add(useButton, 10, 5);
//
//        wearButton = new RadioButton("wear");
//        wearButton.setToggleGroup(anwendungGroup);
//        grid.add(wearButton, 10, 6);
//
//        Text auswirkungText = new Text("Auswirkung");
//        auswirkungText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(auswirkungText, 10, 0, 3, 1);
//
//        auswirkungGroup = new ToggleGroup();
//        nichtAngreifbarButton = new RadioButton("Nicht angreifbar");
//        nichtAngreifbarButton.setToggleGroup(auswirkungGroup);
//        grid.add(nichtAngreifbarButton, 10, 1);
//
//        unsichtbarButton = new RadioButton("unsichtbar");
//        unsichtbarButton.setToggleGroup(auswirkungGroup);
//        grid.add(unsichtbarButton, 10, 2);
//    }

    public void abbrechen() {
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
        inventarText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(inventarText, 1, 0, 5, 1);
        con = new InventarController();
        con.create();
        List<Gegenstand> gegenstand = con.getGegenstaende(1);
        ObservableList<String> observableListe = FXCollections.observableList(con.getGegenstaende(1)
                .stream().map(e -> e.getClass().getSimpleName()).toList());
        tilepane = new TilePane();
        tilepane.setPadding(new Insets(15));
        tilepane.setHgap(5);
        tilepane.setVgap(5);
        List<Gegenstand> alle = con.getGegenstaende(1);
        for (int i = 0; i < 13; i++) {
            Image image = new Image("file:src/main/resources/image/elf.png");
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
                    image = new Image("file:src/main/resources/image/gegenstand/emptySlot.png");
                }
            }
            ImageView imageView;
            if (i < alle.size()) {
                imageView = new GegenstandEventhaendler(image, gegenstand.get(i));
            } else {
                imageView = new ImageView(image);
            }
            tilepane.getChildren().add(imageView);
        }
        grid.add(tilepane, 0, 20, 20, 1);
    }


    private void createEigenschaftenanzeige() {
        Label aklasse = new Label("Rüstungsklasse");
        aklasse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        aklasse.setPadding(new Insets(0));
        grid.add(aklasse, 3, 2);
        klasse = new Label("-");
        klasse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        klasse.setPadding(new Insets(0, 100, 0, 0));
        grid.add(klasse, 5, 2);

        Label aPreis = new Label("Preis");
        aPreis.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        aPreis.setPadding(new Insets(0));
        grid.add(aPreis, 3, 3);
        preis = new Label("-");
        preis.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(preis, 5, 3);

        Label aGewicht = new Label("Gewicht in Pfund");
        aGewicht.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        aGewicht.setPadding(new Insets(0));
        grid.add(aGewicht, 3, 4);
        gewicht = new Label("-");
        gewicht.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(gewicht, 5, 4);

        Label aStärke = new Label("Stärke");
        aStärke.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        aStärke.setPadding(new Insets(0));
        grid.add(aStärke, 3, 5);
        staerke = new Label("-");
        staerke.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(staerke, 5, 5);

        Label anzahlGeschosse = new Label("Anzahl Geschosse");
        anzahlGeschosse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        anzahlGeschosse.setPadding(new Insets(0));
        grid.add(anzahlGeschosse, 3, 6);
        geschosse = new Label("-");
        geschosse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(geschosse, 5, 6);

        anwendung = new Label("Anwendung");
        anwendung.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        anwendung.setPadding(new Insets(0));
        grid.add(anwendung, 3, 7);
        auswirkung = new Label("-");
        auswirkung.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(auswirkung, 5, 7);
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
                auswirkung.setText(gegenstand.getFormDerAnwendung());
            });
        }
    }
}

