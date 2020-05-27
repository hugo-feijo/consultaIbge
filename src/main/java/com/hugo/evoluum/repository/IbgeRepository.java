package com.hugo.evoluum.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.management.BadAttributeValueExpException;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.hugo.evoluum.model.Estado;
import com.hugo.evoluum.model.Municipio;

@Repository
public class IbgeRepository {
	
	Logger LOG = Logger.getLogger(IbgeRepository.class.getName());
	
	RestTemplate restTemplate = new RestTemplate();

	public List<Estado> findAllEstados() {
		LOG.info("... Buscando estados por meio do IbgeRepository");
		
		List<Estado> estados = Arrays.asList(restTemplate.getForObject(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados", Estado[].class));
		
		return estados;
	}
	
	public List<Municipio> findAllMunicipios(String UF) throws BadAttributeValueExpException {
		LOG.info("... Buscando municipios do estado: " + UF);
		List<Municipio> municipios = new ArrayList<>();
		
		municipios = Arrays.asList(restTemplate.getForObject(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + UF + "/municipios", Municipio[].class));
		
		if(municipios.isEmpty()) {
			LOG.info("... O estado informado: " + UF + "é inválido!");
			throw new BadAttributeValueExpException("Estado inválido");
		}
		else
			return municipios;
	}
}
