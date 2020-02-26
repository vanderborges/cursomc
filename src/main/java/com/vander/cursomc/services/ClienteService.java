package com.vander.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vander.cursomc.domain.Cliente;
import com.vander.cursomc.repository.ClienteRepository;
import com.vander.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id: " +id+ ", do tipo: "+ Cliente.class.getName())); 
	}
}
