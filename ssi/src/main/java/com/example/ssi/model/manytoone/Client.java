package com.example.ssi.model.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




//@ManyToOne Relation

@Entity
public class Client {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 	
		private Long idClient;
		private String name;
		private String lastName;
		
		 @ManyToOne
		 private PcInternet pcInternet;
		
		 
		
		public Client(String name, String lastName, PcInternet pc) {
			super();
			this.name = name;
			this.lastName = lastName;
			this.pcInternet = pc;
		}
		
		public Long getIdClient() {
			return idClient;
		}
		public void setIdClient(Long idClient) {
			this.idClient = idClient;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public PcInternet getPc() {
			return pcInternet;
		}
		public void setPc(PcInternet pc) {
			this.pcInternet = pc;
		}
		
		
		
}
