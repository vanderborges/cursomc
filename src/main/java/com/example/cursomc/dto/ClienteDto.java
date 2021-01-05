package com.example.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.cursomc.domain.Cliente;

public class ClienteDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "O nome não pode ser vazio")
	@Length(min = 4, max = 30, message = "E-mail deve ter entre 4 a 30 caracteres")
	private String nome;
	@NotEmpty(message = "O nome não pode ser vazio")
	@Email(message = "Tem que ser um e-mail valido")
	private String email;
	
	public ClienteDto() {
	}
	
	public ClienteDto(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
