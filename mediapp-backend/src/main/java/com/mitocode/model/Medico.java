package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Medico")
@Table(name="Medico")
public class Medico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMedico;
	@Column(name="nombres",nullable =false, length=70)
	private String nombres;
	@Column(name="apellidos",nullable =false, length=70)
	private String apellidos;
	@Column(name="cmp",nullable =false, length=12, unique=true)
	private String CMP;
	// En spring data cuando se usa una variable escrita en Camelcase, cada vez que encuentre una mayuscula colocara guion bajo
	@Column(name="foto_url",nullable =true)
	private String fotoUrl;
	
	public Integer getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCMP() {
		return CMP;
	}
	public void setCMP(String cMP) {
		CMP = cMP;
	}
	public String getFotoUrl() {
		return fotoUrl;
	}
	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}
	
	
	
}
