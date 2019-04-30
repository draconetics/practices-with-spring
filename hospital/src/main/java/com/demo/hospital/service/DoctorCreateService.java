package com.demo.hospital.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospital.dao.DoctorCommand;
import com.demo.hospital.model.Doctor;
import com.demo.hospital.repository.DoctorRepository;


@Service
public class DoctorCreateService {
	
	private DoctorCommand doctorCommand;
	private Doctor doctor;

	@Autowired
	private DoctorRepository doctorRepository;
	
	public DoctorRepository getDoctorRepository() {
		return doctorRepository;
	}
	
    public void execute(){
    	Doctor instance = composeDoctorInstance();
    	System.out.println(instance.getCreatedOn());
    	this.doctor = doctorRepository.save(instance);
    }

    private Doctor composeDoctorInstance() {
    	Doctor instance = new Doctor();
    	instance.setCreatedOn(new Date());
    	instance.setFirstName(this.doctorCommand.getFirstName());
    	instance.setLastName(this.doctorCommand.getLastName());
    	return instance;
    }


    public void setInput(DoctorCommand doctorCommand) {
        this.doctorCommand = doctorCommand;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
    
}
