package master;

import java.io.FileInputStream;
import java.io.InputStream;

//minim loader 
//referenced week11-lab-basecode
public class MinimHelper {

    public String sketchPath(String fileName) {
        return "sounds/"+fileName;
    }

    public InputStream createInput(String fileName) {
        InputStream stream=null;
        try{
        	stream=new FileInputStream(sketchPath(fileName));
        }
        catch(Exception e){
            System.out.println("something might be wrong with the sound file");
        }
        return stream;
    }
}