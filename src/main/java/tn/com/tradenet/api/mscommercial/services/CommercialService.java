package tn.com.tradenet.api.mscommercial.services;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.com.tradenet.api.mscommercial.domain.Client;
import tn.com.tradenet.api.mscommercial.domain.Compte;
import tn.com.tradenet.api.mscommercial.domain.CompteEmail;
import tn.com.tradenet.api.mscommercial.domain.DesactivationCompte;
import tn.com.tradenet.api.mscommercial.domain.Facture;
import tn.com.tradenet.api.mscommercial.domain.AbonnementIpsec;
import tn.com.tradenet.api.mscommercial.domain.AbonnementSsl;
import tn.com.tradenet.api.mscommercial.domain.Licence;
import tn.com.tradenet.api.mscommercial.domain.pk.TeifId;
import tn.com.tradenet.api.mscommercial.dto.SommaireAnnuelFacturesDto;
import tn.com.tradenet.api.mscommercial.dto.SommaireFacturesDto;
import tn.com.tradenet.api.mscommercial.repositories.AbonnementIpsecRepository;
import tn.com.tradenet.api.mscommercial.repositories.AbonnementSslRepository;
import tn.com.tradenet.api.mscommercial.repositories.CertificatVpnRepository;
import tn.com.tradenet.api.mscommercial.repositories.ClientRepository;
import tn.com.tradenet.api.mscommercial.repositories.CompteEmailRepository;
import tn.com.tradenet.api.mscommercial.repositories.CompteRepository;
import tn.com.tradenet.api.mscommercial.repositories.DesactivationCompteRepository;
import tn.com.tradenet.api.mscommercial.repositories.FactureRepository;
import tn.com.tradenet.api.mscommercial.repositories.LicenceRepository;
import tn.com.tradenet.api.mscommercial.repositories.PaiementRepository;
import tn.com.tradenet.api.mscommercial.repositories.TeifRepository;

@Service
@Data @AllArgsConstructor
public class CommercialService {
	private ClientRepository clientRepository;
	private CompteRepository compteRepository;
	private FactureRepository factureRepository;
	private PaiementRepository paiementRepository;
	private CompteEmailRepository compteEmailRepository;
	private DesactivationCompteRepository desactivationCompteRepository;
	private AbonnementSslRepository abonnementSslRepository;
	private LicenceRepository licenceRepository;
	private CertificatVpnRepository certificatVpnRepository;
	private AbonnementIpsecRepository abonnementIpsecRepository;
	private TeifRepository teifRepository;
	
	
	public List<Client> listeDesFactureParIdDouane(String idDouane, Pageable pageable) {
		List<Client> listeFactureRegroupeParClient = new ArrayList<Client>();
		clientRepository.findByIdentifiantDouane(idDouane).forEach( client -> {
			compteRepository.findByCodeClient(client.getCodeClient()).forEach(compte -> {
				Page<Facture> pageFactures = factureRepository.findByCodeCompte(compte.getCodeCompte(), pageable);
				factureRepository.findByCodeCompte(compte.getCodeCompte(), pageable).forEach(facture -> {
					if(paiementRepository.findByNumeroFactureAndAnnee(facture.getNumero(),facture.getAnnee()).isPresent()) {
						facture.setPaiementEffectue(true);
					}
				});
				compte.setListeFactures(pageFactures);
				client.getComptesClient().add(compte);
			});
			listeFactureRegroupeParClient.add(client);
		});
		return listeFactureRegroupeParClient;
	}
	public List<Client> listeDesFacturesNonPayeesParIdDouane(String idDouane) {
		List<Client> listeFactureRegroupeParClient = new ArrayList<Client>();
		clientRepository.findByIdentifiantDouane(idDouane).forEach( client -> {
			compteRepository.findByCodeClient(client.getCodeClient()).forEach(compte -> {
				List<Facture> listeFactures = factureRepository.findByCodeCompte(compte.getCodeCompte());
				Page<Facture> pageFactures = Page.empty();
				factureRepository.findByCodeCompte(compte.getCodeCompte()).forEach(facture -> {
					if(!paiementRepository.findByNumeroFactureAndAnnee(facture.getNumero(),facture.getAnnee()).isPresent()) {
						listeFactures.add(facture);
					}
				});
				pageFactures = new PageImpl<Facture>(listeFactures);
				compte.setListeFactures(pageFactures);
				client.getComptesClient().add(compte);
			});
			listeFactureRegroupeParClient.add(client);
		});
		return listeFactureRegroupeParClient;
	}
	public Page<Facture> findFacturesByAnnee(Integer annee, Pageable pageable) {
		Page<Facture> pageFactures = factureRepository.findByAnnee(annee, pageable);
		factureRepository.findByAnnee(annee, pageable).forEach(facture -> {
			if(paiementRepository.findByNumeroFactureAndAnnee(facture.getNumero(),facture.getAnnee()).isPresent()) {
				facture.setPaiementEffectue(true);
			}
		});
		return pageFactures;
	}
	
