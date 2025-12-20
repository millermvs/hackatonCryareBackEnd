package br.com.cryare.domain.services;

import org.springframework.stereotype.Service;

import br.com.cryare.domain.dtos.request.produtos.CadastrarProdutoRequestDto;
import br.com.cryare.domain.dtos.response.produtos.ProdutoResponseDto;
import br.com.cryare.domain.entities.Produto;

@Service
public class ProdutoService {

	private ProdutoResponseDto criarRespostaDto(Produto novoProduto) {
		var response = new ProdutoResponseDto();
		response.setIdProduto(novoProduto.getIdProduto());
		response.setNomeProduto(novoProduto.getNomeProduto());
		response.setValorProduto(novoProduto.getValorProduto());

		return response;
	}

	public ProdutoResponseDto cadastrarProduto(CadastrarProdutoRequestDto request) {

		var novoProduto = new Produto();
		novoProduto.setNomeProduto(request.getNomeProduto());
		novoProduto.setValorProduto(request.getValorProduto());

		return criarRespostaDto(novoProduto);
	}
}
