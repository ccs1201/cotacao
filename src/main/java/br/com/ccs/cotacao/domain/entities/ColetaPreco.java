package br.com.ccs.cotacao.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "coleta_preco")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@DynamicUpdate
public class ColetaPreco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private UUID id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coletaPreco")
	private Set<ColetaPrecoItem> intens;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "fornecedor_id", nullable = false)
	private Fornecedor fornecedor;

	@NotBlank
	private String nomeContato;

	@NotBlank
	private String foneContato;

	@Email
	private String emailContato;

	@CreationTimestamp
	private LocalDate dataCadastro;


}
