package com.example.ssi.model.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@ManyToOne Relation

@Entity
public class PcInternet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long PcId;
	private String codigo;
	private String descripcion;
	
	public PcInternet(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public Long getPcId() {
		return PcId;
	}
	public void setPcId(Long pcId) {
		PcId = pcId;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
