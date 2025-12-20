package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.servicos.CadastrarServicoRequestDto;
import br.com.cryare.domain.dtos.response.servicos.ServicoResponseDto;
import br.com.cryare.domain.services.ServicoService;

@RestController
@RequestMapping("api/v1/servicos")
public class ServicosController {

	@Autowired
	private ServicoService servicoService;

	@PostMapping("cadastrar")
	public ResponseEntity<ServicoResponseDto> post(@RequestBody CadastrarServicoRequestDto request) {
		var response = servicoService.cadastrarServico(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
