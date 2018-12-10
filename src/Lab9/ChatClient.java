package Lab9;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.io.*;
import java.net.*;
import java.util.ResourceBundle;

public class ChatClient implements Initializable {
    BufferedReader in;
    PrintWriter out;
    Socket socket;
    String nick_str;
    @FXML private TextField nick;
    @FXML private TextField ip;
    @FXML private TextField message;
    @FXML private Button send;
    @FXML private Button connect;


    @FXML private VBox messages;


    private String getServerAddress(){

        return ip.getText();
        }

    private String getNick() {
        nick_str = nick.getText();
        return nick_str;
    }
    private void sendDrawing(){

    }

    @FXML public void sendMessage(){
        out.println(message.getText());
        message.clear();
    }

    @FXML public void run()throws IOException {
        socket = new Socket(getServerAddress(), 9001);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        out.println(getNick());
     while (in.readLine()!=null) {
            String line = in.readLine();
            messages.getChildren().add( new Text(line));

    }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
