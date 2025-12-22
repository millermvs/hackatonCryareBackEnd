package br.com.cryare.infrastructure.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Servico;
import br.com.cryare.domain.enums.TiposDeServicos;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	@Query("""
			SELECT s
			FROM Servico s
			WHERE s.statusAberto = true
		""")
		Page<Servico> findServicosAbertos(Pageable pageable);


	Page<Servico> findByTipoServico(TiposDeServicos tipoServico, Pageable pageable);
}
