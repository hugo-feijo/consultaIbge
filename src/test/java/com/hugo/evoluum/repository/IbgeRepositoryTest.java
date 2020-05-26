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
import com.hugo.evoluum.model.Mesorregiao;
import com.hugo.evoluum.model.Microrregiao;
import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.Regiao;
import com.hugo.evoluum.model.UF;

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
		Regiao regiao = new Regiao(3, "SE", "Sudeste");
		UF uf = new UF(35, "SP", "São Paulo", regiao);
		Mesorregiao mesorregiao = new Mesorregiao(3508, "Presidente Prudente", uf);
		Microrregiao microrregiao = new Microrregiao(35035, "Adamantina", mesorregiao);
		Municipio municipio = new Municipio(3500105, "Adamantina", microrregiao);
		
		String UF = "sp";
		List<Municipio> municipios = inTest.findAllMunicipios(UF);

		assertNotNull(municipios);
		assertEquals(municipio, municipios.get(0));
		assertEquals(municipio.getMicrorregiao(), municipios.get(0).getMicrorregiao());
		assertEquals(municipio.getMicrorregiao().getMesorregiao(), municipios.get(0).getMicrorregiao().getMesorregiao());
		assertEquals(municipio.getMicrorregiao().getMesorregiao().getUf(), 
				municipios.get(0).getMicrorregiao().getMesorregiao().getUf());
	}
	
	@Test
	@DisplayName("Lançar uma exceção caso for informado um estado invalido")
	void lancarExcecaoParaEstadoInvalido() throws BadAttributeValueExpException {
		String UF = "tt";
		assertThrows(BadAttributeValueExpException.class, () -> inTest.findAllMunicipios(UF));
	}

}
