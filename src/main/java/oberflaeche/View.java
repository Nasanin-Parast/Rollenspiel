package oberflaeche;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import oberflaeche.controller.ControllerImpl;
import oberflaeche.model.Knoten;
import spielfigur.model.Charakter;
import spielfigur.repository.CharakterRepository;

public class View extends Application {
    private ControllerImpl controller = new ControllerImpl();
    private FlowPane buttons = new FlowPane();
    private FlowPane mapSave = new FlowPane();
    private Cursor tempCursor;
    private Button[] buttonArray = new Button[5];
    private Region[] mapArray = new Region[3];
    private Scene scene;
    private State state = State.DELETERASTER;
    private GridPane largeGrid = new GridPane();
    private BorderPane topRow = new BorderPane();
    private BorderPane rightColoumn = new BorderPane();
    private FlowPane characters = new FlowPane();
    private FlowPane monsters = new FlowPane();
    private List<Character> playerCharacter = new ArrayList<Character>();
    private Tile tiles[][];
    private ArrayList<Knoten> list = new ArrayList<Knoten>();
    private Text sideText;
    private File file = new File("./Rollenspiel/Dateien/Save.txt");
    private ObservableList<String> choiceList = FXCollections.observableArrayList("");
    ChoiceBox<String> maps;
        private enum State {
            DELETERASTER, PLAZIEREGEGENSTAENDE, PLATZIEREMONSTER, WANDPLATZIEREN, TILELOESCHEN;
        }

