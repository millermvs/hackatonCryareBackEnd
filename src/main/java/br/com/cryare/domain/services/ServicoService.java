package br.com.cryare.domain.services;

import org.springframework.stereotype.Service;

import br.com.cryare.domain.dtos.request.servicos.CadastrarServicoRequestDto;
import br.com.cryare.domain.dtos.response.servicos.ServicoResponseDto;
import br.com.cryare.domain.entities.Servico;

@Service
public class ServicoService {

	private ServicoResponseDto criarRespostaDto(Servico novoServico) {
		var response = new ServicoResponseDto();
		response.setIdServico(novoServico.getIdServico());
		response.setNomeServico(novoServico.getNomeServico());
		response.setValorServico(novoServico.getValorServico());

		return response;

	}

	public ServicoResponseDto cadastrarServico(CadastrarServicoRequestDto request) {

		var novoServico = new Servico();
		novoServico.setNomeServico(request.getNomeServico());
		novoServico.setValorServico(request.getValorServico());

		return criarRespostaDto(novoServico);
	}

}
