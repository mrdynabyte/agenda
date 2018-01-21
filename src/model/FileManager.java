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

    public FileManager() {
        dialog = new JDialog();
        chooser = new JFileChooser();
		launchDirectoryChooser();
    }

    public  String[] fileList() {
        return manager.list();
    }

    public  Properties getFileProperties() {
        properties = new Properties();
        try {
            reader = new FileReader(manager.getAbsolutePath());  
            properties.load(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File:  "+ manager.getAbsolutePath() + " was not found");
        } catch(IOException e) {
            System.out.println("There was a problem reading the contact file");            
        }

        return properties;
    }

    public void saveOnFile(String cString, String key) {
        
        try {
            writer = new FileWriter(manager.getAbsolutePath());
            
            if(properties.size() < Integer.parseInt(key)) {                
                properties.put(key, cString);

            } else {
                properties.setProperty(key, cString);
            }

            properties.store(writer, "");

        } catch (IOException e) {
            System.out.println("There was a problem reading the contact file");
        } catch (Exception e) {
            System.out.println("Exception while writing contact file: " + e.getMessage());
        }

    } 

	private void launchDirectoryChooser () {

		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Choose agenda directory");
		//chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setBounds(450, 150, 250, 150);
        chooser.setVisible(true);
        
		if (chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION) { 
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
               
            this.manager = chooser.getSelectedFile();

            System.out.println("Manager: " + manager.getAbsolutePath());
		}
		else {
			System.out.println("No Selection ");
		}
	}    
}

