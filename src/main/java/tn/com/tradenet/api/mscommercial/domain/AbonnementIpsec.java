package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigInteger;
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
public class AbonnementIpsec {
	@Id
	private BigInteger numeroAbonnement;
	private String nomClient;
	private String psk;
	private String ipPublic;
	private String ipTtn;
	private String equipement;
	private String typeInternet;
	private Date dateCreation;
	private Date dateMiseService;
	private String observation;
	private BigInteger affectation;
	private Date dateAffectation;
	private String etapeDossier;
	private String ipttnlan;
	private String ipmasquettn;
	private String ipclientlan;
	private String ipmasqueclient;
	private String responsable;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	@JsonIgnore
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="code_compte")
	@JsonIgnore
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="ref_contact")
	private ContactVpn contactVpn;
	  
}
