package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID>{

	protected abstract JpaRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T medico) throws Exception {
		return getRepo().save(medico);
	}

	@Override
	public T modificar(T medico) throws Exception {
		return getRepo().save(medico);
	}

	@Override
	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
		
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);		
	}
	
}
