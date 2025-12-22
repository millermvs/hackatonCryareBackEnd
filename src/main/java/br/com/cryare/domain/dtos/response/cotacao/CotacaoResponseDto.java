package br.com.cryare.domain.dtos.response.cotacao;

import java.time.LocalDate;

import br.com.cryare.domain.enums.StatusServico;
import br.com.cryare.domain.enums.TiposDeServicos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CotacaoResponseDto {
	private Long idCotacao;
	private Long idEmpresa;
	private Long idFornecedor;
	private Long idServico;
	private String nomeFornecedor;
	private Double valorCotacao;
	private TiposDeServicos tipoServico;
	private StatusServico statusServico;
	private LocalDate dataServico;
}
