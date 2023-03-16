package oberflaeche;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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

public class View extends Application {
    private ControllerImpl controller = new ControllerImpl();
    private FlowPane buttons = new FlowPane();
    private Cursor tempCursor;
    private Button[] buttonArray = new Button[6];
    private Scene scene;
    private State state = State.DELETERASTER;
    private GridPane largeGrid = new GridPane();
    private Tile tiles[][];
    private ArrayList<Knoten> list = new ArrayList<Knoten>();
    private Text sideText;
    private File file = new File("./Rollenspiel/Dateien/Save.txt");
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
            ToolButton save = new ToolButton("Speichern");
            save.setId("save");
            save.setOnMouseClicked(event -> {
                                    saveMap();
                                    unselectButton();
                                    save.setId("saveSelected");
            } );                  
            buttonArray[0] = deleteRaster;
            buttonArray[1] = gegenstandPlatzierenButton;
            buttonArray[2] = monsterPlatzierenButton;
            buttonArray[3] = wandPlatzierenButton;
            buttonArray[4] = wandLoeschenButton;
            buttonArray[5] = save;

            buttons.getChildren().addAll(deleteRaster, gegenstandPlatzierenButton, monsterPlatzierenButton, wandPlatzierenButton, wandLoeschenButton, save);
            sideText = new Text("Willkommen zur Gamemaster UI. In der Mitte des Fenster befindet sich das Spielfeld welches nun editiert werden kann. Dazu wählt man aus den oberen Buttons die Aktion aus und klickt einfach auf die entsprechenden Felder welche man abändern möchte.");
            sideText.setFont(new Font(32));
            sideText.prefWidth(400);
            sideText.setWrappingWidth(377);
            VBox bottom = new VBox();

            Slider slide = new Slider();
            slide.setOnMouseEntered(event -> {
                tempCursor = scene.getCursor();
                scene.setCursor(Cursor.HAND);
            });
            slide.setOnMouseExited(event -> {
                scene.setCursor(tempCursor);
            });
            slide.setShowTickLabels(true);
            slide.setShowTickMarks(true);
            slide.setBlockIncrement(1);
            slide.adjustValue(50);
            Text bottomText = new Text();
            bottomText.setFont(new Font(32));
            bottom.getChildren().addAll(bottomText, slide);

            // root structure
            BorderPane root = new BorderPane();
            root.getStyleClass().add("root");
            root.setTop(buttons);
            root.setCenter(largeGrid);
            root.setLeft(sideText);
            root.setBottom(bottom);

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
            String temp = "";
            for (int r = 0; r < controller.getRowSize(); r++) {
                for (int c = 0; c < controller.getColumnSize(); c++) {
                    if(tiles[r][c].getColor() == Color.WHITE){
                        temp = temp + "0";
                    } else if(tiles[r][c].getColor() == Color.RED){
                        temp = temp + "1";
                    } else if(tiles[r][c].getColor() == Color.YELLOW){
                        temp = temp + "2";
                    } else if(tiles[r][c].getColor() == Color.GREY){
                        temp = temp + "3";
                    }
                }
            }
            try (FileOutputStream out = new FileOutputStream(file, true)) {
                out.write(Byte.parseByte(temp));
                out.flush();
            } catch (IOException e) {
                System.out.println("File could not be opened.");
                e.printStackTrace();
            }
            System.out.println(temp);
        }

    }


