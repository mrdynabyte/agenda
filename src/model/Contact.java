package model;

import java.util.Properties;

public class Contact {
    private String name;
    private String surname;
    private String homePhone;
    private String cellPhone;
    private String officePhone;
    private String email;
    private String birthday;
    private String address;
    
    public Contact() {

    }

    public Contact (String[] record) {
        this.setName(record[0]);
		this.setSurname(record[1]);
		this.setHomePhone(record[2]);
		this.setOfficePhone(record[3]);
		this.setCellPhone(record[4]);
		this.setEmail(record[5]);
		this.setBirthday(record[6]);
		this.setAddress(record[7]);
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
    public void setAddress(String address) {
        this.address = address;
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
    public String getAddress() {
        return this.address;
    };
    public Properties toPropertiesObject() {
        Properties contact = new Properties();

        contact.setProperty("name", this.name);
        contact.setProperty("surname", this.surname);
        contact.setProperty("home", this.homePhone);
        contact.setProperty("office", this.officePhone);
        contact.setProperty("cellphone", this.cellPhone);
        contact.setProperty("email", this.email);
        contact.setProperty("birthday", this.birthday);
        contact.setProperty("address", this.address);

        return contact;
    }
}