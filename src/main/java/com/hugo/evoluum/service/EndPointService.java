package com.hugo.evoluum.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.management.BadAttributeValueExpException;

import org.springframework.stereotype.Service;

import com.hugo.evoluum.model.Estado;
import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.repository.IbgeRepository;
import com.hugo.evoluum.util.ParseData;

@Service
public class EndPointService {

	Logger LOG = Logger.getLogger(EndPointService.class.getName());
	
	private IbgeRepository ibgeRepository;
	
	public EndPointService(IbgeRepository ibgeRepository) {
		LOG.info("... Criando instancia de EndPointService");
		this.ibgeRepository = ibgeRepository;
	}

	public List<DadoFormatado> findAll() {
		List<DadoFormatado> dados = new ArrayList<>();
		List<Estado> estados = ibgeRepository.findAllEstados();
		List<Municipio> municipios = new ArrayList<>();
		
		estados
			.parallelStream()
			.forEach(
					estado -> {
						try {
							municipios.addAll(ibgeRepository.findAllMunicipios(estado.getSigla()));
						} catch (BadAttributeValueExpException e) {
							e.printStackTrace();
						}
				
					});
		
		municipios.forEach(municipio -> dados.add(ParseData.municipioToDados(municipio)));
		
		LOG.info("... Retornando dados formatados do EndPointService");
		return dados;
	}

	public DadoFormatado findByNomeCidade(String nomeCidade) {
		LOG.info("... Procurando em EndPointService cidade com o nome: " + nomeCidade);
		DadoFormatado dado;
		List<Estado> estados = ibgeRepository.findAllEstados();
		List<Municipio> municipios = new ArrayList<>();
		
		for(int i=0; i<estados.size(); i++) {
			try {
				municipios = ibgeRepository.findAllMunicipios(estados.get(i).getSigla());
				
				municipios.removeIf(d -> !nomeCidade.equalsIgnoreCase(d.getNome()));
				
				if(!municipios.isEmpty())
					break;
			} catch (BadAttributeValueExpException e) {
				e.printStackTrace();
			}
		}
		
		dado = ParseData.municipioToDados(municipios.get(0));
			
		return dado;
	}
}
