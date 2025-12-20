package br.com.cryare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cryare.domain.dtos.request.produtos.CadastrarProdutoRequestDto;
import br.com.cryare.domain.dtos.response.produtos.ProdutoResponseDto;
import br.com.cryare.domain.entities.Produto;
import br.com.cryare.infrastructure.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	private ProdutoResponseDto criarRespostaDto(Produto novoProduto) {
		var response = new ProdutoResponseDto();
		response.setIdProduto(novoProduto.getIdProduto());
		response.setNomeProduto(novoProduto.getNomeProduto());
		response.setValorProduto(novoProduto.getValorProduto());

		return response;
	}

	@Transactional
	public ProdutoResponseDto cadastrarProduto(CadastrarProdutoRequestDto request) {

		var novoProduto = new Produto();
		novoProduto.setNomeProduto(request.getNomeProduto());
		novoProduto.setValorProduto(request.getValorProduto());
		produtoRepository.save(novoProduto);

		return criarRespostaDto(novoProduto);
	}
}
