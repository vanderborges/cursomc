package com.example.cursomc.domain.enums;

public enum TipoCliente {

	PESSOA_JURIDICA(1, "Pessoa Jurídica"),
	PESSOA_FISICA(2, "Pessoa Fisíca");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) return null;
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Codigo: "+cod+ " inválido!!");
	}
	
}
