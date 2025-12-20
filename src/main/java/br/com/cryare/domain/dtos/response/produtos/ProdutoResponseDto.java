package br.com.cryare.domain.dtos.response.produtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponseDto {
	
	private Long idProduto;
	private String nomeProduto;
	private Double valorProduto;

}
