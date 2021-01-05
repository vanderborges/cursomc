package com.example.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.example.cursomc.domain.Categoria;

public class CategoriaDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@javax.validation.constraints.NotEmpty(message = "Preenchumento obrigatório")
	@Length(min = 5, max = 80, message = "O tamanho dever ser entre 5 a 80 caractéres")
	private String nome;
	
	public CategoriaDto() {
	}
	
	public CategoriaDto(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
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
	
}
