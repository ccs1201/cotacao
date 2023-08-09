package br.com.ccs.cotacao.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "item_cotacao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCotacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	@EqualsAndHashCode.Include
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "cotacao_id")
	@EqualsAndHashCode.Include
	private Cotacao cotacao;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@OneToMany(mappedBy = "itemCotacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ColetaPrecoItem> coletaPrecoItens = new LinkedHashSet<>();

}