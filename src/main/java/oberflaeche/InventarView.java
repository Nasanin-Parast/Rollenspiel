package oberflaeche;

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
import javafx.stage.WindowEvent;
import spielfigur.controller.GegenstaendeController;

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

    private ChoiceBox<Integer> ruestungBox;
    private ChoiceBox<Integer> waffeBox;
    private ChoiceBox<Integer> artefakteBox;
    private ChoiceBox<Integer> magischBox;
    private ChoiceBox<Integer> traenkeBox;
    private Label artefakte;
    private Label maisch;
    private Label waffe;
    private Label ruestung;
    private Label traenke;

    private ImageView artefakteView;
    private ImageView ausruestungView;
    Scene scene;
    RadioButton normalButton;
    RadioButton magischButton;
    RadioButton traenkeButton;
    Button abbrechenButton;

    public InventarView(GegenstaendeController controller) {
        this.controller = controller;
        erstelleFenster();
        erstelleArtefakteAuswahl();
        addArtefakteAuswahlEventHandler();

        abbrechenButton = new Button("Abbrechen");
        grid.add(abbrechenButton, 4, 14);
        scene = new Scene(grid, 800, 600);
    }

    private void addArtefakteAuswahlEventHandler() {
        normalButton.setOnMouseClicked(event -> {
            controller.setGegenstaendeKlasse("Normal");
            //artefakteView.setImage();
        });
        magischButton.setOnMouseClicked(event -> {
            controller.setGegenstaendeKlasse("Magisch");
            //artefakteView.setImage();
        });
        traenkeButton.setOnMouseClicked(event -> {
            controller.setGegenstaendeKlasse("Tränke");
            //artefakteView.setImage();
        });
    }

    public Scene getScene() {
        return scene;
    }

    private void erstelleFenster() {
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(20.0f, 40.0f, 60.0f, 70.0f));
        grid.setVgap(3);
    }

    private void erstelleArtefakteAuswahl() {
        Text artefakteText = new Text("Artefakte");
        artefakteText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Label label = new Label();
        label.setPadding(new Insets(0, 0, 0, 140));
        grid.add(label, 2, 0);
        artefakteView = new ImageView();
        // artefakteView.setImage();
        grid.add(artefakteView, 3, 0, 1, 5);

        ausruestungView = new ImageView();
        grid.add(ausruestungView, 3, 0, 1, 5);

        ToggleGroup artefakteGroup = new ToggleGroup();
        RadioButton normalButton = new RadioButton("Normal");
        normalButton.setToggleGroup(artefakteGroup);
        normalButton.setPadding(new Insets(7, 0, 0, 10));
        grid.add(normalButton, 0, 1);

        RadioButton magischButton = new RadioButton("Magisch");
        magischButton.setToggleGroup(artefakteGroup);
        magischButton.setPadding(new Insets(0, 0, 0, 10));
        grid.add(magischButton, 0, 2);

        RadioButton traenkeButton = new RadioButton("Tränke");
        traenkeButton.setToggleGroup(artefakteGroup);
        traenkeButton.setPadding(new Insets(0, 0, 20, 10));
        grid.add(traenkeButton, 0, 3);

        ToggleGroup ausruestungGroup = new ToggleGroup();
        RadioButton ruesstungButton = new RadioButton("Rüsstung");
        ruesstungButton.setToggleGroup(ausruestungGroup);
        ruesstungButton.setPadding(new Insets(7, 0, 0, 10));
        grid.add(ruesstungButton, 0, 1);

        RadioButton waffeButton = new RadioButton("Waffe");
        waffeButton.setToggleGroup(ausruestungGroup);
        waffeButton.setPadding(new Insets(0, 0, 0, 10));
        grid.add(waffeButton, 0, 2);
    }

    public void abbrechen(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Would You Like To Save Your Console Output?");
        alert.setContentText("Please choose an option.");
        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");
        for (ButtonType bt : alert.getDialogPane().getButtonTypes()) {
            if (bt.getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                Button cancelButton = (Button) alert.getDialogPane().lookupButton(bt);
                cancelButton.fire();
                break;
            }
        }
    }

}

