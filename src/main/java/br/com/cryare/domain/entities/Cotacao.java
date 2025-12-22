package br.com.cryare.domain.entities;

import br.com.cryare.domain.enums.StatusServico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cotacoes")
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCotacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", referencedColumnName = "idEmpresa")
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_forneceor", referencedColumnName = "idFornecedor")
	private Fornecedor fornecedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servico", referencedColumnName = "idServico")
	private Servico servico;
	
	@Column
	@Enumerated(EnumType.STRING)
	private StatusServico statusServico;

}
