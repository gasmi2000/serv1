package tn.com.tradenet.api.mscommercial.rest;

import java.sql.Blob;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.com.tradenet.api.mscommercial.domain.Client;
import tn.com.tradenet.api.mscommercial.domain.Facture;
import tn.com.tradenet.api.mscommercial.domain.Teif;
import tn.com.tradenet.api.mscommercial.dto.SommaireAnnuelFacturesDto;
import tn.com.tradenet.api.mscommercial.dto.SommaireFacturesDto;
import tn.com.tradenet.api.mscommercial.services.CommercialService;

@RestController()
@AllArgsConstructor @Data
@RequestMapping("/ttn-api-commercial")
public class CommercialController {
	
	private CommercialService commercialService;
	@GetMapping("/factures-par-id-douane/{iddouane}")
	public List<Client> listeDesFactureByIdDouane(@PathVariable String iddouane, Pageable pageable) {
		return commercialService.listeDesFactureParIdDouane(iddouane, pageable);
	}
	@GetMapping("/factures-par-annee/{annee}")
	public Page<Facture> listeDesFactureByIdDouane(@PathVariable Integer annee, Pageable pageable) {
		return commercialService.findFacturesByAnnee(annee, pageable);
	}
	@GetMapping("/factures-non-payees-par-id-douane/{iddouane}")
	public List<Client> listeDesFactureNonByIdDouane(@PathVariable String iddouane) {
		return commercialService.listeDesFacturesNonPayeesParIdDouane(iddouane);
	}
	@GetMapping("/fiche-client/{iddouane}")
	public List<Client> recupererFicheClient(@PathVariable String iddouane) {
		return commercialService.recupererFicheClient(iddouane);
	}
	@GetMapping("/factures-sommaire/{iddouane}")
	public SommaireFacturesDto getSommaireFacturesByIdDouane(@PathVariable String iddouane) {
		return commercialService.getSommaireFacturesByIdDouane(iddouane);
	}
	@GetMapping("/sommaire-factures-par-annee/{annee}")
	public SommaireAnnuelFacturesDto listeDesFactureByIdDouane(@PathVariable Integer annee) {
		return commercialService.getSommaireFacturesParAnnee(annee);
	}
	@GetMapping("/sommaire-factures-par-annee/{numero}/{annee}")
	public Blob listeDesFactureByIdDouane(@PathVariable Long numero, @PathVariable Integer annee) {
		return commercialService.getQrCodeByNumeroAndYear(numero,annee);
	}
	

}
