package oberflaeche;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import spielfigur.builder.Rasse;
import spielfigur.controller.CharakterController;

import java.util.Arrays;
import java.util.List;

public class CharakterErstellenView {

    private CharakterController controller;

    private GridPane grid;

    private RadioButton diebButton;
    private RadioButton kaempferButton;
    private RadioButton magierButton;

    private ChoiceBox<Integer> intBox;
    private ChoiceBox<Integer> strBox;
    private ChoiceBox<Integer> konBox;
    private ChoiceBox<Integer> wisBox;
    private ChoiceBox<Integer> gesBox;

    private ToggleGroup rasseGroup;
    private RadioButton menschButton;
    private RadioButton zwergButton;
    private RadioButton elfButton;
    private RadioButton hobbitButton;

    private Label intWert;
    private Label strWert;
    private Label konWert;
    private Label wisWert;
    private Label gesWert;

    private Scene scene;

    public CharakterErstellenView(CharakterController controller) {
        this.controller = controller;
        createGrid();
        createKlassenauswahl();
        addKlassenauswahlEventHandler();
        createEigenschaftenauswahl();
        addEigenschaftenauswahlEventHandler();
        createRassenauswahl();
        addRassenauswahlEventHandler();
        createEigenschaftenanzeige();

        Button speichernButton = new Button("speichern");
        grid.add(speichernButton, 4, 14);

        scene = new Scene(grid, 600, 500);
    }

    public Scene getScene() {
        return scene;
    }

