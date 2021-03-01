package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Licence {
	
	@Id
	private BigDecimal refLicence;
	private String codeCompte;
	private String codeArticle;
	private Date date_acquis;
	private Date dateInstall;
	private String agent;
	private String profil;
	private String observation;
	private String gouvernorat;
	private String ville;
	private String valeurLicence;
	private String version;
	@ManyToOne
	@JoinColumn(name="ref_commande")
	CommandeLicence commandeLicence;
			  

}
