package com.hugo.evoluum.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.repository.IbgeRepository;

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
	void test() {
		List<DadoFormatado> dados = inTest.findAll();
		assertNotNull(dados);
		assertNotEquals(0, dados.size());
	}

}
