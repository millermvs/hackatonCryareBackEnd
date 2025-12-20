package br.com.cryare.domain.dtos.response.servicos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoResponseDto {
	
	private Long idServico;
	private String nomeServico;
	private Double valorServico;

}
