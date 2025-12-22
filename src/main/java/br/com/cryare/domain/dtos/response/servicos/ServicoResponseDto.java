package br.com.cryare.domain.dtos.response.servicos;

import br.com.cryare.domain.enums.TiposDeServicos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicoResponseDto {	
	private Long idServico;
	private String nomeServico;
	private Double valorServico;
	private String descricaoServico;
	private TiposDeServicos tipoServico;
}
