package oberflaeche;

import gegenstand.Amulett;
import gegenstand.Gegenstand;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;

import java.util.*;


public class InventarView {
    private GegenstaendeController controller;
    private GridPane grid;
    private Image lederruestung;
    private Image schuppenpanzer;
    private Image kettenpanzer;
    private Image schild;
    private Image dolch;
    private Image wurfpfeil;
    private Image streitaxt;
    private Image speer;
    private Image degen;
    private Image boogenUndPfeile;
    private Image peileOderDarts;
    private Image amulett;
    private Image ring;
    private Image heiltrank;
    private Image gift;
    private Image unsichtbarkeitTrank;


    private ImageView imageview;

    private ChoiceBox<String> ruesstungBox;
    private ChoiceBox<String> waffeBox;
    private ChoiceBox<String> artefakteBox;
    private ChoiceBox<String> magischBox;
    private ChoiceBox<String> traenkeBox;
    private Label artefakte;
    private Label magisch;
    private Label waffe;
    private Label ruestung;
    private Label traenke;

    private ImageView imageName;
    private ImageView auswirkungView;
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
    TilePane tilepane;


    public InventarView(GegenstaendeController controller) {
        this.controller = controller;
        erstelleFenster();
        anwendungAuswirkung();
        zeigeInventar();
        addGegenstaendeEventHandler();
        createEigenschaftenanzeige();

        abbrechenButton = new Button("Abbrechen");
        abbrechenButton.setId("abbrechen");
        abbrechenButton.setOnMouseClicked(e -> abbrechen());
        grid.add(abbrechenButton, 6, 10);

        scene = new Scene(grid, 900, 800);


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
        //(top/right/bottom/left)
        grid.setPadding(new Insets(20.0f, 40.0f, 60.0f, 70.0f));
        grid.setVgap(3);
    }

    private void anwendungAuswirkung() {
        Text anwendungText = new Text("Anwendung");
        anwendungText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(anwendungText, 10, 4);

        anwendungGroup = new ToggleGroup();
        useButton = new RadioButton("use");
        useButton.setToggleGroup(anwendungGroup);
        useButton.setPadding(new Insets(10, 0, 0, 0));
        grid.add(useButton, 10, 5);

        wearButton = new RadioButton("wear");
        wearButton.setToggleGroup(anwendungGroup);
        wearButton.setPadding(new Insets(5, 0, 0, 0));
        grid.add(wearButton, 10, 6);

        Text auswirkungText = new Text("Auswirkung");
        auswirkungText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(auswirkungText, 10, 0);

        auswirkungGroup = new ToggleGroup();
        nichtAngreifbarButton = new RadioButton("Nicht angreifbar");
        nichtAngreifbarButton.setToggleGroup(auswirkungGroup);
        nichtAngreifbarButton.setPadding(new Insets(10, 0, 0, 0));
        grid.add(nichtAngreifbarButton, 10, 1);

        unsichtbarButton = new RadioButton("unsichtbar");
        unsichtbarButton.setToggleGroup(auswirkungGroup);
        unsichtbarButton.setPadding(new Insets(5, 0, 0, 0));
        grid.add(unsichtbarButton, 10, 2);
    }

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
        grid.add(inventarText, 1, 0, 8, 1);
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
        for (int i = 0; i < 15; i++) {
            Image image = new Image("file:src/main/resources/image/banner.png");
            if (i < alle.size()) {
                if (alle.get(i) instanceof Amulett) {
                    image = new Image("file:src/main/resources/image/amulett.png");
                } else if (alle.get(i) instanceof Kettenpanzer) {
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Lederruestung){
                    image = new Image("file:src/main/resources/image/elf.png");
                }else if (alle.get(i) instanceof Schuppenpanzer){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Schild){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Dolch){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Wurfpfeil){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Handaxt){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Streitaxt){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Speer){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Schwert){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof Degen){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }else if (alle.get(i) instanceof BogenMitPfeilen){
                    image = new Image("file:src/main/resources/image/kettenpanzer.png");
                }
            }
            ImageView imageView = new ImageView(image);
            tilepane.getChildren().add(imageView);
            imageView.setPickOnBounds(true);
            imageView.setOnMouseClicked((MouseEvent e) -> {
                System.out.println("Clicked!"); // change functionality
            });
        }
        grid.add(tilepane, 0, 20, 20, 1);
    }
    private void createEigenschaftenanzeige() {
        Label aklasse = new Label("Klasse");
        aklasse.setPadding(new Insets(0, 50, 0, 40));
        grid.add(aklasse, 3, 6);
        klasse= new Label("-");
        grid.add(klasse, 4, 6);

        Label strAnzeige = new Label("Preis");
        strAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(strAnzeige, 3, 7);
        preis = new Label("-");
        grid.add(preis, 4, 7);

        Label konAnzeige = new Label("Gewicht in Pfund");
        konAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(konAnzeige, 3, 8);
        gewicht = new Label("-");
        grid.add(gewicht, 4, 8);

        Label wisAnzeige = new Label("Stärke");
        wisAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(wisAnzeige, 3, 9);
        staerke = new Label("-");
        grid.add(staerke, 4, 9);

    }




    private void addGegenstaendeEventHandler() {

//        artefakteBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, artefakte) -> {
//            controller.setArtefakte((String) artefakte);
//            updateArtefakte();
//        });
//        magischBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, magisch) -> {
//            controller.setMagisch((String) magisch);
//            updateMagisch();
//        });
//        waffeBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, waffe) -> {
//            controller.setWaffe((String) waffe);
//            updateWaffe();
//        });
//        ruesstungBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, ruestung) -> {
//            controller.setRuesstung((String) ruestung);
//            updateRuesstung();
//        });
//        traenkeBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, traenke) -> {
//            controller.setTraenke((String) traenke);
//            updateTraenke();
//        });
    }

    private void updateTraenke() {
    }

    private void updateRuesstung() {
    }

    private void updateWaffe() {
    }

    private void updateMagisch() {
    }

    private void updateArtefakte() {
    }


}

