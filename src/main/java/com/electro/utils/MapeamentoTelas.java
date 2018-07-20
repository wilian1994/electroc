package com.electro.utils;

public enum MapeamentoTelas {
	
	ESTOQUE ("estoque/form_estoque"),
	LISTA_ESTOQUE ("estoque/lista_estoque"),
	RECEBIMENTO ("estoque/form_recebimento"),
	NOTA ("estoque/form_nota");
	
	String path;
	
	private MapeamentoTelas(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
		

}
