package br.com.cryare.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Cotacao;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long>{

}
