package com.hugo.evoluum.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.service.EndPointService;

@RunWith(SpringRunner.class)
@WebMvcTest(EndPointResource.class)
@DisplayName("EndPoint Resource deveria ")
class EndPointResourceTest {

	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private EndPointService endPointService;
	
	@DisplayName("Retornar o arquivo JSON no endPoint /json")
	@Test
	void retornarJson() throws Exception {
		DadoFormatado dado = new DadoFormatado();
		dado.setIdEstado(35);
		dado.setNomeCidade("Adamantina");
		dado.setNomeFormatado("Adamantina/SP");
		dado.setNomeMesorregiao("Presidente Prudente");
		dado.setRegiaoNome("Sudeste");
		dado.setSiglaEstado("SP");
		
		List<DadoFormatado> dados = new ArrayList<>();
		dados.add(dado);
		
		Mockito.when(endPointService.findAll()).thenReturn(dados);
		
		mvc.perform(get("/json")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk())
			      .andExpect(jsonPath("$", notNullValue()))
			      .andExpect(jsonPath("$", hasSize(1)))
			      .andExpect(jsonPath("$[0].nomeCidade", is(dado.getNomeCidade())));
	}

	@DisplayName("Retornar o arquivo CSV no endPoint /csv")
	@Test
	void retornarCSV() throws Exception {
		DadoFormatado dado = new DadoFormatado();
		dado.setIdEstado(35);
		dado.setNomeCidade("Adamantina");
		dado.setNomeFormatado("Adamantina/SP");
		dado.setNomeMesorregiao("Presidente Prudente");
		dado.setRegiaoNome("Sudeste");
		dado.setSiglaEstado("SP");
		
		List<DadoFormatado> dados = new ArrayList<>();
		dados.add(dado);
		
		Mockito.when(endPointService.findAll()).thenReturn(dados);
		
		mvc.perform(get("/csv")
				.contentType(MediaType.ALL))
				.andExpect(status().isOk());
	}

	@DisplayName("Chamar o método findByNomeCidade do endPointService")
	@Test
	void chamarOMetodoNoEndPointService() throws Exception {
		DadoFormatado dado = new DadoFormatado();
		dado.setIdEstado(35);
		dado.setNomeCidade("Adamantina");
		dado.setNomeFormatado("Adamantina/SP");
		dado.setNomeMesorregiao("Presidente Prudente");
		dado.setRegiaoNome("Sudeste");
		dado.setSiglaEstado("SP");
		
		Mockito.when(endPointService.findByNomeCidade("Adamantina")).thenReturn(dado);
		
		mvc.perform(get("/?nomeCidade=Adamantina")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()))
			    .andExpect(jsonPath("$.nomeCidade", is(dado.getNomeCidade())));;
	}

}
