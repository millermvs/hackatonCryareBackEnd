package br.com.cryare.domain.services;

import org.springframework.stereotype.Service;

import br.com.cryare.domain.dtos.request.fornecedores.CadastrarFornecedoresRequestDto;
import br.com.cryare.domain.dtos.response.fornecedores.FornecedorResponseDto;
import br.com.cryare.domain.entities.Fornecedor;

@Service
public class FornecedorService {

	private FornecedorResponseDto criarResponseDto(Fornecedor fornecedorNovo) {
		var response = new FornecedorResponseDto();
		response.setIdFornecedor(fornecedorNovo.getIdFornecedor());
		response.setNomeFornecedor(fornecedorNovo.getNomeFornecedor());
		response.setCnpjFornecedor(fornecedorNovo.getCnpjFornecedor());
		response.setWhatsAppFornecedor(fornecedorNovo.getWhatsAppFornecedor());
		response.setEmailFornecedor(fornecedorNovo.getEmailFornecedor());

		return response;
	}

	public FornecedorResponseDto cadastrarFornecedor(CadastrarFornecedoresRequestDto request) {

		var novoFornecedor = new Fornecedor();
		novoFornecedor.setNomeFornecedor(request.getNomeFornecedor());
		novoFornecedor.setCnpjFornecedor(request.getCnpjFornecedor());
		novoFornecedor.setWhatsAppFornecedor(request.getWhatsAppFornecedor());
		novoFornecedor.setEmailFornecedor(request.getEmailFornecedor());

		return criarResponseDto(novoFornecedor);

	}
}
