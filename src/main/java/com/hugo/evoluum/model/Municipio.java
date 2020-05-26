package com.hugo.evoluum.model;

public class Municipio {

	private long id;
	private String nome;
	private Microrregiao microrregiao;
	
	public Municipio(long id, String nome, Microrregiao microrregiao) {
		this.id = id;
		this.nome = nome;
		this.microrregiao = microrregiao;
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
	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}
	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
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
		Municipio other = (Municipio) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Municipio [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", microrregiao=");
		builder.append(microrregiao);
		builder.append("]");
		return builder.toString();
	}
	
	
}
