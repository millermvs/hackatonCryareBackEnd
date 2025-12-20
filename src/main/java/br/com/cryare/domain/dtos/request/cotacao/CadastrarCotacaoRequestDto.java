package br.com.cryare.domain.dtos.request.cotacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarCotacaoRequestDto {
	
	private Long idEmpresa;
	private Long idFornecedor;
	private Long idProduto;
	private Long idServico;

}
