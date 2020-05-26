package com.hugo.evoluum.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.evoluum.model.projection.DadoFormatado;
import com.hugo.evoluum.service.EndPointService;

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
}
