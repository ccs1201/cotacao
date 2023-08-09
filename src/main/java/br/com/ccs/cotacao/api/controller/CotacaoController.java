package br.com.ccs.cotacao.api.controller;

import br.com.ccs.cotacao.domain.entities.Cotacao;
import br.com.ccs.cotacao.domain.entities.Fornecedor;
import br.com.ccs.cotacao.domain.entities.ItemCotacao;
import br.com.ccs.cotacao.domain.services.CotacaoService;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cotacoes")
public class CotacaoController extends ControllerBase<Cotacao, CotacaoService> {
	public CotacaoController(CotacaoService service) {
		super(service);
	}

	@PostMapping("{cotacao_id}/fornecedor")
	@ResponseStatus(HttpStatus.OK)
	public void addFornecedor(@PathVariable UUID cotacao_id, @Valid @RequestBody Fornecedor fornecedor) {
		service.addFornecedor(cotacao_id, fornecedor);
	}

	@Getter
	private class RecCotacao {

		private UUID id;
		private Collection<ItemCotacao> itens;
		private Collection<RecFornecedor> fornecedores;
		private LocalDate dataLimite;
		private OffsetDateTime dataCadastro;

		public RecCotacao(Cotacao cotacao) {
			itens = cotacao.getItens();
			dataCadastro = cotacao.getDataCadastro();
			dataLimite = cotacao.getDataLimite();

			List<RecFornecedor> fornecedores = cotacao.getFornecedores()
					.stream()
					.map(fornecedor -> new RecFornecedor(fornecedor))
					.collect(Collectors.toList());
		}

		@Getter
		private class RecFornecedor {
			private UUID id;
			private String nomeFantasia;
			private String contato;

			public RecFornecedor(Fornecedor fornecedor) {
				this.id = fornecedor.getId();
				this.nomeFantasia = fornecedor.getNomeFantasia();
				this.contato = fornecedor.getContato();
			}
		}
	}
}
