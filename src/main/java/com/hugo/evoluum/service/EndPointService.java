package com.hugo.evoluum.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.management.BadAttributeValueExpException;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hugo.evoluum.model.Estado;
import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.repository.IbgeRepository;
import com.hugo.evoluum.util.ParseData;

@Service
public class EndPointService {

	Logger LOG = Logger.getLogger(EndPointService.class.getName());
	
	private static List<Municipio> municipios = new ArrayList<>();
	private static List<DadoFormatado> dados = new ArrayList<>();
	private IbgeRepository ibgeRepository;
	
	public EndPointService(IbgeRepository ibgeRepository) {
		LOG.info("... Criando instancia de EndPointService");
		this.ibgeRepository = ibgeRepository;
	}

	public List<DadoFormatado> findAll() {

		if(municipios.isEmpty())
			findAllMunicipios();
		
		if(dados.isEmpty())
			municipios.forEach(municipio -> dados.add(ParseData.municipioToDados(municipio)));
		
		LOG.info("... Retornando dados formatados do EndPointService");
		return dados;
	}
	@Cacheable("municipioByNomeCidade")
	private void findAllMunicipios() {
		List<Estado> estados = ibgeRepository.findAllEstados();
		
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
	}

	@Cacheable("municipioByNomeCidade")
	public DadoFormatado findByNomeCidade(String nomeCidade) {
		LOG.info("... Procurando em EndPointService cidade com o nome: " + nomeCidade);
		DadoFormatado dado;
		List<Municipio> municipiosFilter = new ArrayList<>();

		if(municipios.isEmpty())
			findAllMunicipios();
		
		municipiosFilter.addAll(municipios);
		municipiosFilter.removeIf(d -> !nomeCidade.equalsIgnoreCase(d.getNome()));
		
		dado = ParseData.municipioToDados(municipiosFilter.get(0));
			
		return dado;
	}
}
