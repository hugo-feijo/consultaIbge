package com.hugo.evoluum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Estado {
	
	private Long id;
	private String sigla;
	private Regiao regiao;
	
	public Estado() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estados [id=");
		builder.append(id);
		builder.append(", sigla=");
		builder.append(sigla);
		builder.append(", regiao=");
		builder.append(regiao);
		builder.append("]");
		return builder.toString();
	}
	
	
}