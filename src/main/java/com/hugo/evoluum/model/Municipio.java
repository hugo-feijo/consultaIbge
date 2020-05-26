package com.hugo.evoluum.model;

public class Municipio {

	private long id;
	private String nome;
	private Microrregiao microrregiao;
	
	public Municipio() {

	}
	
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
