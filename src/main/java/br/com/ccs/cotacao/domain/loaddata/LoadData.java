package br.com.ccs.cotacao.domain.loaddata;

import br.com.ccs.cotacao.domain.entities.Cotacao;
import br.com.ccs.cotacao.domain.entities.Fornecedor;
import br.com.ccs.cotacao.domain.entities.Produto;
import br.com.ccs.cotacao.domain.repositories.CotacaoRepository;
import br.com.ccs.cotacao.domain.repositories.FornecedorRepository;
import br.com.ccs.cotacao.domain.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoadData {

	private final FornecedorRepository fornecedorRepository;
	private final ProdutoRepository produtoRepository;
	private final CotacaoRepository cotacaoRepository;

	@PostConstruct
	private void load() {
		loadFornecedores();
		loadProdutos();
		loadCotacoes();
	}

	private void loadCotacoes() {
		Cotacao c = new Cotacao();
		c.setDataLimite(LocalDate.of(2023, 8, 15));
		cotacaoRepository.saveAndFlush(c);

	}

	private void loadProdutos() {
		Produto p = new Produto();
		p.setDescricao("Ar Condionado Split 9000BTUs");
		p.setValorVenda(BigDecimal.valueOf(1350.00));
		p.setValorUltimaCompra(BigDecimal.valueOf(1150.5));
		produtoRepository.saveAndFlush(p);

		p = new Produto();
		p.setDescricao("Ar Condionado Split 7000BTUs");
		p.setValorVenda(BigDecimal.valueOf(1250.00));
		p.setValorUltimaCompra(BigDecimal.valueOf(950.5));
		produtoRepository.saveAndFlush(p);

		p = new Produto();
		p.setDescricao("Ar Condionado Split 12000BTUs");
		p.setValorVenda(BigDecimal.valueOf(1550.00));
		p.setValorUltimaCompra(BigDecimal.valueOf(1275.5));
		produtoRepository.saveAndFlush(p);
	}

	private void loadFornecedores() {
		Fornecedor f = new Fornecedor();
		f.setContato("Souza");
		f.setNomeFantasia("Casas D'agua");
		fornecedorRepository.saveAndFlush(f);

		f = new Fornecedor();
		f.setNomeFantasia("Magalu");
		f.setContato("Dona Luiza");
		fornecedorRepository.saveAndFlush(f);

		f = new Fornecedor();
		f.setContato("Kerito");
		f.setNomeFantasia("Koerich");
		fornecedorRepository.saveAndFlush(f);
	}
}
