package br.com.ccs.cotacao.api.controller;

import br.com.ccs.cotacao.domain.services.CotacaoServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class ControllerBase<T, S extends CotacaoServiceInterface<T>> {

	private final S service;
	@GetMapping
	Collection<T> getAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	T getById(@PathVariable UUID id) {
		return service.findById(id);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable UUID id) {
		service.delete(id);

	}

	@PostMapping
	T save(@RequestBody T input) {
		return service.save(input);
	}
}
