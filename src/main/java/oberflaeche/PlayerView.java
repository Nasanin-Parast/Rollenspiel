package oberflaeche;
import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.transform.Scale;
import oberflaeche.controller.ControllerImpl;
import spielfigur.model.Charakter;
import spielfigur.model.Spielfigur;
import spielfigur.repository.CharakterRepository;

public class PlayerView {
    private ControllerImpl controller = new ControllerImpl();
    private Scene scene;
    private GridPane largeGrid = new GridPane();
    private BorderPane topRow = new BorderPane();
    private BorderPane rightColoumn = new BorderPane();
    private FlowPane characters = new FlowPane();
    private Tile tiles[][] = new Tile[controller.getRowSize()][controller.getColumnSize()];
  
        public PlayerView(Tile[][] tiles, Charakter character) {
            final int breite = 1920;
            final int hoehe = 1080;

            for (int r = 0; r < controller.getRowSize(); r++) {
                for (int c = 0; c < controller.getColumnSize(); c++) {
                    this.tiles[r][c] = new Tile(tiles[r][c].getColor(), r, c);
                    largeGrid.add(this.tiles[r][c], r, c);
                }
            }

            largeGrid.setAlignment(Pos.CENTER);

                CharacterButton charakter = new CharacterButton(character.getName());
                charakter.setCharacter(character);
                charakter.setId("NotSelected");
                //
            rightColoumn.setTop(characters);
            
            // root structure
            BorderPane root = new BorderPane();
            //root.getStyleClass().add("root");
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

        public Scene getScene(){
            return scene;
        }
        
    }

