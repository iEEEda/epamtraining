package kz.eduard.exceptiontask.action;

import kz.eduard.exceptiontask.exception.FileException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile{

    private StringBuilder text;

    public ReadFile(String path)throws FileException {

        text = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(path);
            int c = fileReader.read();
            while(c != -1){
                text.append((char)c);
                c = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText(){
        return text.toString();
    }
}
