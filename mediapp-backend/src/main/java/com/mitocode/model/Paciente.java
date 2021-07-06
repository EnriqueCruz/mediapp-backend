package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

//@XmlRootElement
@Entity //(name = "PacienteET")
//@Table(name = "tbl_paciente", schema = "mi_esquema") 
public class Paciente {

	//JPQL -> SQL
	//SELECT * FROM PacienteET p;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@Size(min=3, message="Nombre debe ser de minimo 3")
	@Column(name = "nombres", nullable = false ,length = 70)	
	private String nombres;

	@Size(min=3, message="Apellido debe ser de minimo 3")
	@Column(name = "apellidos", nullable = false ,length = 70)
	private String apellidos;
	
	@Size(min=3, max=8, message="DNI debe ser de minimo 8")
	@Column(name = "dni", nullable = false ,length = 8, unique = true)
	private String dni;
	
	@Size(min=3, max=150,  message="Nombre debe ser de minimo 3")
	@Column(name = "direccion", nullable = true ,length = 150)
	private String direccion;
	
	@Size(min=9, max=9,  message="Nombre debe ser de minimo 3")
	@Size(min=3, message="Nombre debe ser de minimo 3")
	@Column(name = "telefono", nullable = true ,length = 9)
	private String telefono;
	
	@Email
	@Size(min=3, message="Nombre debe ser de minimo 3")
	@Column(name = "email", nullable = true ,length = 55)
	private String email;	

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	
	
}
