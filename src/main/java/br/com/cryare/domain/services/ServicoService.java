package br.com.cryare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cryare.domain.dtos.request.servicos.CadastrarServicoRequestDto;
import br.com.cryare.domain.dtos.response.servicos.ServicoResponseDto;
import br.com.cryare.domain.entities.Servico;
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
		return response;

	}

	@Transactional
	public ServicoResponseDto cadastrarServico(CadastrarServicoRequestDto request) {

		var novoServico = new Servico();
		novoServico.setNomeServico(request.getNomeServico());
		novoServico.setValorServico(request.getValorServico());
		novoServico.setTipoServico(request.getTipoServico());
		novoServico.setDescricaoServico(request.getDescricaoServico());
		servicoRepository.save(novoServico);

		return criarRespostaDto(novoServico);
	}

}
