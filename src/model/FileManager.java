package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class FileManager {
    private File manager;
    private FileReader reader;
    private FileWriter writer;
    private Properties properties;
    private JFileChooser chooser;
    private JDialog dialog;
    private String preferences = "agenda/src/assets/preferences.dt";
    
    public FileManager() {
        dialog = new JDialog();
        chooser = new JFileChooser();
        properties = new Properties();

        loadPreferences();
    }

    public  String[] fileList() {
        return this.manager.list();
    }

    public  Properties getFileProperties() {
        return this.properties;
    }

    public void savePropertyOnFile(String cString, String key) {
        this.properties.setProperty(key, cString);
        writeToFile();
    } 

    public void deletePropertyFromFile(String key) {
        this.properties.remove(key);
        writeToFile();
    }

    private boolean loadFile(String path) {
        boolean loaded = false;
        System.out.println("Loading file: " + path);
        try {
            this.manager = new File(path);        
            this.reader  = new FileReader(this.manager.getAbsolutePath());
            this.properties = new Properties();
            this.properties.load(reader);
            loaded = true;
        } catch (FileNotFoundException e) {
            System.out.println("File:  "+ this.manager.getAbsolutePath() + " was not found");
        } catch(IOException e) {
            System.out.println("There was a problem reading the contact file");            
        }
        return loaded;
    }

    private void writeToFile(){
        try {
            writer = new FileWriter(this.manager.getAbsolutePath());
            this.properties.store(writer, "");
        } catch (IOException e) {
            System.out.println("There was a problem reading the contact file");
        } catch (Exception e) {
            System.out.println("Exception while writing contact file: " + e.getMessage());
        }        
    }

    public void loadPreferences() {
        String filename;
        if(loadFile(this.preferences)) {
            filename = this.properties.get("filename").toString();
            if(!loadFile(filename)) {
                launchDirectoryChooser(false);
            }
        }
        else{
            this.properties.setProperty("filename", "");
            writeToFile();
            launchDirectoryChooser(false);
        }
        System.out.println("Loaded agenda: " + this.manager.getAbsolutePath());
    }

    public void setToPreferenceFile() {
        loadFile(this.preferences);
    }

	public void launchDirectoryChooser(boolean save) {
        
		chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose agenda directory...");
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setBounds(450, 150, 250, 150);
        chooser.setVisible(true);

        if(save)
            launchSaveDialog();
        else
            launchLoadDialog();

    }
    
    private void launchSaveDialog() {
        chooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
        if (chooser.showSaveDialog(dialog) == JFileChooser.APPROVE_OPTION) { 
            Properties data = properties;

            this.setToPreferenceFile();
            
            properties.setProperty("filename", chooser.getSelectedFile().getAbsolutePath());
            
            this.writeToFile();
            
            loadFile(chooser.getSelectedFile().getAbsolutePath());

            properties = data;

            this.writeToFile();
        }
        else {
            System.out.println("No Selection ");
        }
    }

    private void launchLoadDialog() {
        chooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
        if (chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION) { 
            properties.setProperty("filename", chooser.getSelectedFile().getAbsolutePath());
            writeToFile();
            loadFile(chooser.getSelectedFile().getAbsolutePath());
        }
        else {
            System.out.println("No Selection ");
            launchDirectoryChooser(false);
        }  
    }
}

