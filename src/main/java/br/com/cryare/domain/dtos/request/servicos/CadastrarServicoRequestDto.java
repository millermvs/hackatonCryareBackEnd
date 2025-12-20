package br.com.cryare.domain.dtos.request.servicos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarServicoRequestDto {

	private String nomeServico;
	private Double valorServico;
	
}
