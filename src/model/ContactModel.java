package model;

import java.util.Properties;

public class ContactModel {

    private static FileManager manager;

    public ContactModel() {
        manager = new FileManager();
    }

    public Contact[] getContactList() {
        Properties properties = manager.getFileProperties();
        String[]   strings   = properties.values().toArray(new String[properties.size()]);
        Contact contacts[] = new Contact[strings.length];

        for( int i= 0; i < contacts.length; i++ ) {
            
            contacts[i] =  new Contact(strings[i].split(","));

        }

        return contacts;
    }

    public  Contact getContact(String name) { 
        return new Contact();
    }

    public  void saveContact(Contact contact) {
        manager.saveFile(contact.toPropertiesObject());
    }

}