        @Override
        public void start(Stage primaryStage) {
            final int breite = 1920;
            final int hoehe = 1080;
            tiles = new Tile[controller.getRowSize()][controller.getColumnSize()];
            for (int r = 0; r < controller.getRowSize(); r++) {
                for (int c = 0; c < controller.getColumnSize(); c++) {
                    Tile tile = new Tile(Color.WHITE, r, c);
                    tiles[r][c] = tile;
                    largeGrid.add(tile, r, c);
                    tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            switch(state) {
                                case PLATZIEREMONSTER:
                                    tile.setColor(Color.RED);
                                    break;
                                case TILELOESCHEN:
                                    tile.setColor(Color.WHITE);
                                    break;
                                case WANDPLATZIEREN:
                                    tile.setColor(Color.GREY);
                                    break;
                                case PLAZIEREGEGENSTAENDE:
                                    tile.setColor(Color.YELLOW);
                                    break;
                                default:
                                    tile.setColor(Color.WHITE);
                            }
                            mouseEvent.consume();
                        }
                    });
                }
            }
            largeGrid.setAlignment(Pos.CENTER);
            buttons.setMaxWidth(800);
            
            //buttons.setSpacing(10);

            // CSS and Buttons
            ToolButton deleteRaster = new ToolButton("Clear Raster");
            deleteRaster.setId("deleteRaster");
            deleteRaster.setOnMouseClicked(event -> state = State.DELETERASTER);
            ToolButton gegenstandPlatzierenButton = new ToolButton("Place Gegenstände ");
            gegenstandPlatzierenButton.setId("placeStarting");
            gegenstandPlatzierenButton.setOnMouseClicked(event -> {
                                                            state = State.PLAZIEREGEGENSTAENDE;
                                                            unselectButton();
                                                            gegenstandPlatzierenButton.setId("placeStartingSelected");
                                                        } );
            ToolButton monsterPlatzierenButton = new ToolButton("Place Monster ");
            monsterPlatzierenButton.setId("placeEnding");
            monsterPlatzierenButton.setOnMouseClicked(event -> {
                                                        state = State.PLATZIEREMONSTER;
                                                        unselectButton();
                                                        monsterPlatzierenButton.setId("placeEndingSelected");
                                                    } );
            ToolButton wandPlatzierenButton = new ToolButton("Wand platzieren");
            wandPlatzierenButton.setId("wandPlatzieren");
            wandPlatzierenButton.setOnMouseClicked(event -> {
                                                    state = State.WANDPLATZIEREN;
                                                    unselectButton();
                                                    wandPlatzierenButton.setId("wandPlatzierenSelected");
                                                } );
            ToolButton wandLoeschenButton = new ToolButton("Tile löschen");
            wandLoeschenButton.setId("wandLoeschen");
            wandLoeschenButton.setOnMouseClicked(event -> {
                                                    state = State.TILELOESCHEN;
                                                    unselectButton();
                                                    wandLoeschenButton.setId("wandLoeschenSelected");
                                                } );
            buttons.setMinWidth(1000);

            buttonArray[0] = deleteRaster;
            buttonArray[1] = gegenstandPlatzierenButton;
            buttonArray[2] = monsterPlatzierenButton;
            buttonArray[3] = wandPlatzierenButton;
            buttonArray[4] = wandLoeschenButton;

            ToolButton save = new ToolButton("Speichern");
            save.setId("save");
            save.setOnMouseClicked(event -> saveMap());

            ToolButton load = new ToolButton("Laden");
            load.setId("load");
            load.setOnMouseClicked(event -> loadMap());

            try (Scanner in = new Scanner(file)) {
                List<String> temp = new ArrayList<String>();
                while(in.hasNextLine()){
                    temp.add(in.nextLine().split(";")[0]);
                }
                choiceList.addAll(temp);
                maps = new ChoiceBox<>(choiceList);
            } catch (IOException e) {
                System.out.println("File could not be opened.");
                e.printStackTrace();
            }
            maps.minWidth(500);

            mapArray[0] = save;
            mapArray[1] = load;
            mapArray[2] = maps;
            mapSave.getChildren().addAll(save, load, maps);

            buttons.getChildren().addAll(deleteRaster, gegenstandPlatzierenButton, monsterPlatzierenButton, wandPlatzierenButton, wandLoeschenButton);

            topRow.setLeft(buttons);
            topRow.setRight(mapSave);


            CharakterRepository repo = new CharakterRepository();
            List<Charakter> character = repo.getAll();
            System.out.println(character.size());
            for(int i = 0; i < character.size(); i++){
                CharacterButton temp = new CharacterButton(character.get(i).getName());
                temp.setCharacter(character.get(i));
                temp.setId("NotSelected");
                temp.setOnMouseClicked(event -> {
                    if(temp.getId() == "Selected"){
                        temp.setId("NotSelected");
                    }else{
                        temp.setId("Selected");
                    }
                });;
                characters.getChildren().add(temp);
            }
            rightColoumn.setTop(characters);
            
            // root structure
            BorderPane root = new BorderPane();
            root.getStyleClass().add("root");
            root.setTop(topRow);
            root.setCenter(largeGrid);
            root.setRight(rightColoumn);

            // Scaling
            Scale scale = new Scale(1, 1, 0, 0);
            scale.xProperty().bind(root.widthProperty().divide(breite));
            scale.yProperty().bind(root.heightProperty().divide(hoehe));
            root.getTransforms().add(scale);

            // display
            scene = new Scene(root, 1090, 600);
            String css = this.getClass().getResource("/application.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.setResizable(true);
            primaryStage.setScene(scene);
            primaryStage.show();

        }

        private void unselectButton() {
            for(int i = 0; i < buttonArray.length; i++){
                if(buttonArray[i].getId().endsWith("Selected")){
                    buttonArray[i].setId(buttonArray[i].getId().substring(0,buttonArray[i].getId().indexOf("Selected")));
                }
            }
        }

        private EventHandler<? super MouseEvent> setButtonStates(Button button) {
            switch (button.getText()) {
                case "Loesche Raster":
                    state = State.DELETERASTER;
                    break;
                case "Platziere Gegenstaende":
                    state = State.PLAZIEREGEGENSTAENDE;
                    break;
                case "Platziere Monster":
                    state = State.PLATZIEREMONSTER;
                    break;
                case "Platziere Wand":
                    state = State.WANDPLATZIEREN;
                    break;
                case "Loesche Wand":
                    state = State.TILELOESCHEN;
                    break;
            }
            return null;
        }

        private EventHandler<? super MouseEvent> deleteRaster(GridPane grid) {
            for (int r = 0; r < grid.getRowCount(); r++) {
                for (int c = 0; c < grid.getColumnCount(); c++) {
                    ((Tile) (grid.getChildren().get(r * 20 + c))).border.setFill(Color.WHITE);
                    ((Tile) (grid.getChildren().get(r * 20 + c))).color = Color.WHITE;
                }
            }
            return null;
        }

        public class ToolButton extends Button {
            public ToolButton(String text) {
                this.setText(text);

                this.setOnMouseEntered(event -> {
                    tempCursor = scene.getCursor();
                    scene.setCursor(Cursor.HAND);
                });
                this.setOnMouseExited(event -> {
                    scene.setCursor(tempCursor);
                });

                this.setOnMouseClicked(event -> {
                    for (int i = 0; i < buttonArray.length; i++) {
                        buttonArray[i].getStyleClass().remove("selectedButton");
                    }
                    this.getStyleClass().add("selectedButton");
                });

                this.setOnMouseReleased(event -> {
                    setButtonStates(this);
                    switch (state) {
                        case DELETERASTER:
                            controller.clear();
                            //controller.setSourceCordinates(-1, -1);
                            //controller.setSinkCordinates(-1, -1);
                            deleteRaster(largeGrid);
                            break;

                        case PLATZIEREMONSTER:
                            break;
                        case PLAZIEREGEGENSTAENDE:
                            break;
                        case WANDPLATZIEREN:
                            break;
                        case TILELOESCHEN:
                            break;
                        default:
                            break;

                    }
                });

            }
        }

        public class RunnableToolButton extends ToolButton {
            public RunnableToolButton(String text) {
                super(text);

                this.getStyleClass().add("runnableToolButton");
            }
        }

        public class Tile extends StackPane {
            Rectangle border = new Rectangle(45, 45);
            Color color;

            public Tile(Color color, int r, int c) {
                this.color = color;
                border.setFill(color);
                border.setStroke(Color.GREY);
                this.getChildren().add(border);

            }

            public void setColor(Color color) {
                this.color = color;
                border.setFill(this.color);
            }

            public Color getColor() {
                return color;
            }

        }

        public void saveMap(){
            int i = 1;
            try (Scanner in = new Scanner(file)) {
                while(in.hasNextLine()){
                    i++;
                    in.nextLine();
                }
            } catch (Exception e) {
                System.out.println("File could not be opened.");
                e.printStackTrace();
            }
            try (FileOutputStream out = new FileOutputStream(file, true)) {
                out.write(("Map " + i + ";").getBytes());
                String temp = "";
                for (int r = 0; r < controller.getRowSize(); r++) {
                    for (int c = 0; c < controller.getColumnSize(); c++) {
                        if(tiles[r][c].getColor() == Color.WHITE){
                            temp = temp + "0";
                            out.write("0".getBytes());
                        } else if(tiles[r][c].getColor() == Color.RED){
                            temp = temp + "1";
                            out.write("1".getBytes());
                        } else if(tiles[r][c].getColor() == Color.YELLOW){
                            temp = temp + "2";
                            out.write("2".getBytes());
                        } else if(tiles[r][c].getColor() == Color.GREY){
                            temp = temp + "3";
                            out.write("3".getBytes());
                        }
                    }
                }
                out.write("\n".getBytes());
                out.flush();
                choiceList.add(temp);
                maps.setItems(choiceList);
            } catch (IOException e) {
                System.out.println("File could not be opened.");
                e.printStackTrace();
            }
        }

        public void loadMap(){
            try (Scanner in = new Scanner(file)) {
                while(in.hasNextLine()){
                    String temp = in.nextLine();
                    if(temp.split(";")[0].contains(maps.getSelectionModel().getSelectedItem())){
                        int a = 0;
                        int b = 0;
                        for (char number : temp.split(";")[1].toCharArray()) {
                            switch(number){
                                case '0':
                                tiles[a][b].setColor(Color.WHITE);
                                break;
                                case '1':
                                tiles[a][b].setColor(Color.RED);
                                break;
                                case '2':
                                tiles[a][b].setColor(Color.YELLOW);
                                break;
                                case '3':
                                tiles[a][b].setColor(Color.GREY);
                                break;
                                default:
                                System.out.println("no number!");
                                break;
                            }
                            b++;
                            if(b == (tiles.length)){
                                b = 0;
                                a++;
                            }
                            System.out.println(a);
                            System.out.println(b);
                        }
                    }
                }

            } catch (IOException e) {
                System.out.println("File could not be opened.");
                e.printStackTrace();
            }
        }

        private class CharacterButton extends Button{
            private Charakter characterB;

            public CharacterButton(String name){
                super(name);
            }

            public void setCharacter(Charakter character){
                characterB = character;
            }

            public Charakter getCharacter(){
                return characterB;
            }
        }
        
    }

