package br.com.ccs.cotacao.domain.services;

import br.com.ccs.cotacao.domain.entities.Cotacao;
import br.com.ccs.cotacao.domain.entities.Fornecedor;
import br.com.ccs.cotacao.domain.exceptions.CotacaoSeriveException;
import br.com.ccs.cotacao.domain.repositories.CotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CotacaoService implements CotacaoServiceInterface<Cotacao> {

	private final CotacaoRepository repository;

	@Override
	public void delete(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public Cotacao save(Cotacao entity) {
		return repository.save(entity);
	}

	@Override
	public Cotacao findById(UUID id) {
		return repository.findById(id).orElseThrow(() ->
				new CotacaoSeriveException(HttpStatus.NOT_FOUND, "Cotação não encontrada."));
	}

	@Override
	public Collection<Cotacao> findAll() {
		return repository.findAll();
	}

	public Cotacao addFornecedor(UUID cotacao_id, Fornecedor fornecedor) {
		var cotacao = findById(cotacao_id);
		cotacao.getFornecedores().add(fornecedor);

		return repository.saveAndFlush(cotacao);
	}
}
