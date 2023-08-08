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
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, columnDefinition = "Binary(16)")
	@EqualsAndHashCode.Include
	private UUID id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacao")
	private Collection<ItemCotacao> itens;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Cotacao_fornecedores",
			joinColumns = @JoinColumn(name = "cotacao_id"))
	private Collection<Fornecedor> fornecedores;

	@CreationTimestamp
	private OffsetDateTime dataCadastro;

	private LocalDate dataLimite;

}
