package com.hugo.evoluum.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hugo.evoluum.model.Mesorregiao;
import com.hugo.evoluum.model.Microrregiao;
import com.hugo.evoluum.model.Municipio;
import com.hugo.evoluum.model.Regiao;
import com.hugo.evoluum.model.UF;
import com.hugo.evoluum.model.projection.DadoFormatado;

@DisplayName("Parse Data deveria ")
class ParseDataTest {

	private ParseData inTest;
	
	@BeforeEach
	void setUp() {
		inTest = new ParseData();
	}
	
	@DisplayName("Projetar os dados corretamente")
	@Test
	void projetarDadosCorretamente() {
		Regiao regiao = new Regiao(3, "SE", "Sudeste");
		UF uf = new UF(35, "SP", "São Paulo", regiao);
		Mesorregiao mesorregiao = new Mesorregiao(3508, "Presidente Prudente", uf);
		Microrregiao microrregiao = new Microrregiao(35035, "Adamantina", mesorregiao);
		Municipio municipio = new Municipio(3500105, "Adamantina", microrregiao);
		
		DadoFormatado dado = inTest.MunicipioToDados(municipio);
		
		assertEquals(dado.getNomeCidade(), municipio.getNome());
		assertEquals(dado.getIdEstado(), uf.getId());
		assertEquals(dado.getNomeMesorregiao(), mesorregiao.getNome());
		assertEquals(dado.getRegiaoNome(), regiao.getNome());
		assertEquals(dado.getSiglaEstado(), uf.getSigla());
		assertEquals("Adamantina/SP", dado.getNomeFormatado());
	}

}
