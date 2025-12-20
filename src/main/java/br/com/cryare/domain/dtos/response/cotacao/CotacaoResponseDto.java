package br.com.cryare.domain.dtos.response.cotacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CotacaoResponseDto {
	private Long idCotacao;
	private Long idEmpresa;
	private Long idFornecedor;
	private Long idProduto;
	private Long idServico;

}
