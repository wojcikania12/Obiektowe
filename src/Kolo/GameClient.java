package Kolo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient extends Application {
    private BoardTile[][] board = new BoardTile[3][3];
    private String winner = null;
    private String player_1;
    private String player_2;
    private boolean end = false;


    private Pane root = new Pane();
    private Label label1 = new Label("Gracz1:");
    private TextField textField = new TextField();
    private Label label2 = new Label("Gracz2:");
    private TextField textField2 = new TextField();
    private Label label3 = new Label("Zwyciezca:");
    private TextField textField3 = new TextField();
    Button button3 = new Button("Wyślij");


    private Parent createContent() {
        root.setPrefSize(600, 800);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                BoardTile tile = new BoardTile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        root.getChildren().add(label1);
        root.getChildren().add(textField);
        root.getChildren().add(label2);
        root.getChildren().add(textField2);
        root.getChildren().add(label3);
        root.getChildren().add(textField3);
        root.getChildren().add(button3);
        label1.relocate(30, 620);
        textField.relocate(80, 620);
        label2.relocate(30, 660);
        textField2.relocate(80, 660);
        label3.relocate(340, 620);
        textField3.relocate(340, 640);
        button3.relocate(510, 640);

        textField.relocate(80, 620);
        label2.relocate(30, 660);
        textField2.relocate(80, 660);
        label3.relocate(340, 620);
        textField3.relocate(340, 640);
        button3.relocate(510, 640);


        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        end = false;
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    end = true;
                    stop();
                }catch (Exception e){}
            }
        });



        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player_1 = textField.getText();
                player_2 = textField2.getText();
                winner = textField3.getText();
                try{
                socketSendData();
                }catch( IOException e){}
                textField3.clear();
            }
        });


    }

    public void socketSendData() throws IOException{
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader( echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost."); System.exit(1);
        } catch (IOException e) { System.err.println("Couldn't get I/O for " + "the connection to: localhost."); System.exit(1);
        }

            out.println(winner);
            out.println(player_1);
            out.println(player_2);



        out.close();
        in.close();
        echoSocket.close();
    }


    public String getWinner() {

        return winner;
    }

    public String getPlayer1() {

        return player_1;
    }

    public String getPlayer2() {

        return player_2;
    }


    public static void main(String[] args) throws IOException {
        launch(args);

    }
}
