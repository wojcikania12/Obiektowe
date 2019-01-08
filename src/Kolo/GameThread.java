package Kolo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class GameThread implements Runnable{
    Socket clientSocket = null;
    DataBase db ;

    public GameThread (Socket s,DataBase d){
        clientSocket =s;
        db = d;
    }
    public void run(){
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
            out.close();
            in.close();
            clientSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}