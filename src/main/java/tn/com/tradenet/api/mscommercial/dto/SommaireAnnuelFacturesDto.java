package tn.com.tradenet.api.mscommercial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class SommaireAnnuelFacturesDto {

	private int nombreTotalFactureParAnnee;
	private int nombreFactureNonPayeesParAnnee;
	
}
