package com.demo.hospital.dao;

import javax.persistence.Lob;

import com.demo.hospital.model.Doctor;
import com.demo.hospital.model.ModelBase;


public class DoctorCommand extends ModelBase{
	
	private String firstName;
    private String lastName;
    
    public DoctorCommand() {}
    
    public DoctorCommand (Doctor newDoctor) {
    	
 
        setId(newDoctor.getId());
        setVersion(newDoctor.getVersion());
        setCreatedOn(newDoctor.getCreatedOn());
        setUpdatedOn(newDoctor.getUpdatedOn());
        
        firstName = newDoctor.getFirstName();
        lastName = newDoctor.getLastName();
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
