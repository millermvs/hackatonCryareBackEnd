package br.com.cryare.infrastructure.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Fornecedor;
import br.com.cryare.domain.enums.TiposDeServicos;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	public Page<Fornecedor> findAll(Pageable pageable);
	
	Page<Fornecedor> findByTipoServico(TiposDeServicos tipoServico, Pageable pageable);

}
