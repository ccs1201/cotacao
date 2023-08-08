package br.com.ccs.cotacao.api.controller;

import br.com.ccs.cotacao.domain.entities.Produto;
import br.com.ccs.cotacao.domain.services.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController extends ControllerBase<Produto, ProdutoService> {
	public ProdutoController(ProdutoService service) {
		super(service);
	}
}
