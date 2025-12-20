package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.produtos.CadastrarProdutoRequestDto;
import br.com.cryare.domain.dtos.response.produtos.ProdutoResponseDto;
import br.com.cryare.domain.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping("cadastrar")
	public ResponseEntity<ProdutoResponseDto> post(@RequestBody CadastrarProdutoRequestDto request) {
		var response = produtoService.cadastrarProduto(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}
}
