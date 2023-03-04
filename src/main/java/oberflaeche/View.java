package oberflaeche;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import oberflaeche.controller.ControllerImpl;
import oberflaeche.model.Knoten;

public class View extends Application {
    private ControllerImpl controller = new ControllerImpl();
    private HBox buttons = new HBox();
    private Cursor tempCursor;
    private Button[] buttonArray = new Button[5];
    private Scene scene;
    private State state = State.DELETERASTER;
    private GridPane largeGrid = new GridPane();
    private ArrayList<Knoten> list = new ArrayList<Knoten>();
    private Text sideText;
        private enum State {
            DELETERASTER, PLAZIEREGEGENSTAENDE, PLATZIEREMONSTER, WANDPLATZIEREN, WANDLOESCHEN;
        }

        @Override
        public void start(Stage primaryStage) {
            final int breite = 1920;
            final int hoehe = 1080;
            for (int r = 0; r < controller.getRowSize(); r++) {
                for (int c = 0; c < controller.getColumnSize(); c++) {
                    Tile tile = new Tile(Color.WHITE, r, c);
                    largeGrid.add(tile, r, c);
                    tile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            switch(state) {
                                case PLATZIEREMONSTER:
                                    tile.setColor(Color.RED);
                                    break;
                                case WANDLOESCHEN:
                                    tile.setColor(Color.WHITE);
                                    break;
                                case WANDPLATZIEREN:
                                    tile.setColor(Color.GREY);
                                    break;
                                case PLAZIEREGEGENSTAENDE:
                                    tile.setColor(Color.YELLOW);
                                    break;
                                default:
                                    tile.setColor(Color.BLACK);
                            }
                            mouseEvent.consume();
                        }
                    });
                }
            }
            largeGrid.setAlignment(Pos.CENTER);
            buttons.setSpacing(10);

            // CSS and Buttons
            ToolButton deleteRaster = new ToolButton("Clear Raster");
            deleteRaster.setId("deleteRaster");
            ToolButton placeStartingNode = new ToolButton("Place Gegenstände ");
            placeStartingNode.setId("placeStarting");
            placeStartingNode.setOnMouseClicked(event -> state = State.PLAZIEREGEGENSTAENDE);
            ToolButton placeEndingNode = new ToolButton("Place Monster ");
            placeEndingNode.setId("placeEnding");
            placeEndingNode.setOnMouseClicked(event -> state = State.PLATZIEREMONSTER);
            ToolButton wandPlatzieren = new ToolButton("Wand platzieren");
            wandPlatzieren.setId("wandPlatzieren");
            wandPlatzieren.setOnMouseClicked(event -> state = State.WANDPLATZIEREN);
            ToolButton wandLoeschen = new ToolButton("Wand löschen");
            wandLoeschen.setId("wandLoeschen");
            wandLoeschen.setOnMouseClicked(event -> state = State.WANDLOESCHEN);
            buttonArray[0] = deleteRaster;
            buttonArray[1] = placeStartingNode;
            buttonArray[2] = placeEndingNode;
            buttonArray[3] = wandPlatzieren;
            buttonArray[4] = wandLoeschen;

            buttons.getChildren().addAll(deleteRaster, placeStartingNode, placeEndingNode, wandPlatzieren, wandLoeschen);
            sideText = new Text("Hallo");
            sideText.setFont(new Font(32));
            sideText.prefWidth(100);
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
                    state = State.WANDLOESCHEN;
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
                this.getStyleClass().add("toolButton");
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
                            controller.setSourceCordinates(-1, -1);
                            controller.setSinkCordinates(-1, -1);
                            deleteRaster(largeGrid);
                            break;

                        case PLATZIEREMONSTER:
                            break;
                        case PLAZIEREGEGENSTAENDE:
                            break;
                        case WANDPLATZIEREN:
                            break;
                        case WANDLOESCHEN:
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
            int r;
            int c;

            public Tile(Color color, int r, int c) {
                this.r = r;
                this.c = c;
                this.color = color;
                border.setFill(color);
                border.setStroke(Color.BLACK);
                this.getChildren().add(border);

                this.setOnMouseEntered(event -> {
                    tempCursor = scene.getCursor();
                    scene.setCursor(Cursor.CROSSHAIR);
                    if (event.isShiftDown()) {
                        drawTile();
                    }

                });

                this.setOnMouseExited(event -> {
                    scene.setCursor(tempCursor);
                });

                setOnMouseReleased(event -> {
                    drawTile();
                });
            }

            public void setColor(Color color) {
                this.color = color;
                border.setFill(this.color);
            }

            private void drawTile() {
                switch (state) {
                    case PLATZIEREMONSTER:
                        for (Node tile : largeGrid.getChildren()) {
                            if (((Tile) tile).color == Color.RED) {
                                ((Tile) tile).color = Color.WHITE;
                                ((Tile) tile).border.setFill(Color.WHITE);
                            }
                        }

                        if (c == controller.getSourceXCordinate() && r == controller.getSourceYCordinate()) {
                            controller.setSourceCordinates(-1, -1);
                        }

                        this.color = Color.RED;
                        border.setFill(this.color);
                        controller.setSinkCordinates(c, r);
                        break;

                    case PLAZIEREGEGENSTAENDE:
                        for (Node tile : largeGrid.getChildren()) {

                            if (((Tile) tile).color.equals(Color.LIME)) {
                                ((Tile) tile).color = Color.WHITE;
                                ((Tile) tile).border.setFill(Color.WHITE);
                            }
                        }

                        if (c == controller.getSinkXCordinate() && r == controller.getSinkYCordinate()) {
                            controller.setSinkCordinates(-1, -1);
                        }

                        this.color = Color.LIME;
                        border.setFill(this.color);
                        controller.setSourceCordinates(c, r);

                        break;

                    case WANDPLATZIEREN:
                        if (c == controller.getSinkXCordinate() && r == controller.getSinkYCordinate()) {
                            controller.setSinkCordinates(-1, -1);
                        } else if (c == controller.getSourceXCordinate() && r == controller.getSourceYCordinate()) {
                            controller.setSourceCordinates(-1, -1);
                        }
                        this.color = Color.GRAY;
                        border.setFill(this.color);
                        controller.wandPlatzieren(c, r);

                        break;

                    case WANDLOESCHEN:
                        if (color == Color.GRAY) {
                            this.color = Color.WHITE;
                            border.setFill(this.color);
                            controller.wandLoeschen(c, r);
                        }
                        break;
                    default:
                        break;

                }

            }
        }

    }


