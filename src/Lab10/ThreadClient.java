package Lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ThreadClient implements Runnable{
    Socket clientSocket = null;

    public ThreadClient(Socket s){
        clientSocket =s;
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