package br.com.ccs.cotacao.domain.services;

import br.com.ccs.cotacao.domain.entities.Fornecedor;
import br.com.ccs.cotacao.domain.exceptions.CotacaoSeriveException;
import br.com.ccs.cotacao.domain.repositories.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FornecedorService implements CotacaoServiceInterface<Fornecedor> {

	private final FornecedorRepository repository;


	@Override
	public void delete(UUID id) {
		repository.delete(findById(id));
	}

	@Override
	public Fornecedor save(Fornecedor entity) {
		try {
			return repository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new CotacaoSeriveException(HttpStatus.CONFLICT, "Fornecedor ja cadastrado.", e);
		}
	}

	@Override
	public Fornecedor findById(UUID id) {
		return repository.findById(id)
				.orElseThrow(() ->
						new CotacaoSeriveException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado."));
	}

	@Override
	public Collection<Fornecedor> findAll() {
		return repository.findAll();
	}
}
