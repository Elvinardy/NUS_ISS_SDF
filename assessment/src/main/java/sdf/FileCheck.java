package sdf;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileCheck {
    private String[] docRoot;

    public FileCheck (String[] docRoot) {
        this.docRoot = docRoot;
    }

    public boolean checkingDoc() {

        for(String dir : docRoot) {
            Path pathDir = Paths.get(dir);
            if(!Files.isReadable(pathDir) || !Files.isDirectory(pathDir)) {
                return false;
            }
        }
        return true;
    }

    private String fileIndex (String fileName) {
        if (fileName.equals("/")) {
            return "/index.html";
        } else {
            return fileName;
        }
    }
 
    protected boolean pngFile (String fileName) {

        if (fileName.contains(".png")) {
            return true;
        }
       return false;
    }

    protected List<String> getContent (String fileName) {
        String html;
        List<String> content = new ArrayList<String>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            while ((html = br.readLine()) =! null) {
                content.add(html);
            }
            reader.close();

            } catch(IOException e) {
                System.err.println("An error occured when reading file..");
            }
            return content;
        }

        protected byte[] getPNG(String fileName) throws IOException {
            Path filePath = Paths.get(fileName);
            InputStream fileStreams = Files.newInputStream(filePath);
            return fileStreams.readAllBytes();
        }
    }
    

