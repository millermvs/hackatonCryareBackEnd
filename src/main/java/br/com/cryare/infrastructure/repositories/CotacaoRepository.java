package br.com.cryare.infrastructure.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Cotacao;
import br.com.cryare.domain.enums.StatusServico;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {

	Page<Cotacao> findByFornecedorIdFornecedor(Long idFornecedor, Pageable pageable);

	
	Page<Cotacao> findByStatusServico(StatusServico statusServico, Pageable pageable);

}
