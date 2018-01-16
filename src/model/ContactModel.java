package model;

import java.util.Properties;

public class ContactModel {

    private static FileManager manager;

    public ContactModel() {
        manager = new FileManager();
    }

    public String[] getContactList() {
        
        String[] fileList = manager.fileList();
        String[] contacts = new String[fileList.length];

        for( int i= 0; i < contacts.length; i++ ) {
            contacts[i] = fileList[i].substring(0, fileList[i].length() - 3);
        }

        return contacts;
    }

    public  Contact getContact(String name) { 
        return new Contact(manager.getFileProperties(name + ".dt"));
    }

    public  void saveContact(Contact contact) {
        manager.saveFile(contact.toPropertiesObject());
    }

}