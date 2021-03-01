package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class CommandeLicence {
	@Id
	private BigInteger ref;
	private String refSap;
	private String codeClient;
	private Date dateCommande;
	private String observation;
}
