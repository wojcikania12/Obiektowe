package Lab10;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer extends Thread{
    static int numberOfThreads = 1;

    public static void main(String[] args)  throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            ExecutorService es = Executors.newFixedThreadPool(numberOfThreads);
            while(true){
                ThreadClient t=new ThreadClient(serverSocket.accept()) ;
                es.submit(t);
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
    }
}


