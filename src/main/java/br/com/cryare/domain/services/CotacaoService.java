package br.com.cryare.domain.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cryare.domain.dtos.request.cotacao.CadastrarCotacaoRequestDto;
import br.com.cryare.domain.dtos.response.cotacao.CotacaoResponseDto;
import br.com.cryare.domain.entities.Cotacao;
import br.com.cryare.domain.enums.StatusServico;
import br.com.cryare.domain.exceptions.NaoEncontradoException;
import br.com.cryare.infrastructure.repositories.CotacaoRepository;
import br.com.cryare.infrastructure.repositories.EmpresaRepository;
import br.com.cryare.infrastructure.repositories.FornecedorRepository;
import br.com.cryare.infrastructure.repositories.ServicoRepository;

@Service
public class CotacaoService {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private CotacaoRepository cotacaoRepository;

	private CotacaoResponseDto criarRespostaDto(Cotacao novaCotacao) {
		var response = new CotacaoResponseDto();
		response.setIdCotacao(novaCotacao.getIdCotacao());
		response.setIdEmpresa(novaCotacao.getEmpresa().getIdEmpresa());
		response.setIdFornecedor(novaCotacao.getFornecedor().getIdFornecedor());
		response.setIdServico(novaCotacao.getServico().getIdServico());
		response.setTipoServico(novaCotacao.getServico().getTipoServico());
		response.setStatusServico(novaCotacao.getStatusServico());
		response.setDataServico(LocalDate.now());
		response.setNomeFornecedor(novaCotacao.getFornecedor().getNomeFornecedor());
		response.setValorCotacao(novaCotacao.getServico().getValorServico());
		return response;
	}
	
	@Transactional
	public CotacaoResponseDto atualizarCotacao(Long idCotacao) {
		var cotacaoFound = cotacaoRepository.findById(idCotacao)
				.orElseThrow(() -> new NaoEncontradoException("Cotação não encontrada."));
		
		cotacaoFound.setStatusServico(StatusServico.ACEITO);
		
		return criarRespostaDto(cotacaoFound);
	}

	@Transactional(readOnly = true)
	public Page<CotacaoResponseDto> listarCotacoesAbertas(Integer page, Integer size) {

		var pageable = PageRequest.of(page, size);

		var pagina = cotacaoRepository.findByStatusServico(StatusServico.EMANALISE, pageable);

		return pagina.map(cotacao -> {
			var response = criarRespostaDto(cotacao);
			return response;
		});
	}

	@Transactional(readOnly = true)
	public Page<CotacaoResponseDto> listarCotacoesPorFornecedor(Long idFornecedor, Integer page, Integer size) {

		var pageable = PageRequest.of(page, size);

		var pagina = cotacaoRepository.findByFornecedorIdFornecedor(idFornecedor, pageable);

		return pagina.map(cotacao -> {
			var response = criarRespostaDto(cotacao);
			return response;
		});
	}

	@Transactional
	public CotacaoResponseDto cadastrarCotacao(CadastrarCotacaoRequestDto request) {

		var empresaFound = empresaRepository.findById(request.getIdEmpresa())
				.orElseThrow(() -> new NaoEncontradoException("Empresa não encontrada."));

		var fornecedorFound = fornecedorRepository.findById(request.getIdFornecedor())
				.orElseThrow(() -> new NaoEncontradoException("Fornecedor não encontrado."));

		var servicoFound = servicoRepository.findById(request.getIdServico())
				.orElseThrow(() -> new NaoEncontradoException("Serviço não encontrado."));

		var novaCotacao = new Cotacao();
		novaCotacao.setEmpresa(empresaFound);
		empresaFound.getCotacoes().add(novaCotacao);
		novaCotacao.setFornecedor(fornecedorFound);
		fornecedorFound.getCotacoes().add(novaCotacao);
		novaCotacao.setServico(servicoFound);
		servicoFound.getCotacoes().add(novaCotacao);
		servicoFound.setStatusAberto(false);
		novaCotacao.setStatusServico(StatusServico.EMANALISE);
		cotacaoRepository.save(novaCotacao);

		return criarRespostaDto(novaCotacao);
	}

}
