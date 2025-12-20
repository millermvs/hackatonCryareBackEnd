package br.com.cryare.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {

	private Long idProduto;
	private String nomeProduto;
	private Double valorProduto;
}
