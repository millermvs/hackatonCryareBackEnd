package br.com.cryare.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cryare.domain.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
