package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.empresas.CadastrarEmpresaRequestDto;
import br.com.cryare.domain.dtos.response.empresas.EmpresaResponseDto;
import br.com.cryare.domain.dtos.response.fornecedores.FornecedorResponseDto;
import br.com.cryare.domain.services.EmpresaService;
import br.com.cryare.domain.services.FornecedorService;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresasController {

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping("cadastrar")
	public ResponseEntity<EmpresaResponseDto> post(@RequestBody CadastrarEmpresaRequestDto request) {
		var response = empresaService.cadastrarEmpresa(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("consultar")
	public ResponseEntity<Page<FornecedorResponseDto>> get(@RequestParam Long idEmpresa,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {
		var response = "";
		return null;
	}
}
