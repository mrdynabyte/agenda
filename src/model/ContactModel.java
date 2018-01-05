package model;

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
        
        String[] tokens;
        String[] fileList = FileManager.fileList();
        String[] contacts = new String[fileList.length];

        for( int i= 0; i < contacts.length; i++ ) {
            tokens =  fileList[i].split("-");

            contacts[i] = tokens[0];
            contacts[i] += (tokens[1] != null) ? 
                                " " + tokens[1].substring(0, tokens[1].length() - 3) : 
                                "";
        }

        return contacts;
    }

    public static String getContact() { 
        return "";
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