package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import javax.persistence.Transient;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.com.tradenet.api.mscommercial.domain.pk.TeifId;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@IdClass(TeifId.class)
public class Teif {
	@Id
	private Long numero;
	@Id
	private Integer annee;
	private Blob qrcode;
	private String referenceTtn;
	private Date dateEnvoi;
	private Date datetReference;
	private String observation;
	
}
