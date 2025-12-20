package br.com.cryare.domain.entities;

import jakarta.persistence.Entity;
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
	private Empresa idEmpresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_forneceor", referencedColumnName = "idFornecedor")
	private Fornecedor idFornecedor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servico", referencedColumnName = "idServico")
	private Servico idServico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", referencedColumnName = "idProduto")
	private Produto idProduto;

}
