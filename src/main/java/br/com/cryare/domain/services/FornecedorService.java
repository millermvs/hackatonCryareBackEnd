package br.com.cryare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cryare.domain.dtos.request.fornecedores.CadastrarFornecedoresRequestDto;
import br.com.cryare.domain.dtos.request.fornecedores.EditarFornecedorRequestDto;
import br.com.cryare.domain.dtos.response.fornecedores.FornecedorResponseDto;
import br.com.cryare.domain.entities.Fornecedor;
import br.com.cryare.domain.enums.TiposDeServicos;
import br.com.cryare.domain.exceptions.NaoEncontradoException;
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
		response.setTipoServico(fornecedorNovo.getTipoServico());
		return response;
	}
	
	@Transactional
	public FornecedorResponseDto editarFornecedor(Long idFornecedor, EditarFornecedorRequestDto request) {

		var fornecedorFound = fornecedorRepository.findById(idFornecedor)
				.orElseThrow(() -> new NaoEncontradoException("Fornecedor não encontrado."));

		fornecedorFound.setNomeFornecedor(request.getNomeFornecedor());
		fornecedorFound.setWhatsAppFornecedor(request.getWhatsAppFornecedor());
		fornecedorFound.setEmailFornecedor(request.getEmailFornecedor());
		fornecedorFound.setTipoServico(request.getTipoServico());

		fornecedorRepository.save(fornecedorFound);

		return criarResponseDto(fornecedorFound);
	}


	@Transactional(readOnly = true)
	public Page<FornecedorResponseDto> listarFornecedoresPorTipo(TiposDeServicos tipoServico, Integer page, Integer size) {

		var pageable = PageRequest.of(page, size);

		var pagina = fornecedorRepository.findByTipoServico(tipoServico, pageable);

		return pagina.map(fornecedor -> {
			var response = criarResponseDto(fornecedor);
			return response;
		});
	}

	
	@Transactional(readOnly = true)
	public Page<FornecedorResponseDto> listarFornecedores(Integer page, Integer size) {

		var pageable = PageRequest.of(page, size);

		var paginaFornecedor = fornecedorRepository.findAll(pageable);

		return paginaFornecedor.map(fornecedor -> {
			var response = criarResponseDto(fornecedor);
			return response;
		});

	}

	@Transactional
	public FornecedorResponseDto cadastrarFornecedor(CadastrarFornecedoresRequestDto request) {

		var novoFornecedor = new Fornecedor();
		novoFornecedor.setNomeFornecedor(request.getNomeFornecedor());
		novoFornecedor.setCnpjFornecedor(request.getCnpjFornecedor());
		novoFornecedor.setWhatsAppFornecedor(request.getWhatsAppFornecedor());
		novoFornecedor.setEmailFornecedor(request.getEmailFornecedor());
		novoFornecedor.setTipoServico(request.getTipoServico());
		fornecedorRepository.save(novoFornecedor);
		return criarResponseDto(novoFornecedor);

	}
}
