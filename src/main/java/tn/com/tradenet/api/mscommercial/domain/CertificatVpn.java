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
public class CertificatVpn {
	@Id
	private BigInteger refCertificat;
	private String emailCarte;
	private Date dateExpiration;
}

