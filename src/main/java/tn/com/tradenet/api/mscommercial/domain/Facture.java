package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import javax.persistence.Transient;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.com.tradenet.api.mscommercial.domain.pk.FactureId;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@IdClass(FactureId.class)
public class Facture {
	@Id
	private Long numero;
	@Id
	private Integer annee;
	private String codeClient;
	private String codeCompte;
	private Date dateFacture;
	private Date periodeDu;
	private Date periodeAu;
	private Date dateLimitePaiement;
	private BigDecimal montantHt;
	private BigDecimal montantTaxes;
	private BigDecimal montantTtc;
	private String objet;
	private String emetteur;
	private boolean mail;
	@Transient
	private boolean paiementEffectue = false;
}
