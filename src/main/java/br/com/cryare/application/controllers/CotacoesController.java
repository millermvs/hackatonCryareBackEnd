package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
