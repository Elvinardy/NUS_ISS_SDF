package sdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;

public class HttpClientConnection {

    private final Socket s;
    private HttpWriter writer;
    private BufferedReader br;
    String line = "";

public HttpClientConnection (Socket s) {   //Constructor
    this.s = s;

}

public void run() {
  
}
private void startStream() {

try {
    writer = new HttpWriter(s.getOutputStream());
    br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    line = br.readLine();
    
} catch (IOException ioe) {
    System.out.println("Something went wrong..");
}



private String[] getFromBrowser() throws IOException {
    String line = br.readLine();
    String[] argsRequest = line.split(" ");
    return argsRequest;

}
// separate the request
public void checkRequest(String[] argsRequest) {
    String method = argsRequest[0];
    String link = argsRequest[1];

    if(!method.equals("GET")) {
        this.writer.writeString("405 Method not Allowed");
        return;
    }
    if(!Paths.get(link).toFile().exists()) {
        this.writer.writeString("404 not found..\n");
        this.writer.writeString(link + "not found");
        return;
    } else {
        String fileDir = file.Opt.get();
        if (fileHandler.isPNG(link)) {
            this.writePNG(filDir);
            return;
        }
        this.write(fileDir);
    }

}
// check if GET
// if not get, write 405

// get if file exists 
public void checkPath (String file) {
    
}
// if not write 404


//check if file is png

// return 200 OK
// return page or png





}

