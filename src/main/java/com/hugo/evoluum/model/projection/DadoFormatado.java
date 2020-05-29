package com.hugo.evoluum.model.projection;

import io.swagger.annotations.ApiModelProperty;

public class DadoFormatado {

	@ApiModelProperty(value = "Código da estados")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEstado ^ (idEstado >>> 32));
		result = prime * result + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
		result = prime * result + ((nomeFormatado == null) ? 0 : nomeFormatado.hashCode());
		result = prime * result + ((nomeMesorregiao == null) ? 0 : nomeMesorregiao.hashCode());
		result = prime * result + ((regiaoNome == null) ? 0 : regiaoNome.hashCode());
		result = prime * result + ((siglaEstado == null) ? 0 : siglaEstado.hashCode());
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
		DadoFormatado other = (DadoFormatado) obj;
		if (idEstado != other.idEstado)
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		if (nomeFormatado == null) {
			if (other.nomeFormatado != null)
				return false;
		} else if (!nomeFormatado.equals(other.nomeFormatado))
			return false;
		if (nomeMesorregiao == null) {
			if (other.nomeMesorregiao != null)
				return false;
		} else if (!nomeMesorregiao.equals(other.nomeMesorregiao))
			return false;
		if (regiaoNome == null) {
			if (other.regiaoNome != null)
				return false;
		} else if (!regiaoNome.equals(other.regiaoNome))
			return false;
		if (siglaEstado == null) {
			if (other.siglaEstado != null)
				return false;
		} else if (!siglaEstado.equals(other.siglaEstado))
			return false;
		return true;
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
