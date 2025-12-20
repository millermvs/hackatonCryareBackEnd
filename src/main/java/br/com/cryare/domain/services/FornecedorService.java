package br.com.cryare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cryare.domain.dtos.request.fornecedores.CadastrarFornecedoresRequestDto;
import br.com.cryare.domain.dtos.response.fornecedores.FornecedorResponseDto;
import br.com.cryare.domain.entities.Fornecedor;
import br.com.cryare.infrastructure.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	private FornecedorResponseDto criarResponseDto(Fornecedor fornecedorNovo) {
		var response = new FornecedorResponseDto();
		response.setIdFornecedor(fornecedorNovo.getIdFornecedor());
		response.setNomeFornecedor(fornecedorNovo.getNomeFornecedor());
		response.setCnpjFornecedor(fornecedorNovo.getCnpjFornecedor());
		response.setWhatsAppFornecedor(fornecedorNovo.getWhatsAppFornecedor());
		response.setEmailFornecedor(fornecedorNovo.getEmailFornecedor());

		return response;
	}
	
	@Transactional(readOnly = true)
	private FornecedorResponseDto listarFornecedores(Integer page, Integer size) {
		
		
		return null;
		
	}

	@Transactional
	public FornecedorResponseDto cadastrarFornecedor(CadastrarFornecedoresRequestDto request) {

		var novoFornecedor = new Fornecedor();
		novoFornecedor.setNomeFornecedor(request.getNomeFornecedor());
		novoFornecedor.setCnpjFornecedor(request.getCnpjFornecedor());
		novoFornecedor.setWhatsAppFornecedor(request.getWhatsAppFornecedor());
		novoFornecedor.setEmailFornecedor(request.getEmailFornecedor());
		fornecedorRepository.save(novoFornecedor);
		return criarResponseDto(novoFornecedor);

	}
}
