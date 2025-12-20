package br.com.cryare.domain.services;

import org.springframework.stereotype.Service;

import br.com.cryare.domain.dtos.request.empresas.CadastrarEmpresaRequestDto;
import br.com.cryare.domain.dtos.response.empresas.EmpresaResponseDto;
import br.com.cryare.domain.entities.Empresa;

@Service
public class EmpresaService {

	private EmpresaResponseDto criarResponseDto(Empresa empresaNova) {
		var response = new EmpresaResponseDto();
		response.setIdEmpresa(empresaNova.getIdEmpresa());
		response.setNomeEmpresa(empresaNova.getNomeEmpresa());
		response.setCnpjEmpresa(empresaNova.getCnpjEmpresa());

		return response;
	}

	
	public EmpresaResponseDto cadastrarEmpresa(CadastrarEmpresaRequestDto request) {

		var empresaNova = new Empresa();
		empresaNova.setNomeEmpresa(request.getNomeEmpresa());
		empresaNova.setCnpjEmpresa(request.getCnpjEmpresa());

		return criarResponseDto(empresaNova);
	}

}
