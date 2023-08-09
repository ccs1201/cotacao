package br.com.ccs.cotacao.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "coleta_preco_item", uniqueConstraints = {
		@UniqueConstraint(name = "UN_coletaprecoitem", columnNames = {"coleta_preco_id", "item_cotacao_id"})
})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ColetaPrecoItem {
	@Id
	@Column(name = "id", nullable = false)
	@EqualsAndHashCode.Include
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "coleta_preco_id")
	private ColetaPreco coletaPreco;

	@NotNull
	@Positive
	private Float qtd;

	@NotNull
	@Positive
	private BigDecimal valorUnitario;

	@NotNull
	@PositiveOrZero
	private BigDecimal descontoItem;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "item_cotacao_id", nullable = false)
	private ItemCotacao itemCotacao;

	private Boolean fornecido = Boolean.FALSE;

}