package com.example.ssi.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String password;
	
//	@OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "profileId")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
	private Profile profile;
	
	
	
	public User(String name, String password, Profile profile) {
		super();
		this.name = name;
		this.password = password;
		this.profile = profile;
		this.profile.setUser(this);
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
}
