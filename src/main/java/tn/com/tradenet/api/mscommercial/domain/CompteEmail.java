package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigInteger;
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
public class CompteEmail {
	
	@Id
	private BigInteger idEmail;
	private String email;
	private boolean fact;
	private String observation;
	private String responsable;
	private String numero_tel;
	@ManyToOne
	@JoinColumn(name = "code_compte")
	@JsonIgnore
	Compte compte;
}
