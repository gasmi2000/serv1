package tn.com.tradenet.api.mscommercial.domain;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.com.tradenet.api.mscommercial.domain.pk.PaiementId;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@IdClass(PaiementId.class)
public class Paiement {
	@Id
	private Long numeroFacture;
	@Id
	private Integer annee;
	private String datePaiement;
	private String dateAction;
}
