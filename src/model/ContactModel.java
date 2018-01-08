package model;

import java.util.Properties;

public class ContactModel {

    public static String[] getContactList() {
        
        String[] fileList = FileManager.fileList();
        String[] contacts = new String[fileList.length];

        for( int i= 0; i < contacts.length; i++ ) {
            contacts[i] = fileList[i].substring(0, fileList[i].length() - 3);
        }

        return contacts;
    }

    public static Contact getContact(String name) { 
        return new Contact(FileManager.getFileProperties(name + ".dt"));
    }

    public static void saveContact(Contact contact) {
        FileManager.saveFile(contact.toPropertiesObject());
    }

}