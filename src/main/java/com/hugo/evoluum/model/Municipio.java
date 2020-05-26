package com.hugo.evoluum.model;

public class Municipio {

	private Long id;
	private String nome;
	private Microrregiao microrregiao;
	public Municipio() {
		super();
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
