package br.com.cryare.domain.dtos.request.servicos;

import br.com.cryare.domain.enums.TiposDeServicos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarServicoRequestDto {

	private String nomeServico;
	private Double valorServico;
	private TiposDeServicos tipoServico;
	private String descricaoServico;

}
