package model;

import java.util.Enumeration;
import java.util.Properties;

public class ContactModel {

    private FileManager manager;

    public ContactModel() {
        manager = new FileManager();
    }

    public Contact[] getContactList() {
        
        Properties properties = manager.getFileProperties();
        Contact contacts[] = new Contact[properties.size()];
        Enumeration keys = properties.keys();
        String key, cString;
        int i = 0;

        while(keys.hasMoreElements()) {
            key         = keys.nextElement().toString();
            cString     = properties.getProperty(key);
            contacts[i] =  new Contact(cString.split(","), key);
            i++;
        }

        return contacts;
    }

    public  Contact getContact(String name) { 
        return new Contact();
    }

    public  void saveContact(Contact contact) {
        String cString = "";

        cString += contact.getName();
        cString += "," + contact.getSurname();
        cString += "," + contact.getHomePhone();
        cString += "," + contact.getOfficePhone();
        cString += "," + contact.getCellPhone();
        cString += "," + contact.getEmail();
        cString += "," + contact.getBirthday();
        cString += "," + contact.getAddress();

        manager.savePropertyOnFile(cString, contact.getKey());
    }

    public int getContactSize() {
        return manager.getFileProperties().size();
    }

    public void deleteContact(Contact contact) {
        manager.deletePropertyFromFile(contact.getKey());
    }

    public FileManager getFileManager() {
        return this.manager;
    }
}