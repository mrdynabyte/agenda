package view;

import java.io.FileReader;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.util.Properties;

public class AgendaMenu {
    private JMenuBar menubar;

    private JMenu fileMenu;
    private JMenu optionsMenu;
    private JMenu languageMenu;

    private JMenuItem fileOpen;
    private JMenuItem fileExit;
    private JMenuItem fileSaveAs;

    private JMenuItem frenchMenu;
    private JMenuItem englishMenu;
    private JMenuItem spanishMenu;
    private JMenuItem deutschMenu;

    private FileReader reader;
    private Properties properties;

    public AgendaMenu() {
        menubar = new JMenuBar();
        //menubar.setBounds(0,0, 950, 20);
        fileMenu = new JMenu("File");
        optionsMenu = new JMenu("Options");
        languageMenu = new JMenu("Language");
    

        fileOpen = new JMenuItem("Open");
        fileSaveAs = new JMenuItem("Save as...");
        fileExit = new JMenuItem("Exit");

        fileMenu.add(fileOpen);
        fileMenu.add(fileSaveAs);
        fileMenu.add(fileExit);
        
        optionsMenu.add(languageMenu);

        deutschMenu = new JMenuItem("Deutsch");        
        englishMenu = new JMenuItem("English");
        frenchMenu = new JMenuItem("French");
        spanishMenu = new JMenuItem("Spanish");
        
        languageMenu.add(deutschMenu);
        languageMenu.add(englishMenu);
        languageMenu.add(frenchMenu);
        languageMenu.add(spanishMenu);

        menubar.add(fileMenu);
        menubar.add(optionsMenu);

        menubar.setVisible(true);

        properties = new Properties();
        
        try {
            reader = new FileReader("agenda/src/assets/languages.dt");
            properties.load(reader);
            
        } catch (Exception e) {
            //TODO: handle exception

            System.out.println("Language file not found: " + e.getMessage());
        }


    }

    public JMenuBar getMenu(){
        return this.menubar;
    }

    public JMenuItem getFileOpen() {
        return this.fileOpen;
    }

    public JMenuItem getFileSaveAs() {
        return this.fileSaveAs;
    }

    public JMenuItem getFileExit() {
        return this.fileExit;
    }

    public JMenuItem getFrenchMenu(){
        return this.frenchMenu;
    }

    public JMenuItem getEnglishMenu(){
        return this.englishMenu;
    }

    public JMenuItem getSpanishMenu(){
        return this.spanishMenu;
    }

    public JMenuItem getDeutschMenu(){
        return this.deutschMenu;
    }    

    public String[] getLanguageProperties(String language){
        String[] labels = null;
        
        labels = properties.getProperty(language).split(",");

        return labels;
    }
}