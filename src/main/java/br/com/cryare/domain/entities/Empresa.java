package br.com.cryare.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idEmpresa;

	@Column(nullable = false)
	private String nomeEmpresa;

	@Column(nullable = false, length = 14)
	private String cnpjEmpresa;

	@OneToMany(mappedBy = "empresa")
	private Set<Cotacao> cotacoes = new HashSet<Cotacao>();

}
