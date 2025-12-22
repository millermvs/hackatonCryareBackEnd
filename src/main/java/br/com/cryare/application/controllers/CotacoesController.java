package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.cotacao.CadastrarCotacaoRequestDto;
import br.com.cryare.domain.dtos.response.cotacao.CotacaoResponseDto;
import br.com.cryare.domain.services.CotacaoService;

@RestController
@RequestMapping("/api/v1/cotacoes")
public class CotacoesController {
	
	@Autowired
	private CotacaoService cotacaoService;

	@PostMapping("cadastrar")
	public ResponseEntity<CotacaoResponseDto> post(@RequestBody CadastrarCotacaoRequestDto request) {
		var response = cotacaoService.cadastrarCotacao(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}
	
	@GetMapping("listar")
	public ResponseEntity<Page<CotacaoResponseDto>> getByFornecedor(
			@RequestParam Long idFornecedor,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {
		var response = cotacaoService.listarCotacoesPorFornecedor(idFornecedor, page, size);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("listar/abertas")
	public ResponseEntity<Page<CotacaoResponseDto>> getAbertas(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		var response = cotacaoService.listarCotacoesAbertas(page, size);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("atualizar")
	public ResponseEntity<CotacaoResponseDto> put(@RequestParam Long idCotacao){
		var response = cotacaoService.atualizarCotacao(idCotacao);
		return ResponseEntity.ok(response);
	}



}
