package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class DesactivationCompte {
 
	@Id
	private String codeCompte;
	private BigDecimal ordre;
	private BigDecimal confirmation;
	private int suspension;
	@ManyToOne
	@JoinColumn(name="id_ordre")
	Ordre ordreDetails;
}
