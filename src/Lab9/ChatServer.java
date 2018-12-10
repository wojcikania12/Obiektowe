package Lab9;
import java.io.*;
import java.net.*;
import java.util.ArrayList;


public class ChatServer {


        private static ArrayList<String> nicknames = new ArrayList<>();
        private static ArrayList<PrintWriter> outs = new ArrayList<>();



        public static void main(String[] args) throws Exception {
            System.out.println("Server żyje.");
            ServerSocket listener = new ServerSocket(9001);
            try {
                while (true) {
                    new Handler(listener.accept()).start();
                }
            } finally {
                listener.close();
            }
        }


        private static class Handler extends Thread {
            private String name;
            private Socket socket;
            private BufferedReader in;
            private PrintWriter out;

            public Handler(Socket socket) {

                this.socket = socket;
            }

            public void run() {
                try {
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream());
                    name = in.readLine();
                    System.out.println(name);
                    nicknames.add(name);
                    outs.add(out);
                    for (PrintWriter writer : outs) {
                       writer.println("server : Witaj na czacie "+ name);
                    }

                    while (true) {
                        String input = in.readLine();
                        if (input == null) {
                            return;
                        }
                        for (PrintWriter writer : outs) {
                            writer.println( name + ": " + input);
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    if (name != null) {
                        nicknames.remove(name);
                    }
                    if (out != null) {
                       outs.remove(out);
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }


