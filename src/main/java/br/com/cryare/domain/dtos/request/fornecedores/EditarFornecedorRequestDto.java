package br.com.cryare.domain.dtos.request.fornecedores;

import br.com.cryare.domain.enums.TiposDeServicos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditarFornecedorRequestDto {

	private String nomeFornecedor;
	private String whatsAppFornecedor;
	private String emailFornecedor;
	private TiposDeServicos tipoServico;

}
