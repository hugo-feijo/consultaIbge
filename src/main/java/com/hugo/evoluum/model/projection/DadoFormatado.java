package com.hugo.evoluum.model.projection;

public class DadoFormatado {

	private long idEstado;
	private String siglaEstado;
	private String regiaoNome;
	private String nomeCidade;
	private String nomeMesorregiao;
	private String nomeFormatado;
	
	public DadoFormatado() {
		super();
	}
	
	public long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	public String getRegiaoNome() {
		return regiaoNome;
	}
	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}
	public void setNomeMesorregiao(String nomeMesorregiao) {
		this.nomeMesorregiao = nomeMesorregiao;
	}
	public String getNomeFormatado() {
		return nomeFormatado;
	}
	public void setNomeFormatado(String nomeFormatado) {
		this.nomeFormatado = nomeFormatado;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DadoFormatado [idEstado=");
		builder.append(idEstado);
		builder.append(", siglaEstado=");
		builder.append(siglaEstado);
		builder.append(", regiaoNome=");
		builder.append(regiaoNome);
		builder.append(", nomeCidade=");
		builder.append(nomeCidade);
		builder.append(", nomeMesorregiao=");
		builder.append(nomeMesorregiao);
		builder.append(", nomeFormatado=");
		builder.append(nomeFormatado);
		builder.append("]");
		return builder.toString();
	}
	
	
}
