package br.com.cryare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cryare.domain.dtos.request.servicos.AtualizarDescricaoServicoRequestDto;
import br.com.cryare.domain.dtos.request.servicos.CadastrarServicoRequestDto;
import br.com.cryare.domain.dtos.response.servicos.ServicoResponseDto;
import br.com.cryare.domain.entities.Servico;
import br.com.cryare.domain.enums.TiposDeServicos;
import br.com.cryare.domain.exceptions.NaoEncontradoException;
import br.com.cryare.infrastructure.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	private ServicoResponseDto criarRespostaDto(Servico novoServico) {
		var response = new ServicoResponseDto();
		response.setIdServico(novoServico.getIdServico());
		response.setNomeServico(novoServico.getNomeServico());
		response.setValorServico(novoServico.getValorServico());
		response.setDescricaoServico(novoServico.getDescricaoServico());
		response.setTipoServico(novoServico.getTipoServico());
		return response;

	}

	@Transactional
	public ServicoResponseDto atualizarDescricaoServico(Long idServico, AtualizarDescricaoServicoRequestDto request) {

		var servicoFound = servicoRepository.findById(idServico)
				.orElseThrow(() -> new NaoEncontradoException("Serviço não encontrado."));

		servicoFound.setDescricaoServico(request.getDescricaoServico());

		servicoRepository.save(servicoFound);

		return criarRespostaDto(servicoFound);
	}

	@Transactional
	public void excluirServico(Long idServico) {

		var servicoFound = servicoRepository.findById(idServico)
				.orElseThrow(() -> new NaoEncontradoException("Serviço não encontrado."));

		servicoRepository.delete(servicoFound);
	}

	@Transactional(readOnly = true)
	public Page<ServicoResponseDto> listarServicosPorTipo(TiposDeServicos tipoServico, Integer page, Integer size) {

		var pageable = PageRequest.of(page, size);

		var paginaServicos = servicoRepository.findByTipoServico(tipoServico, pageable);

		return paginaServicos.map(servico -> {
			var response = criarRespostaDto(servico);
			return response;
		});
	}

	@Transactional(readOnly = true)
	public Page<ServicoResponseDto> listarServicosComCotacoesAbertas(Integer page, Integer size) {

		var pageable = PageRequest.of(page, size);

		var pagina = servicoRepository
				.findServicosAbertos( pageable);

		return pagina.map(servico -> {
			var response = criarRespostaDto(servico);
			return response;
		});
	}

	@Transactional
	public ServicoResponseDto cadastrarServico(CadastrarServicoRequestDto request) {

		var novoServico = new Servico();
		novoServico.setNomeServico(request.getNomeServico());
		novoServico.setValorServico(request.getValorServico());
		novoServico.setTipoServico(request.getTipoServico());
		novoServico.setDescricaoServico(request.getDescricaoServico());
		novoServico.setStatusAberto(true);
		servicoRepository.save(novoServico);

		return criarRespostaDto(novoServico);
	}

}
