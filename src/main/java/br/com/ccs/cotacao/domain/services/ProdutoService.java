package br.com.ccs.cotacao.domain.services;

import br.com.ccs.cotacao.domain.entities.Produto;
import br.com.ccs.cotacao.domain.exceptions.CotacaoSeriveException;
import br.com.ccs.cotacao.domain.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoService implements CotacaoServiceInterface<Produto> {

	private final ProdutoRepository repository;

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public Produto save(Produto entity) {
		return repository.save(entity);
	}

	@Override
	public Produto findById(UUID id) {
		return repository.findById(id).orElseThrow(() ->
				new CotacaoSeriveException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
	}

	@Override
	public Collection<Produto> findAll() {
		return repository.findAll();
	}
}
