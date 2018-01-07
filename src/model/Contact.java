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
    private String filename;

    public Contact (Properties record) {
		this.setName(record.getProperty("name"));
		this.setSurname(record.getProperty("surname"));
		this.setHomePhone(record.getProperty("home"));
		this.setOfficePhone(record.getProperty("office"));
		this.setCellPhone(record.getProperty("cellphone"));
		this.setEmail(record.getProperty("email"));
		this.setBirthday(record.getProperty("birthday"));
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