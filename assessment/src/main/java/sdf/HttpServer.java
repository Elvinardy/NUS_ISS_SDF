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
    private FileHandler fh;



    public HttpServer (int port, String[] docRoot) {
        this.port = port;
        this.fh = new FilesHandler(docRoot);
    }

    public void start() {
        this.startServer();
        this.fileHandler = new FilesHandler
    }

    private void startServer() {
        try {
            this.ss = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Failed to connect serversocket on port " + port);
            System.exit(1);
        }
    
        if (!this.fileHandler.checkDocRoot()) {
            System.err.println("Invalid directory found..");
            System.exit(1);
        }
    
        this.threadPool = ExecutorService.newFixedThreadPool(3);
    }

    private void startServer() throws IOException (
        while(true) {
            Socket s = ServerSocket.accept();
            threadPool.submit(new HttpClientConnection(s,fh));
        }
    )

