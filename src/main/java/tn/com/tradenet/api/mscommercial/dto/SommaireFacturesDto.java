package tn.com.tradenet.api.mscommercial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class SommaireFacturesDto {

	private int nombreTotalFacture;
	private int nombreFactureNonPayees;
	private int nombreFacturesSallePublique;
	private int nombreFacturesSallePubliqueNonPayees;
}
