package tn.com.tradenet.api.mscommercial.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.domain.Page;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Compte {
	@Id
	private String codeCompte;
	private String codeClient;
	private String profil;
	private String modeConnexion;
	private Date dateCreation;
	private Integer sallePublique;
	private String rang;
	
	@Transient
	private Page<Facture> listeFactures;
	@Transient
	private boolean desactivated;
	@Transient
	private List<CompteEmail> listeCompteEmails = new ArrayList<CompteEmail>();
	@Transient
	private List<AbonnementSsl> listeAbonnementSsl = new ArrayList<AbonnementSsl>();
	@Transient
	private List<Licence> listeLicences = new ArrayList<Licence>();
	@Transient
	private List<AbonnementIpsec> listeAbonnementsIpsec = new ArrayList<AbonnementIpsec>();
	
}
