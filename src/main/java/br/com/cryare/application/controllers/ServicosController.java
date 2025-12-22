package br.com.cryare.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cryare.domain.dtos.request.servicos.AtualizarDescricaoServicoRequestDto;
import br.com.cryare.domain.dtos.request.servicos.CadastrarServicoRequestDto;
import br.com.cryare.domain.dtos.response.servicos.ServicoResponseDto;
import br.com.cryare.domain.enums.TiposDeServicos;
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

	@GetMapping("listar/com-cotacoes-abertas")
	public ResponseEntity<Page<ServicoResponseDto>> getServicosComCotacoesAbertas(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		var response = servicoService.listarServicosComCotacoesAbertas(page, size);
		return ResponseEntity.ok(response);
	}


	@GetMapping("listar/tipo")
	public ResponseEntity<Page<ServicoResponseDto>> getByTipo(@RequestParam TiposDeServicos tipoServico,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {

		var response = servicoService.listarServicosPorTipo(tipoServico, page, size);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("excluir/{idServico}")
	public ResponseEntity<Void> delete(@PathVariable Long idServico) {

		servicoService.excluirServico(idServico);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("editar/descricao/{idServico}")
	public ResponseEntity<ServicoResponseDto> put(@PathVariable Long idServico,
			@RequestBody AtualizarDescricaoServicoRequestDto request) {

		var response = servicoService.atualizarDescricaoServico(idServico, request);
		return ResponseEntity.ok(response);
	}

}
