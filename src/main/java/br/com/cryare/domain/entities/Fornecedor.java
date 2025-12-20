package br.com.cryare.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fornecedor {
	
	private Long idFornecedor;
	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String whatsAppFornecedor;
	private String emailFornecedor;
	
}
