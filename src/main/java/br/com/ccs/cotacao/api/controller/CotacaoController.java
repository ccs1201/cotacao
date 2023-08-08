package br.com.ccs.cotacao.api.controller;

import br.com.ccs.cotacao.domain.entities.Cotacao;
import br.com.ccs.cotacao.domain.services.CotacaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cotacoes")
public class CotacaoController extends ControllerBase<Cotacao, CotacaoService> {
	public CotacaoController(CotacaoService service) {
		super(service);
	}
}
