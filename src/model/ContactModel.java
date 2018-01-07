package model;

import java.util.Properties;

public class ContactModel {
    private String name;
    private String surname;
    private String homePhone;
    private String cellPhone;
    private String officePhone;
    private String email;
    private String birthday;
    private String filename;
    
    public ContactModel() { 
    
    }

    public static String[] getContactList() {
        
        String[] fileList = FileManager.fileList();
        String[] contacts = new String[fileList.length];

        for( int i= 0; i < contacts.length; i++ ) {
            contacts[i] = fileList[i].substring(0, fileList[i].length() - 3);
        }

        return contacts;
    }

    public static Properties getContact(String name) { 
        return FileManager.getFileProperties(name + ".dt");
    }


    /* Setters */

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    };    

    /* Getters */
    
    public String getName() {
        return this.name;
    };
    public String getSurname() {
        return this.surname;
    };
    public String getHomePhone() {
        return this.homePhone;
    };
    public String getCellPhone() {
        return this.cellPhone;
    };
    public String getOfficePhone() {
        return this.officePhone;
    };
    public String getEmail() {
        return this.email;
    };
    public String getBirthday() {
        return this.birthday;
    };    

}