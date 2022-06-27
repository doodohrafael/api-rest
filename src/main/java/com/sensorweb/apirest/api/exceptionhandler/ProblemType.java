package com.sensorweb.apirest.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	ERRO_DE_SISTEMA("/erro_de_sistema", "Erro de sistema"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado");
	
	private String uri;
	private String title;
	
	
	private ProblemType(String path, String title) {
		uri = "https://sensorweb.com.br" + path;
		this.title = title;
	}

}
