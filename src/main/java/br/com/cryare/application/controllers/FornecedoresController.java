package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.fornecedores.CadastrarFornecedoresRequestDto;
import br.com.cryare.domain.services.FornecedorService;

@RestController
@RequestMapping("api/v1/fornecedores")
public class FornecedoresController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@PostMapping("cadastrar")
	public ResponseEntity<?> post(@RequestBody CadastrarFornecedoresRequestDto request){		
		var response = fornecedorService.cadastrarFornecedor(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
