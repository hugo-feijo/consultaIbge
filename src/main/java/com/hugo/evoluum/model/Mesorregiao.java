package com.hugo.evoluum.model;

public class Mesorregiao {

	private long id;
	private String nome;
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
