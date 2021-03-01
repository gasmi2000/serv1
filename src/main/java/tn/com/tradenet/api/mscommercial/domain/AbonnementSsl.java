package tn.com.tradenet.api.mscommercial.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AbonnementSsl {
	@Id
	private Integer numeroAbonnement;
	
	private String nomClient;
	private String motPasse;
	private Date dateCreation;
	private Date dateMiseService;
	private String observation;
	private Integer affectation;
	private Date dateAffectation;
	private String etapeDossier;
	private String observationSupport;
	
	@ManyToOne
	@JoinColumn(name = "ref_certificat")
	private CertificatVpn certificatVpn;
	
	@ManyToOne
	@JoinColumn(name = "code_client")
	@JsonIgnore
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "code_compte")
	@JsonIgnore
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name = "ref_contact")
	private ContactVpn contactVpn;
	
	
}
