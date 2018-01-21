package model;

import java.util.Properties;

public class ContactModel {

    private static FileManager manager;

    public ContactModel() {
        manager = new FileManager();
    }

    public Contact[] getContactList() {
        Properties properties = manager.getFileProperties();
        Contact contacts[] = new Contact[properties.size()];

        for( int i = 0; i < contacts.length; i++ ) {
            String cString = properties.getProperty(String.valueOf(i + 1));
            System.out.println(cString);
            contacts[i] =  new Contact(cString.split(","), String.valueOf(i +1));
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

        manager.saveOnFile(cString, contact.getKey());
    }

    public int getContactSize() {
        return manager.getFileProperties().size();
    }

}