package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileManager {
    private static File manager;
    private static FileReader reader;
    private static Properties properties;

    public static String[] fileList() {
        manager = new File("agenda/src/assets/");
        return manager.list();
    }

    public static Properties getFileProperties(String filename) {
        properties = new Properties();
        
        try {
            reader = new FileReader(manager.getPath()+ "\\" + filename);  
            properties.load(reader);
        } catch (FileNotFoundException e) {
            //TODO: handle exception
            System.out.println("File:  "+ manager.getAbsolutePath() + filename + " was not found");
        } catch(IOException e) {
            System.out.println("There was a problem reading the contact file");            
        }

        return properties;
    }
}