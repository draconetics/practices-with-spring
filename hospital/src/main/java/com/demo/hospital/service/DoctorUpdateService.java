package com.demo.hospital.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hospital.dao.DoctorCommand;
import com.demo.hospital.model.Doctor;
import com.demo.hospital.repository.DoctorRepository;

@Service
public class DoctorUpdateService {
	
	private DoctorCommand doctorCommand;
	private Doctor doctor;
	private Long doctorId;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
    public void execute() {
        this.doctor = findAccount(doctorId);

        if (null != this.doctor) {
            updateDoctor(this.doctor);
            this.doctor = doctorRepository.save(this.doctor);
        }
    }

    private Doctor findAccount(Long accountId) {
        return doctorRepository.findById(accountId).orElse(null);
    }

    private void updateDoctor(Doctor doctor) {
    	doctor.setUpdatedOn(new Date());
        doctor.setFirstName(doctorCommand.getFirstName());
        doctor.setLastName(doctorCommand.getLastName());
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setDoctorCommand(DoctorCommand doctorCommand) {
        this.doctorCommand = doctorCommand;
    }

    public Doctor getDoctor() {
        return this.doctor;
    }
}

/*

	    private Long accountId;

	    private AccountInput input;

	    private Account account;

	    @Autowired
	    private AccountRepository repository;

	    public void execute() {
	        account = findAccount(accountId);

	        if (null != account) {
	            updateAccount(account);
	            account = repository.save(account);
	        }
	    }

	    private Account findAccount(Long accountId) {
	        return repository.findById(accountId).orElse(null);
	    }

	    private void updateAccount(Account account) {
	        account.setEmail(input.getEmail());
	        account.setState(AccountState.ACTIVATED);
	    }

	    public void setAccountId(Long accountId) {
	        this.accountId = accountId;
	    }

	    public void setInput(AccountInput input) {
	        this.input = input;
	    }

	    public Account getAccount() {
	        return account;
	    }
	
	*/
	