    private void createGrid() {
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(50, 25, 25, 25));
        grid.setVgap(3);
//        grid.setGridLinesVisible(true);
    }

    private void createKlassenauswahl() {
        Text klasseText = new Text("Klasse");
        klasseText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(klasseText, 0, 0, 2, 1);

        Label emptyLabel = new Label();
        emptyLabel.setPadding(new Insets(0, 0, 0, 140));
        grid.add(emptyLabel, 2, 0);

        Image image = new Image("file:src/main/resources/image/zwerg.png");
        ImageView view = new ImageView();
        view.setImage(image);

        grid.add(view, 3, 0, 1, 5);

        ToggleGroup klasseGroup = new ToggleGroup();

        diebButton = new RadioButton("Dieb");
        diebButton.setToggleGroup(klasseGroup);
        diebButton.setPadding(new Insets(7, 0, 0, 10));
        grid.add(diebButton, 0, 1);

        kaempferButton = new RadioButton("Kämpfer");
        kaempferButton.setToggleGroup(klasseGroup);
        kaempferButton.setPadding(new Insets(0, 0, 0, 10));
        grid.add(kaempferButton, 0, 2);

        magierButton = new RadioButton("Magier");
        magierButton.setToggleGroup(klasseGroup);
        magierButton.setPadding(new Insets(0, 0, 20, 10));
        grid.add(magierButton, 0, 3);
    }

    private void addKlassenauswahlEventHandler() {
        diebButton.setOnMouseClicked(event -> controller.setCharakterKlasse("Dieb"));
        kaempferButton.setOnMouseClicked(event -> controller.setCharakterKlasse("Kaempfer"));
        magierButton.setOnMouseClicked(event -> controller.setCharakterKlasse("Magier"));
    }

    private void createEigenschaftenauswahl() {
        Text eigenschaftenText = new Text("Eigenschaften");
        eigenschaftenText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(eigenschaftenText, 0, 4, 2, 1);

        int[] werte = controller.getVerfuegbareWerte();
        List<Integer> werteListe = Arrays.stream(werte).boxed().toList();
        ObservableList<Integer> obListe = FXCollections.observableList(werteListe);

        Label intLabel = new Label("Intelligenz:");
        intLabel.setPadding(new Insets(5, 10, 5, 10));
        intBox = new ChoiceBox(obListe);
        grid.add(intLabel, 0, 5);
        grid.add(intBox, 1, 5);

        Label strLabel = new Label("Stärke:");
        strLabel.setPadding(new Insets(5, 10, 5, 10));
        strBox = new ChoiceBox(obListe);
        grid.add(strLabel, 0, 6);
        grid.add(strBox, 1, 6);

        Label konLabel = new Label("Konstitution:");
        konLabel.setPadding(new Insets(5, 10, 5, 10));
        konBox = new ChoiceBox(obListe);
        grid.add(konLabel, 0, 7);
        grid.add(konBox, 1, 7);

        Label wisLabel = new Label("Weisheit:");
        wisLabel.setPadding(new Insets(5, 10, 5, 10));
        wisBox = new ChoiceBox(obListe);
        grid.add(wisLabel, 0, 8);
        grid.add(wisBox, 1, 8);

        Label gesLabel = new Label("Geschicklichkeit:");
        gesLabel.setPadding(new Insets(5, 10, 5, 10));
        gesBox = new ChoiceBox(obListe);
        grid.add(gesLabel, 0, 9);
        grid.add(gesBox, 1, 9);
    }

    private void addEigenschaftenauswahlEventHandler() {
        intBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            controller.setIntelligenz((int) t1);
            updateIntelligenz();
        });
        strBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            controller.setStaerke((int) t1);
            updateStaerke();
        });
        konBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            controller.setKonstitution((int) t1);
            updateKonstitution();
        });
        wisBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            controller.setWeisheit((int) t1);
            updateWeisheit();
        });
        gesBox.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
            controller.setGeschicklichkeit((int) t1);
            updateGeschicklichkeit();
        });
    }

    private void createRassenauswahl() {
        Text rasseText = new Text("Rasse");
        rasseText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(rasseText, 0, 10, 2, 1);

        rasseGroup = new ToggleGroup();

        menschButton = new RadioButton("Mensch");
        menschButton.setToggleGroup(rasseGroup);
        menschButton.setPadding(new Insets(7, 0, 0, 10));
        grid.add(menschButton, 0, 11);

        zwergButton = new RadioButton("Zwerg");
        zwergButton.setToggleGroup(rasseGroup);
        zwergButton.setPadding(new Insets(0, 0, 0, 10));
        grid.add(zwergButton, 0, 12);

        elfButton = new RadioButton("Elf");
        elfButton.setToggleGroup(rasseGroup);
        elfButton.setPadding(new Insets(0, 0, 0, 10));
        grid.add(elfButton, 0, 13);

        hobbitButton = new RadioButton("Hobbit");
        hobbitButton.setToggleGroup(rasseGroup);
        hobbitButton.setPadding(new Insets(0, 0, 0, 10));
        grid.add(hobbitButton, 0, 14);
    }

    private void addRassenauswahlEventHandler() {
        menschButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.MENSCH);
            updateAlle();
        });
        zwergButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.ZWERG);
            updateAlle();
        });
        elfButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.ELF);
            updateAlle();
        });
        hobbitButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.HOBBIT);
            updateAlle();
        });
    }

    private void createEigenschaftenanzeige() {
        Label intAnzeige = new Label("Intelligenz");
        intAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(intAnzeige, 3, 6);
        intWert = new Label("-");
        grid.add(intWert, 4, 6);

        Label strAnzeige = new Label("Stärke");
        strAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(strAnzeige, 3, 7);
        strWert = new Label("-");
        grid.add(strWert, 4, 7);

        Label konAnzeige = new Label("Konstitution");
        konAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(konAnzeige, 3, 8);
        konWert = new Label("-");
        grid.add(konWert, 4, 8);

        Label wisAnzeige = new Label("Weisheit");
        wisAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(wisAnzeige, 3, 9);
        wisWert = new Label("-");
        grid.add(wisWert, 4, 9);

        Label gesAnzeige = new Label("Geschicklichkeit");
        gesAnzeige.setPadding(new Insets(0, 50, 0, 40));
        grid.add(gesAnzeige, 3, 10);
        gesWert = new Label("-");
        grid.add(gesWert, 4, 10);
    }

    private void updateIntelligenz() {
        int intelligenz = 0;
        if (intBox.getSelectionModel().getSelectedItem() != null) {
            intelligenz += intBox.getSelectionModel().getSelectedItem();
        }
        if (rasseGroup.getSelectedToggle() != null) {
            String rasse = ((RadioButton) rasseGroup.getSelectedToggle()).getText();
            intelligenz += Rasse.valueOf(rasse.toUpperCase()).getIntBonus();
        }
        intWert.setText(Integer.toString(intelligenz));
    }

    private void updateStaerke() {
        int staerke = 0;
        if (strBox.getSelectionModel().getSelectedItem() != null) {
            staerke += strBox.getSelectionModel().getSelectedItem();
        }
        if (rasseGroup.getSelectedToggle() != null) {
            String rasse = ((RadioButton) rasseGroup.getSelectedToggle()).getText();
            staerke += Rasse.valueOf(rasse.toUpperCase()).getStrBonus();
        }
        strWert.setText(Integer.toString(staerke));
    }

    private void updateKonstitution() {
        int konstitution = 0;
        if (konBox.getSelectionModel().getSelectedItem() != null) {
            konstitution += konBox.getSelectionModel().getSelectedItem();
        }
        if (rasseGroup.getSelectedToggle() != null) {
            String rasse = ((RadioButton) rasseGroup.getSelectedToggle()).getText();
            konstitution += Rasse.valueOf(rasse.toUpperCase()).getKonBonus();
        }
        konWert.setText(Integer.toString(konstitution));
    }

    private void updateWeisheit() {
        int weisheit = 0;
        if (wisBox.getSelectionModel().getSelectedItem() != null) {
            weisheit += wisBox.getSelectionModel().getSelectedItem();
        }
        if (rasseGroup.getSelectedToggle() != null) {
            String rasse = ((RadioButton) rasseGroup.getSelectedToggle()).getText();
            weisheit += Rasse.valueOf(rasse.toUpperCase()).getWisBonus();
        }
        wisWert.setText(Integer.toString(weisheit));
    }

    private void updateGeschicklichkeit() {
        int geschicklichkeit = 0;
        if (gesBox.getSelectionModel().getSelectedItem() != null) {
            geschicklichkeit += gesBox.getSelectionModel().getSelectedItem();
        }
        if (rasseGroup.getSelectedToggle() != null) {
            String rasse = ((RadioButton) rasseGroup.getSelectedToggle()).getText();
            geschicklichkeit += Rasse.valueOf(rasse.toUpperCase()).getGesBonus();
        }
        gesWert.setText(Integer.toString(geschicklichkeit));
    }

    private void updateAlle() {
        updateIntelligenz();
        updateStaerke();
        updateKonstitution();
        updateWeisheit();
        updateGeschicklichkeit();
    }

}
