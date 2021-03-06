package com.mitocode.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService service;
	
	@GetMapping
	public ResponseEntity<List<Paciente>>  listar() throws Exception{
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> listarPorId(@Valid @PathVariable("id") Integer id) throws Exception{
		Paciente obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("Paciente no encontrado");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente) throws Exception {
		return new ResponseEntity<>(service.registrar(paciente),HttpStatus.CREATED);		
	}
	
	@PutMapping
	public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente paciente) throws Exception {
		return new ResponseEntity<>(service.modificar(paciente), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		service.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	
}
