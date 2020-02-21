package com.vander.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vander.cursomc.domain.Categoria;
import com.vander.cursomc.repository.CategoriaRepository;
import com.vander.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);
		
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id: " +id+ ", do tipo: "+ Categoria.class.getName())); 
	}
}
