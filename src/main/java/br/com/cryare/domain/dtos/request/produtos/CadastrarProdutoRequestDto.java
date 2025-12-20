package br.com.cryare.domain.dtos.request.produtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CadastrarProdutoRequestDto {
	
	private String nomeProduto;
	private Double valorProduto;

}
