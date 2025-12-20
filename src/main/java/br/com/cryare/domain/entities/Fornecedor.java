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
@Table(name = "fornecedores")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idFornecedor;
	
	@Column(nullable = false)
	private String nomeFornecedor;
	
	@Column(nullable = false, length = 14)
	private String cnpjFornecedor;
	
	@Column(nullable = false, length = 13)
	private String whatsAppFornecedor;
	
	@Column(nullable = false)
	private String emailFornecedor;
	
	@OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
	private Set<Cotacao> cotacoes = new HashSet<Cotacao>();
	
}
