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
