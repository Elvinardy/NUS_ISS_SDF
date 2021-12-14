package sdf;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
public class Main {


    public static void main(String[] args) throws IOException {

        int port = 3000;
        String[] docRoot = {"static"};

        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

            if (args.length == 0) {
                return;
            }
            for (int i = 0; i < args.length; i+=2) {
                if (args[i].equals("--port")) {
                    port = Integer.parseInt(args[i + 1]);
    
                } else if (args[i].equals("--docRoot")) {
                    docRoot = args[i + 1].split(":");
                }
            }
            HttpServer server = new HttpServer(port, docRoot);
        
            server.start();
        }
      
    }



