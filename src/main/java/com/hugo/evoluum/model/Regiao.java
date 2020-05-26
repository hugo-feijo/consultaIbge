package com.hugo.evoluum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Regiao {

	private long id;

	private String sigla;

	private String nome;
	
	public Regiao() {
		
	}
	
	public Regiao(long id, String sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regiao other = (Regiao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Regiao [id=");
		builder.append(id);
		builder.append(", sigla=");
		builder.append(sigla);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
	
}
