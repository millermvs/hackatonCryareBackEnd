package br.com.cryare.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idProduto;

	@Column(nullable = false)
	private String nomeProduto;

	@Column(nullable = false)
	private Double valorProduto;

	@OneToMany(mappedBy = "idProduto", fetch = FetchType.LAZY)
	private Set<Cotacao> cotacoes = new HashSet<Cotacao>();
}
