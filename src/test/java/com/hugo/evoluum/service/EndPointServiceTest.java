package com.hugo.evoluum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import com.hugo.evoluum.repository.IbgeRepository;
import com.hugo.evoluum.util.ParseData;

@DisplayName("EndPoint Service Deveria")
class EndPointServiceTest {

	private EndPointService inTest;
	
	private IbgeRepository ibgeRepository;
	
	@BeforeEach
	void setUp() {
		ibgeRepository = new IbgeRepository();
		inTest = new EndPointService(ibgeRepository);
	}
	
	@DisplayName("Retornar todos os dados corretamente")
	@Test
	void retornarTodosOsDadosCorretamente() {
		List<DadoFormatado> dados = inTest.findAll();
		assertNotNull(dados);
		assertNotEquals(0, dados.size());
	}
	
	@DisplayName("Retornar a cidade corretamente")
	@Test
	void retornarDadosDaCidadeCorreta() {
		Regiao regiao = new Regiao(3, "SE", "Sudeste");
		UF uf = new UF(35, "SP", "São Paulo", regiao);
		Mesorregiao mesorregiao = new Mesorregiao(3508, "Presidente Prudente", uf);
		Microrregiao microrregiao = new Microrregiao(35035, "Adamantina", mesorregiao);
		Municipio municipio = new Municipio(3500105, "Adamantina", microrregiao);
		DadoFormatado dadoCorreto = ParseData.municipioToDados(municipio);
		
		DadoFormatado dadoEndPoint = inTest.findByNomeCidade("Adamantina");
		
		assertEquals(dadoCorreto, dadoEndPoint);
	}
	
	@SuppressWarnings("unused")
	@DisplayName("Retornar cache local para busca da mesma cidade")
	@Test 
	void retornarCacheParaBuscaDaMesmaCidade() {
		Long start = System.currentTimeMillis();
		DadoFormatado dadoEndPoint = inTest.findByNomeCidade("Adamantina");
		Long duracaoPrimeiroTeste = System.currentTimeMillis() - start;

		start = System.currentTimeMillis();
		dadoEndPoint = inTest.findByNomeCidade("Adamantina");
		Long duracaoSegundoTeste = System.currentTimeMillis() - start;
	
		assertTrue(duracaoSegundoTeste< (duracaoPrimeiroTeste/2));
	}

}
