package com.hugo.evoluum.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.BadAttributeValueExpException;

import com.hugo.evoluum.model.Estado;
import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.repository.IbgeRepository;
import com.hugo.evoluum.util.ParseData;

public class EndPointService {

	private IbgeRepository ibgeRepository;
	
	public EndPointService(IbgeRepository ibgeRepository) {
		this.ibgeRepository = ibgeRepository;
	}

	public List<DadoFormatado> findAll() {
		List<DadoFormatado> dados = new ArrayList<>();
		List<Municipio> municipios = new ArrayList<>();
		List<Estado> estados = ibgeRepository.findAllEstados();
		
		estados.forEach(estado -> {
			try {
				municipios.addAll(ibgeRepository.findAllMunicipios(estado.getSigla()));
			} catch (BadAttributeValueExpException e) {
				e.printStackTrace();
			}
		});
		
		municipios.forEach(municipio -> dados.add(ParseData.MunicipioToDados(municipio)));
		
		return dados;
	}
}
