package br.com.cryare.infrastructure.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	public Page<Fornecedor> findByIdEmpresa(Long idEmpresa);

}
