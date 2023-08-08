package br.com.ccs.cotacao.domain.services;

import java.util.Collection;
import java.util.UUID;

public interface CotacaoServiceInterface<T> {

	void delete(UUID id);

	T save(T entity);

	T findById(UUID id);

	Collection<T> findAll();

}
