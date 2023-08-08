package br.com.ccs.cotacao.domain.services;

import br.com.ccs.cotacao.domain.entities.ItemCotacao;
import br.com.ccs.cotacao.domain.exceptions.CotacaoSeriveException;
import br.com.ccs.cotacao.domain.repositories.ItemCotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemCotacaoService implements CotacaoServiceInterface<ItemCotacao> {

	private final ItemCotacaoRepository repository;

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public ItemCotacao save(ItemCotacao entity) {
		return repository.save(entity);
	}

	@Override
	public ItemCotacao findById(UUID id) {
		return repository.findById(id).orElseThrow(() ->
				new CotacaoSeriveException(HttpStatus.NOT_FOUND, "Item não encontrado."));
	}

	@Override
	public Collection<ItemCotacao> findAll() {
		return repository.findAll();
	}
}
