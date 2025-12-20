package br.com.cryare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cryare.domain.dtos.request.cotacao.CadastrarCotacaoRequestDto;
import br.com.cryare.domain.dtos.response.cotacao.CotacaoResponseDto;
import br.com.cryare.domain.entities.Cotacao;
import br.com.cryare.domain.enums.StatusServico;
import br.com.cryare.domain.exceptions.NaoEncontradoException;
import br.com.cryare.infrastructure.repositories.CotacaoRepository;
import br.com.cryare.infrastructure.repositories.EmpresaRepository;
import br.com.cryare.infrastructure.repositories.FornecedorRepository;
import br.com.cryare.infrastructure.repositories.ProdutoRepository;
import br.com.cryare.infrastructure.repositories.ServicoRepository;
import jakarta.transaction.Transactional;

@Service
public class CotacaoService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private CotacaoRepository cotacaoRepository;

	private CotacaoResponseDto criarRespostaDto(Cotacao novaCotacao) {
		var response = new CotacaoResponseDto();
		response.setIdCotacao(novaCotacao.getIdCotacao());
		response.setIdEmpresa(novaCotacao.getEmpresa().getIdEmpresa());
		response.setIdFornecedor(novaCotacao.getFornecedor().getIdFornecedor());
		response.setIdProduto(novaCotacao.getProduto().getIdProduto());
		response.setIdServico(novaCotacao.getServico().getIdServico());
		return response;
	}

	@Transactional
	public CotacaoResponseDto cadastrarCotacao(CadastrarCotacaoRequestDto request) {

		var empresaFound = empresaRepository.findById(request.getIdEmpresa())
				.orElseThrow(() -> new NaoEncontradoException("Empresa não encontrada."));

		var fornecedorFound = fornecedorRepository.findById(request.getIdFornecedor())
				.orElseThrow(() -> new NaoEncontradoException("Fornecedor não encontrado."));

		var produtoFound = produtoRepository.findById(request.getIdProduto())
				.orElseThrow(() -> new NaoEncontradoException("Produto não encontrado."));

		var servicoFound = servicoRepository.findById(request.getIdServico())
				.orElseThrow(() -> new NaoEncontradoException("Serviço não encontrado."));

		var novaCotacao = new Cotacao();
		novaCotacao.setEmpresa(empresaFound);
		empresaFound.getCotacoes().add(novaCotacao);
		novaCotacao.setFornecedor(fornecedorFound);
		fornecedorFound.getCotacoes().add(novaCotacao);
		novaCotacao.setProduto(produtoFound);
		produtoFound.getCotacoes().add(novaCotacao);
		novaCotacao.setServico(servicoFound);
		servicoFound.getCotacoes().add(novaCotacao);
		novaCotacao.setStatusServico(StatusServico.EMABERTO);
		cotacaoRepository.save(novaCotacao);

		return criarRespostaDto(novaCotacao);
	}

}
