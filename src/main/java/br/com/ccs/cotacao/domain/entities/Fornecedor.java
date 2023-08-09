package br.com.ccs.cotacao.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "fornecedor")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	@EqualsAndHashCode.Include
	private UUID id;

	@Column(unique = true)
	private String nomeFantasia;

	private String contato;

	@OneToMany(mappedBy = "fornecedor", orphanRemoval = true)
	private Set<ColetaPreco> coletaPrecos = new LinkedHashSet<>();

	@ManyToMany(mappedBy = "fornecedores")
	private Collection<Cotacao> cotacoes = new ArrayList<>();

}