package sdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.FileHandler;

public class HttpServer {
    
    private int port = 3000;
    private ServerSocket ss;
    private ExecutorService threadPool;
    private FileCheck fCheck;



    public HttpServer (int port, String[] docRoot) {
        this.port = port;
        this.fCheck = new FileCheck(docRoot);
    }

    public void start() {
        this.startServer();

        try {
            this.startServer();
        } catch (IOException e) {
            System.err.println("Socket not connected..");
            System.exit(1);
        }


    }
    private void launchServer() {
        try {
            this.ss = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to connect serversocket on port " + port);
            System.exit(1);
        }
    
        if (!this.fCheck.checkingDoc()) {
            System.err.println("Invalid directory found..");
            System.exit(1);
        }
    
        this.threadPool = Executors.newFixedThreadPool(3);
    }

    private void startServer() throws IOException {
        while(true) {
            Socket s = ss.accept();
            threadPool.submit(new HttpClientConnection(s,fCheck));
        }
    }
}

