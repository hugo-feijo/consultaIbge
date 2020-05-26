package com.hugo.evoluum.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import javax.management.BadAttributeValueExpException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hugo.evoluum.model.Estado;
import com.hugo.evoluum.model.Municipio;

@DisplayName("IBGE Repository deveria ")
class IbgeRepositoryTest {

	private IbgeRepository inTest;
	
	@BeforeEach
	void setUp() {
		inTest = new IbgeRepository();
	}
	
	@Test
	@DisplayName("Retornar a quantidade correta de estados")
	void retornarQuantidadeCorretaDeEstados() {
		List<Estado> estados = inTest.findAllEstados();
	
		assertEquals(27, estados.size());
	}
	
	@Test
	@DisplayName("Retornar algum dado quando chamada a endpoint dos municipios")
	void retornarUmObjetoNaoNulo() throws BadAttributeValueExpException {
		String UF = "mt";
		List<Municipio> municipios = inTest.findAllMunicipios(UF);
		assertNotNull(municipios);
	}
	
	@Test
	@DisplayName("Lançar uma exceção caso for informado um estado invalido")
	void lancarExcecaoParaEstadoInvalido() throws BadAttributeValueExpException {
		String UF = "tt";
		assertThrows(BadAttributeValueExpException.class, () -> inTest.findAllMunicipios(UF));
	}

}
