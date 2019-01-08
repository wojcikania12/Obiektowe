package Kolo;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class GameThread implements Runnable{
    Socket clientSocket = null;
    DataBase db ;
    private String winner ="";
    private String player1 = "";
    private String player2 = "";

    public GameThread (Socket s,DataBase d){
        clientSocket =s;
        db = d;
    }
    public void run(){
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           while(!in.readLine().equals("close")){
             winner = in.readLine();
             player1 = in.readLine();
             player2 = in.readLine();
             db.connect();
             if(db.isConnected())  db.addData(player1,player2,winner);
             else System.out.println("Nie połączono z bazą");

           }
            System.out.println(winner);
            out.close();
            in.close();

            clientSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}