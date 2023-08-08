package br.com.ccs.cotacao.api.controller;

import br.com.ccs.cotacao.domain.entities.Fornecedor;
import br.com.ccs.cotacao.domain.services.FornecedorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/fornecedores")
public class ForncedorController extends ControllerBase<Fornecedor, FornecedorService> {

	public ForncedorController(FornecedorService service) {
		super(service);
	}
}
