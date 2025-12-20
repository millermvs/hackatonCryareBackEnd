package br.com.cryare.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
