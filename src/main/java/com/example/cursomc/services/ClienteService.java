package com.example.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.cursomc.domain.Cliente;
import com.example.cursomc.dto.ClienteDto;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.services.exceptions.DataIntegretyException;
import com.example.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado: " + id
				+ ", Tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente update(Cliente obj) {
		Cliente objNew = find(obj.getId());
		updateData(objNew, obj);
		return repo.save(objNew);
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("Não é possivel excluir uma Cliente");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO (ClienteDto objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente objNew, Cliente obj) {
		objNew.setNome(obj.getNome());
		objNew.setEmail(obj.getEmail());
	}
	
}
