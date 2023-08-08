package br.com.ccs.cotacao.domain.repositories;

import br.com.ccs.cotacao.domain.entities.ItemCotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ItemCotacaoRepository extends JpaRepository<ItemCotacao, UUID> {
}