package Kolo;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer extends Thread{
    static int numberOfThreads = 1;
    static DataBase db = new DataBase();

    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);
            while(true){
                GameThread t= new GameThread(serverSocket.accept(),db) ;
                es.submit(t);
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
    }
}

