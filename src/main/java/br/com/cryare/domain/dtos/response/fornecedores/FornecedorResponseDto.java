package br.com.cryare.domain.dtos.response.fornecedores;

import br.com.cryare.domain.enums.TiposDeServicos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FornecedorResponseDto {
	
	private Long idFornecedor;
	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String whatsAppFornecedor;
	private String emailFornecedor;
	private TiposDeServicos tipoServico;
}
