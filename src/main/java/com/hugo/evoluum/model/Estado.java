package com.hugo.evoluum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Estado {
	
	private long id;
	private String sigla;
	private Regiao regiao;
	
	public Estado() {
		
	}

	public Estado(long id, String sigla, Regiao regiao) {
		this.id = id;
		this.sigla = sigla;
		this.regiao = regiao;
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
		Estado other = (Estado) obj;
		if (id != other.id)
			return false;
		return true;
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
