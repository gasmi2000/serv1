package tn.com.tradenet.api.mscommercial.domain.pk;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor @Data @EqualsAndHashCode
public class PaiementId implements Serializable{

	public Long numeroFacture;
	public Integer annee;
}
