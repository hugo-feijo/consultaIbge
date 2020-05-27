package com.hugo.evoluum.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.service.EndPointService;
import com.hugo.evoluum.util.ParseData;

@RestController
@RequestMapping("/")
public class EndPointResource {

	@Autowired
	private EndPointService endPointService;
	
	@GetMapping("/json")
	public ResponseEntity<?> findAllJson() {
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
}
