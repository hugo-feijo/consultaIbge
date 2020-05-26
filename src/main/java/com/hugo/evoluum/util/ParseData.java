package com.hugo.evoluum.util;

import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.projection.DadoFormatado;

public class ParseData {

	public DadoFormatado MunicipioToDados(Municipio municipio) {
		DadoFormatado dados = new DadoFormatado();

		dados.setNomeMesorregiao(municipio.getMicrorregiao().getMesorregiao().getNome());
		dados.setIdEstado(municipio.getMicrorregiao().getMesorregiao().getUf().getId());
		dados.setSiglaEstado(municipio.getMicrorregiao().getMesorregiao().getUf().getSigla());
		dados.setRegiaoNome(municipio.getMicrorregiao().getMesorregiao().getUf().getRegiao().getNome());
		dados.setNomeCidade(municipio.getNome());
		
		dados.setNomeFormatado(dados.getNomeCidade() + "/" + dados.getSiglaEstado());
		
		return dados;
	}

}
