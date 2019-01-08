package Kolo;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


     class BoardTile extends StackPane {
        private Text text = new Text();

        public BoardTile() {
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.DEEPPINK);

            text.setFont(Font.font(80));
            text.setFill(Color.DEEPPINK);
            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(event -> {

                if (event.getButton() == MouseButton.PRIMARY) {
                    drawX();
                }
                else if (event.getButton() == MouseButton.SECONDARY) {
                    drawO();
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


        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }
    }

