package com.hugo.evoluum.model;

public class UF {

	private long id;
	private String sigla;
	private String nome;
	private Regiao regiao;
	
	public UF() {
	
	}
	
	public UF(long id, String sigla, String nome, Regiao regiao) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UF [id=");
		builder.append(id);
		builder.append(", sigla=");
		builder.append(sigla);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", regiao=");
		builder.append(regiao);
		builder.append("]");
		return builder.toString();
	}
	
}
