package br.com.cryare.domain.dtos.request.fornecedores;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastrarFornecedoresRequestDto {
	
	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String whatsAppFornecedor;
	private String emailFornecedor;

}
