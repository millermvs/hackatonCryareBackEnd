package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.fornecedores.CadastrarFornecedoresRequestDto;
import br.com.cryare.domain.dtos.request.fornecedores.EditarFornecedorRequestDto;
import br.com.cryare.domain.dtos.response.fornecedores.FornecedorResponseDto;
import br.com.cryare.domain.enums.TiposDeServicos;
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

	
	@GetMapping("listar/tipo")
	public ResponseEntity<Page<FornecedorResponseDto>> getByTipo(
			@RequestParam TiposDeServicos tipoServico,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		var response = fornecedorService.listarFornecedoresPorTipo(tipoServico, page, size);
		return ResponseEntity.ok(response);
			
	}
	@PutMapping("editar/{idFornecedor}")
	public ResponseEntity<FornecedorResponseDto> put(
			@PathVariable Long idFornecedor,
			@RequestBody EditarFornecedorRequestDto request) {

		var response = fornecedorService.editarFornecedor(idFornecedor, request);
		return ResponseEntity.ok(response);
	}


}
