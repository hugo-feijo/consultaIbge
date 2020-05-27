package com.hugo.evoluum.resource;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.service.EndPointService;
import com.hugo.evoluum.util.ParseData;

@RestController
@RequestMapping("/")
public class EndPointResource {

	Logger LOG = Logger.getLogger(EndPointResource.class.getName());
	
	@Autowired
	private EndPointService endPointService;
	
	@GetMapping("/json")
	public ResponseEntity<?> findAllJson() {
		LOG.info("... Chamando requisição  em /json no EndPoint Resource");
		
		List<DadoFormatado> dados = endPointService.findAll();
		
		return ResponseEntity.ok(dados);
	}
	
	@GetMapping("/csv")
	public void findAllCsv(HttpServletResponse resp) throws IOException {
		String filename = "Municipios.csv";

        resp.setContentType("text/plain;charset=utf-8");
        resp.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
		
		List<DadoFormatado> dados = endPointService.findAll();
		ParseData.dadosFormatadosToCsv(dados, resp.getOutputStream());
	}
	
	@GetMapping("/{nomeCidade}")
	public ResponseEntity<?> findByNomeCidade(@PathVariable String nomeCidade) {
		LOG.info("... Procurando em EndPointResource cidade com o nome: " + nomeCidade);
		DadoFormatado dados = endPointService.findByNomeCidade(nomeCidade);
		
		return ResponseEntity.ok(dados);
	}
}
