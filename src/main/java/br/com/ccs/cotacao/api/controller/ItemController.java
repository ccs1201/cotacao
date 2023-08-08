package br.com.ccs.cotacao.api.controller;

import br.com.ccs.cotacao.domain.entities.ItemCotacao;
import br.com.ccs.cotacao.domain.services.ItemCotacaoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itens")
public class ItemController extends ControllerBase<ItemCotacao, ItemCotacaoService> {
	public ItemController(ItemCotacaoService service) {
		super(service);
	}
}
