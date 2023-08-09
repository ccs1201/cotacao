package br.com.ccs.cotacao.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cotacao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	@EqualsAndHashCode.Include
	private UUID id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacao")
	private Collection<ItemCotacao> itens;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Cotacao_fornecedores",
			joinColumns = @JoinColumn(name = "cotacao_id"),
			uniqueConstraints = {@UniqueConstraint(name = "un_cotacao_fornecdor", columnNames = {"cotacao_id", "fornecedores_id"})})
	private Collection<Fornecedor> fornecedores;

	private LocalDate dataLimite;

	@CreationTimestamp
	private OffsetDateTime dataCadastro;

}
