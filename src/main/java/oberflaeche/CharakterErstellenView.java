package oberflaeche;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import spielfigur.builder.Rasse;
import spielfigur.controller.CharakterController;
import spielfigur.model.Charakter;

import java.util.Arrays;
import java.util.List;

public class CharakterErstellenView {

    private CharakterController controller;

    private GridPane grid;

    private Image geistImage;
    private Image menschImage;
    private Image zwergImage;
    private Image elfImage;
    private Image hobbitImage;
    private ImageView rasseView;

    private Image bannerImage;
    private Image diebImage;
    private Image kaempferImage;
    private Image magierImage;
    private ImageView klasseView;

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

    private TextField nameTextField;

    private Scene scene;

    private HelloApplication app;

    public CharakterErstellenView(HelloApplication app, CharakterController controller) {
        this.app = app;
        this.controller = controller;
        createGrid();
        createKlassenauswahl();
        addKlassenauswahlEventHandler();
        createEigenschaftenauswahl();
        addEigenschaftenauswahlEventHandler();
        createRassenauswahl();
        addRassenauswahlEventHandler();
        createEigenschaftenanzeige();
        createNamenEingabe();

        Button speichernButton = new Button("speichern");
        speichernButton.setTextFill(Color.web("#ffd700"));
        speichernButton.setStyle("-fx-background-color: #ff0000; ");
        grid.add(speichernButton, 4, 14);
        BackgroundImage myBI= new BackgroundImage(new Image("file:src/main/resources/image/background.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        grid.setBackground(new Background(myBI));

        speichernButton.setOnMouseClicked(event -> {
            try {
                controller.setName(nameTextField.getText());
                controller.createCharakter();
                Stage stage = new Stage();
                GridPane gridPane = new GridPane();
                Label okLabel = new Label("Speichern erfolgreich");
                gridPane.add(okLabel, 0, 0);
                Button okButton = new Button("OK");
                gridPane.add(okButton, 0, 1);
                Scene scene = new Scene(gridPane, 300, 100);
                stage.setScene(scene);
                stage.setTitle("Supi dupi");
                stage.show();
                okButton.setOnMouseClicked(ev -> {
                    stage.close();
                    app.changeToStartView();
                });
            } catch (Exception e) {
                Stage stage = new Stage();
                GridPane gridPane = new GridPane();
                Label fehlerLabel = new Label(e.getMessage());
                gridPane.add(fehlerLabel, 0, 0);
                Button okButton = new Button("OK");
                gridPane.add(okButton, 0, 1);
                Scene scene = new Scene(gridPane, 300, 100);
                stage.setScene(scene);
                stage.setTitle("Fehler");
                stage.show();

                okButton.setOnMouseClicked(ev -> stage.close());
            }
        });

        Button backButton = new Button("zurück");
        grid.add(backButton, 3, 14);
        backButton.setOnMouseClicked(e -> app.changeToStartView());

        scene = new Scene(grid, 700, 500);
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
        klasseText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        klasseText.setFill(Color.GOLD);
        grid.add(klasseText, 0, 0, 2, 1);

        Label emptyLabel = new Label();
        emptyLabel.setPadding(new Insets(0, 0, 0, 140));
        grid.add(emptyLabel, 2, 0);

        geistImage = new Image("file:src/main/resources/image/geist.png");
        menschImage = new Image("file:src/main/resources/image/mensch.png");
        zwergImage = new Image("file:src/main/resources/image/zwerg.png");
        elfImage = new Image("file:src/main/resources/image/elf.png");
        hobbitImage = new Image("file:src/main/resources/image/hobbit.png");
        rasseView = new ImageView();
        rasseView.setImage(geistImage);

        bannerImage = new Image("file:src/main/resources/image/banner.png");
        diebImage = new Image("file:src/main/resources/image/bannerDieb.png");
        kaempferImage = new Image("file:src/main/resources/image/bannerKaempfer.png");
        magierImage = new Image("file:src/main/resources/image/bannerMagier.png");
        klasseView = new ImageView();
        klasseView.setImage(bannerImage);

        grid.add(rasseView, 3, 0, 1, 5);
        grid.add(klasseView, 4, 0, 1, 5);

        ToggleGroup klasseGroup = new ToggleGroup();

        diebButton = new RadioButton("Dieb");
        diebButton.setToggleGroup(klasseGroup);
        diebButton.setPadding(new Insets(7, 0, 0, 10));
        diebButton.setTextFill(Color.web("#ffd700"));
        grid.add(diebButton, 0, 1);

        kaempferButton = new RadioButton("Kämpfer");
        kaempferButton.setToggleGroup(klasseGroup);
        kaempferButton.setPadding(new Insets(0, 0, 0, 10));
        kaempferButton.setTextFill(Color.web("#ffd700"));
        grid.add(kaempferButton, 0, 2);

        magierButton = new RadioButton("Magier");
        magierButton.setToggleGroup(klasseGroup);
        magierButton.setPadding(new Insets(0, 0, 20, 10));
        magierButton.setTextFill(Color.web("#ffd700"));
        grid.add(magierButton, 0, 3);
    }

    private void addKlassenauswahlEventHandler() {
        diebButton.setOnMouseClicked(event -> {
            controller.setCharakterKlasse("Dieb");
            klasseView.setImage(diebImage);
        });
        kaempferButton.setOnMouseClicked(event -> {
            controller.setCharakterKlasse("Kaempfer");
            klasseView.setImage(kaempferImage);
        });
        magierButton.setOnMouseClicked(event -> {
            controller.setCharakterKlasse("Magier");
            klasseView.setImage(magierImage);
        });
    }

    private void createEigenschaftenauswahl() {
        Text eigenschaftenText = new Text("Eigenschaften");
        eigenschaftenText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        eigenschaftenText.setFill(Color.GOLD);
        grid.add(eigenschaftenText, 0, 4, 2, 1);

        int[] werte = controller.getVerfuegbareWerte();
        List<Integer> werteListe = Arrays.stream(werte).boxed().toList();
        ObservableList<Integer> obListe = FXCollections.observableList(werteListe);

        Label intLabel = new Label("Intelligenz:");
        intLabel.setPadding(new Insets(5, 10, 5, 10));
        intLabel.setTextFill(Color.web("#ffd700"));
        intBox = new ChoiceBox(obListe);
        grid.add(intLabel, 0, 5);
        grid.add(intBox, 1, 5);

        Label strLabel = new Label("Stärke:");
        strLabel.setPadding(new Insets(5, 10, 5, 10));
        strLabel.setTextFill(Color.web("#ffd700"));
        strBox = new ChoiceBox(obListe);
        grid.add(strLabel, 0, 6);
        grid.add(strBox, 1, 6);

        Label konLabel = new Label("Konstitution:");
        konLabel.setPadding(new Insets(5, 10, 5, 10));
        konLabel.setTextFill(Color.web("#ffd700"));
        konBox = new ChoiceBox(obListe);
        grid.add(konLabel, 0, 7);
        grid.add(konBox, 1, 7);

        Label wisLabel = new Label("Weisheit:");
        wisLabel.setPadding(new Insets(5, 10, 5, 10));
        wisLabel.setTextFill(Color.web("#ffd700"));
        wisBox = new ChoiceBox(obListe);
        grid.add(wisLabel, 0, 8);
        grid.add(wisBox, 1, 8);

        Label gesLabel = new Label("Geschicklichkeit:");
        gesLabel.setPadding(new Insets(5, 10, 5, 10));
        gesLabel.setTextFill(Color.web("#ffd700"));
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
        rasseText.setFill(Color.GOLD);
        grid.add(rasseText, 0, 10, 2, 1);

        rasseGroup = new ToggleGroup();

        menschButton = new RadioButton("Mensch");
        menschButton.setToggleGroup(rasseGroup);
        menschButton.setPadding(new Insets(7, 0, 0, 10));
        menschButton.setTextFill(Color.web("#ffd700"));
        grid.add(menschButton, 0, 11);

        zwergButton = new RadioButton("Zwerg");
        zwergButton.setToggleGroup(rasseGroup);
        zwergButton.setPadding(new Insets(0, 0, 0, 10));
        zwergButton.setTextFill(Color.web("#ffd700"));
        grid.add(zwergButton, 0, 12);

        elfButton = new RadioButton("Elf");
        elfButton.setToggleGroup(rasseGroup);
        elfButton.setPadding(new Insets(0, 0, 0, 10));
        elfButton.setTextFill(Color.web("#ffd700"));
        grid.add(elfButton, 0, 13);

        hobbitButton = new RadioButton("Hobbit");
        hobbitButton.setToggleGroup(rasseGroup);
        hobbitButton.setPadding(new Insets(0, 0, 0, 10));
        hobbitButton.setTextFill(Color.web("#ffd700"));
        grid.add(hobbitButton, 0, 14);
    }

    private void addRassenauswahlEventHandler() {
        menschButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.MENSCH);
            rasseView.setImage(menschImage);
            updateAlleEigenschaften();
        });
        zwergButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.ZWERG);
            rasseView.setImage(zwergImage);
            updateAlleEigenschaften();
        });
        elfButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.ELF);
            rasseView.setImage(elfImage);
            updateAlleEigenschaften();
        });
        hobbitButton.setOnMouseClicked(event -> {
            controller.setRasse(Rasse.HOBBIT);
            rasseView.setImage(hobbitImage);
            updateAlleEigenschaften();
        });
    }

    private void createEigenschaftenanzeige() {
        Label intAnzeige = new Label("Intelligenz");
        intAnzeige.setPadding(new Insets(0, 50, 0, 40));
        intAnzeige.setTextFill(Color.web("#ffd700"));
        grid.add(intAnzeige, 3, 6);
        intWert = new Label("-");
        intWert.setTextFill(Color.web("#ffd700"));
        grid.add(intWert, 4, 6);

        Label strAnzeige = new Label("Stärke");
        strAnzeige.setPadding(new Insets(0, 50, 0, 40));
        strAnzeige.setTextFill(Color.web("#ffd700"));
        grid.add(strAnzeige, 3, 7);
        strWert = new Label("-");
        strWert.setTextFill(Color.web("#ffd700"));
        grid.add(strWert, 4, 7);

        Label konAnzeige = new Label("Konstitution");
        konAnzeige.setPadding(new Insets(0, 50, 0, 40));
        konAnzeige.setTextFill(Color.web("#ffd700"));
        grid.add(konAnzeige, 3, 8);
        konWert = new Label("-");
        konWert.setTextFill(Color.web("#ffd700"));
        grid.add(konWert, 4, 8);

        Label wisAnzeige = new Label("Weisheit");
        wisAnzeige.setPadding(new Insets(0, 50, 0, 40));
        wisAnzeige.setTextFill(Color.web("#ffd700"));
        grid.add(wisAnzeige, 3, 9);
        wisWert = new Label("-");
        wisWert.setTextFill(Color.web("#ffd700"));
        grid.add(wisWert, 4, 9);

        Label gesAnzeige = new Label("Geschicklichkeit");
        gesAnzeige.setPadding(new Insets(0, 50, 0, 40));
        gesAnzeige.setTextFill(Color.web("#ffd700"));
        grid.add(gesAnzeige, 3, 10);
        gesWert = new Label("-");
        gesWert.setTextFill(Color.web("#ffd700"));
        grid.add(gesWert, 4, 10);
    }

    public void createNamenEingabe() {
        Label nameLabel = new Label("Name");
        nameLabel.setPadding(new Insets(0, 50, 0, 40));
        grid.add(nameLabel, 3, 12);
        nameTextField = new TextField();
        grid.add(nameTextField, 4, 12);
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

    private void updateAlleEigenschaften() {
        updateIntelligenz();
        updateStaerke();
        updateKonstitution();
        updateWeisheit();
        updateGeschicklichkeit();
    }

}
