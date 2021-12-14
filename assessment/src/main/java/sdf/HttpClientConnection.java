package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class HttpClientConnection {

    private final Socket s;
    private HttpWriter writer;
    private BufferedReader br;
    private FileCheck file;
    String line = "";
    String[] docRoot;

public HttpClientConnection (Socket s, FileCheck fCheck) {   //Constructor
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
        s.close();
        return;
    }

   
    for(String str : docRoot) {
        String fileDir = s + argsRequest[1];
        Path path1 = Paths.get(fileDir);
        File file1 = path1.toFile();
        

    if(!Paths.get(link).toFile().exists()) {
        this.writer.writeString("404 not found..\n");
        this.writer.writeString(link + " not found");
        s.close();
        return;
    } 
        if (Paths.get(file1).contains("png")) {
            this.writer.writeString("HTTP:/1.1 200 Ok \n");
            this.writer.writeString("Content-Type: iamge/png \n");
            this.writer.writeString();
            this.writer.writeBytes();

            s.close();
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

