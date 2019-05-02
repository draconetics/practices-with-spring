package com.example.ssi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Factory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFactory;
	private String organizationName;
	private String organizationCode;
	private String description;
	
    @OneToMany( targetEntity=Employee.class )
    private List<Employee> employeelist;
	

	
	public Factory() {}
	
	public Factory(Long idFactory, String organizationName, String organizationCode, String description,
			List<Employee> employeelist) {
		super();
		this.idFactory = idFactory;
		this.organizationName = organizationName;
		this.organizationCode = organizationCode;
		this.description = description;
		this.employeelist = employeelist;
	}

	public List<Employee> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public Long getIdFactory() {
		return idFactory;
	}
	public void setIdFactory(Long idFactory) {
		this.idFactory = idFactory;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
