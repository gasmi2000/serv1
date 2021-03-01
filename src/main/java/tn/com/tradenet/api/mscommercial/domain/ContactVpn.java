package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ContactVpn {
	@Id
	private BigInteger refContact;
	private String nom;
	private String prenom;
	private String adresse;
	private String mail;
	private String numeroFixe;
	private String numeroPortable;	
}
