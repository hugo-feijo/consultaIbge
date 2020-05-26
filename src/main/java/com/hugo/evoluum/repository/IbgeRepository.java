package com.hugo.evoluum.repository;

import java.util.Arrays;
import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.hugo.evoluum.model.Estado;
import com.hugo.evoluum.model.Municipio;

@Repository
public class IbgeRepository {
	
	RestTemplate restTemplate = new RestTemplate();

	public List<Estado> findAllEstados() {
		List<Estado> estados = Arrays.asList(restTemplate.getForObject(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados", Estado[].class));
		return estados;
	}
	
	public List<Municipio> findAllMunicipios(String UF) throws BadAttributeValueExpException {
		List<Municipio> municipios = Arrays.asList(restTemplate.getForObject(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + UF + "/municipios", Municipio[].class));
		
		if(municipios.isEmpty())
			throw new BadAttributeValueExpException("Estado inválido");
		else
			return municipios;
	}
}
