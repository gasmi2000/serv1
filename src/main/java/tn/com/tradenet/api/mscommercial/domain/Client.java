package tn.com.tradenet.api.mscommercial.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
	@Id
	private String codeClient;
	private String identifiantDouane;
	private String nom;
	private String adresse;
	private String ville;
	private String codePostal;
	private String matriculeFiscale;
	private String contact;
	private String tel;
	private String fax;
	
	@Transient
	private List<Compte> comptesClient = new ArrayList<Compte>();

}