	public List<Client> recupererFicheClient(String identifiantDouane) {
		List<Client> listeClient = clientRepository.findByIdentifiantDouane(identifiantDouane);
		listeClient.forEach(client -> {
			List<Compte> listeDesComptesAssocie = compteRepository.findByCodeClient(client.getCodeClient());
			client.setComptesClient(listeDesComptesAssocie);
			listeDesComptesAssocie.forEach(compte -> {
				if(desactivationCompteRepository.findById(compte.getCodeCompte()).isPresent()) {
					DesactivationCompte desactivationCompte = desactivationCompteRepository.findById(compte.getCodeCompte()).get();
					if(desactivationCompte.getSuspension() == 0) {
						compte.setDesactivated(true);
					}
				}
				List<CompteEmail> listeEmails = compteEmailRepository.findByCompte(compte);
				if( listeEmails != null && listeEmails.size() != 0 ) {
					compte.setListeCompteEmails(listeEmails);
				}
				List<AbonnementSsl> listeAbonnementSsl = abonnementSslRepository.findByCompte(compte);
				if( listeAbonnementSsl != null && listeAbonnementSsl.size() != 0 ) {
					compte.setListeAbonnementSsl(listeAbonnementSsl);
				}
				List<Licence> listeLicences = licenceRepository.findByCodeCompte(compte.getCodeCompte());
				if( listeLicences != null && listeLicences.size() != 0 ) {
					compte.setListeLicences(listeLicences);
				}
				List<AbonnementIpsec> listeAbonnementsIpsec = abonnementIpsecRepository.findByCompte(compte);
				if( listeAbonnementsIpsec != null && listeAbonnementsIpsec.size() != 0 ) {
					compte.setListeAbonnementsIpsec(listeAbonnementsIpsec);
				}
				
			});
		});	
		return listeClient;
	}
	public SommaireFacturesDto getSommaireFacturesByIdDouane(String identifiantDouane) {
		SommaireFacturesDto statistiqueFacture = new SommaireFacturesDto(0,0,0,0);
		int nombreDeFactureParCompte = 0;
		int nombreDeFactureNonPayeeParCompte = 0;
		int nombreDeFactureSallePublique = 0;
		int nombreDeFactureNonPayeeSallePublique = 0;
		
		List<Client> listeClients = clientRepository.findByIdentifiantDouane(identifiantDouane);
		for(Client client : listeClients) {	
			List<Compte> listCompte = compteRepository.findByCodeClient(client.getCodeClient());
			for(Compte compte: listCompte){
				// nombreDeFactureParCompte = factureRepository.countByCodeCompte(compte.getCodeCompte());
				List<Facture> listeFacture = factureRepository.findByCodeCompte(compte.getCodeCompte());
				nombreDeFactureParCompte = listeFacture.size();
				if(compte.getSallePublique() == 1) {
					nombreDeFactureSallePublique = nombreDeFactureSallePublique + nombreDeFactureParCompte; 
				}
				for(Facture facture : listeFacture) {
					if(!paiementRepository.findByNumeroFactureAndAnnee(facture.getNumero(),facture.getAnnee()).isPresent()) {
						nombreDeFactureNonPayeeParCompte = nombreDeFactureNonPayeeParCompte + 1;
						if(compte.getSallePublique() == 1) {
							nombreDeFactureNonPayeeSallePublique = nombreDeFactureNonPayeeSallePublique + 1;
						}
					}
				}				
				statistiqueFacture.setNombreTotalFacture(statistiqueFacture.getNombreTotalFacture() + nombreDeFactureParCompte);
				statistiqueFacture.setNombreFactureNonPayees(statistiqueFacture.getNombreFactureNonPayees() + nombreDeFactureNonPayeeParCompte);
				if(compte.getSallePublique() == 1) {
					statistiqueFacture.setNombreFacturesSallePublique(statistiqueFacture.getNombreFacturesSallePublique() + nombreDeFactureSallePublique);
					statistiqueFacture.setNombreFacturesSallePubliqueNonPayees(statistiqueFacture.getNombreFacturesSallePubliqueNonPayees() + nombreDeFactureNonPayeeSallePublique);
				}
			}	
		}
		return statistiqueFacture;
	}
	public SommaireAnnuelFacturesDto getSommaireFacturesParAnnee(Integer annee) {
		SommaireAnnuelFacturesDto statistiqueparAnnee = new SommaireAnnuelFacturesDto(factureRepository.countByAnnee(annee),paiementRepository.countByAnnee(annee));
		
		return statistiqueparAnnee;
	}
	public Blob getQrCodeByNumeroAndYear(Long numero, Integer annee) {
		// TODO Auto-generated method stub
		return teifRepository.getOne(new TeifId(numero, annee)).getQrcode();
	}
	

}
