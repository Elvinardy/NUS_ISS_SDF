package sdf;

import java.net.Socket;
import java.net.ServerSocket;
public class Main {

    public static void main(String[] args) throws IO {

        int port = 3000;
        String[] docRoot;

        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();

       if(args.length == 2) {
           port = Integer.parseInt(args[1]);
       } else if (args[0] = "--docRoot") {
           docRoot = args[1].split(":");
       }
       else {
           System.out.println("Server listening to port 3000...");
       }



        server.start();
    
    }

    private void receiver (String[] args) {
        for (int i);
}
