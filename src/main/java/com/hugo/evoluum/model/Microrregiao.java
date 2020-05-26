package com.hugo.evoluum.model;

public class Microrregiao {

	private long id;
	private String nome;
	private Mesorregiao mesorregiao;

	public Microrregiao() {
		
	}
	
	public Microrregiao(long id, String nome, Mesorregiao mesorregiao) {
		this.id = id;
		this.nome = nome;
		this.mesorregiao = mesorregiao;
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

	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
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
		Microrregiao other = (Microrregiao) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Microrregiao [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", mesorregiao=");
		builder.append(mesorregiao);
		builder.append("]");
		return builder.toString();
	}
	
	
}
