package Kolo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true); in = new BufferedReader(new InputStreamReader( echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost."); System.exit(1);
        } catch (IOException e) { System.err.println("Couldn't get I/O for " + "the connection to: localhost."); System.exit(1);
        }
        Game game = new Game();
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        String userInput;
        System.out.println("Type a message: ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("Serwer: " + in.readLine()); }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
