package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity(name="Consulta_Examen")
@Table(name="Consulta_Examen")
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

	@Id
	private Consulta idConsulta;
	
	@Id
	private Examen idExamen;
	
}
