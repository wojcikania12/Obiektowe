package Kolo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Game extends Application {

    private boolean playable = true;
    private boolean turnX = true;
    private Tile[][] board = new Tile[3][3];
    int score ;
    String player_1 ;
    String player_2;

    private Pane root = new Pane();

    private Parent createContent() {
        root.setPrefSize(600, 800);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        Label label1 = new Label("Name1:");
        TextField textField = new TextField ();
        Label label2 = new Label("Name2:");
        TextField textField2 = new TextField ();
        label1.setAlignment(Pos.BOTTOM_LEFT);
        textField.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().add(label1);
        root.getChildren().add(textField);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }




    private class Tile extends StackPane {
        private Text text = new Text();

        public Tile() {
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.DEEPPINK);

            text.setFont(Font.font(80));
            text.setFill(Color.DEEPPINK);
            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(event -> {
                if (!playable)
                    return;

                if (event.getButton() == MouseButton.PRIMARY) {
                    if (!turnX)
                        return;

                    drawX();
                    turnX = false;
                }
                else if (event.getButton() == MouseButton.SECONDARY) {
                    if (turnX)
                        return;

                    drawO();
                    turnX = true;


                }
            });
        }

        public double getCenterX() {
            return getTranslateX() ;
        }

        public double getCenterY() {
            return getTranslateY() ;
        }

        public String getValue() {
            return text.getText();
        }

        public int getScore() {
            return score;
        }

        public String getPlayer1() {
            return player_1;
        }
        public String getPlayer2() {
            return player_2;
        }
        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }
    }

    private void sendData(){

    }



    public static void main(String[] args) {
        launch(args);
    }
}