package com.hugo.evoluum.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	
	private Regiao regiao;
	private UF uf;
	private Mesorregiao mesorregiao;
	private Microrregiao microrregiao;
	private Municipio municipio;
	
	@BeforeEach
	void setUp() {		
		regiao = new Regiao(3, "SE", "Sudeste");
		uf = new UF(35, "SP", "São Paulo", regiao);
		mesorregiao = new Mesorregiao(3508, "Presidente Prudente", uf);
		microrregiao = new Microrregiao(35035, "Adamantina", mesorregiao);
		municipio = new Municipio(3500105, "Adamantina", microrregiao);
	}
	
	@DisplayName("Projetar os dados corretamente")
	@Test
	void projetarDadosCorretamente() {
		
		DadoFormatado dado = ParseData.municipioToDados(municipio);
		
		assertEquals(dado.getNomeCidade(), municipio.getNome());
		assertEquals(dado.getIdEstado(), uf.getId());
		assertEquals(dado.getNomeMesorregiao(), mesorregiao.getNome());
		assertEquals(dado.getRegiaoNome(), regiao.getNome());
		assertEquals(dado.getSiglaEstado(), uf.getSigla());
		assertEquals("Adamantina/SP", dado.getNomeFormatado());
	}

	@DisplayName("Transformar dados para CSV")
	@Test
	void transformarDadosParaCsv() throws IOException {
		List<DadoFormatado> dados = new ArrayList<>();
		dados.add(ParseData.municipioToDados(municipio));
	}
}
