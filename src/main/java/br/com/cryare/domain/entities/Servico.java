package br.com.cryare.domain.entities;

import java.util.HashSet;
import java.util.Set;

import br.com.cryare.domain.enums.TiposDeServicos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idServico;

	@Column(nullable = false)
	private String nomeServico;

	@Column(nullable = false)
	private Double valorServico;

	@Column
	@Enumerated(EnumType.STRING)
	private TiposDeServicos tipoServico;

	@Column
	private String descricaoServico;

	@Column
	private Boolean statusAberto;

	@OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
	private Set<Cotacao> cotacoes = new HashSet<Cotacao>();
}
