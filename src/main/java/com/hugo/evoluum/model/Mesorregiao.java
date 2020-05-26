package com.hugo.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mesorregiao {

	private long id;
	private String nome;
	
	@JsonProperty(value = "UF")
	private UF uf;
	
	public Mesorregiao() {
		
	}
	
	public Mesorregiao(long id, String nome, UF uf) {
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
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
		Mesorregiao other = (Mesorregiao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mesorregiao [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", uf=");
		builder.append(uf);
		builder.append("]");
		return builder.toString();
	}
	
	
}
