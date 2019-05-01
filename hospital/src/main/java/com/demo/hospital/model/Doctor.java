package com.demo.hospital.model;


import javax.persistence.*;

import org.hibernate.validator.internal.util.Contracts;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor extends ModelBase {

	
	
    private String firstName;
    private String lastName;
    
    @Lob
    private Byte[] image;
  //  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
  //  private List<Object> contracts = new ArrayList<>();

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

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}

/*
    public List<C> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }*/
