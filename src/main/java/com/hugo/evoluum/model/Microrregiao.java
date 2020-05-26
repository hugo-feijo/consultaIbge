package com.hugo.evoluum.model;

public class Microrregiao {

	private Long id;
	private String nome;
	private Mesorregiao mesorregiao;
	
	public Microrregiao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
