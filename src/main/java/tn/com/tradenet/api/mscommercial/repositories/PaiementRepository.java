package tn.com.tradenet.api.mscommercial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.Paiement;
import tn.com.tradenet.api.mscommercial.domain.pk.PaiementId;

public interface PaiementRepository extends JpaRepository<Paiement, PaiementId>{

	public Optional<Paiement> findByNumeroFactureAndAnnee(Long numeroFacture, Integer annee);
	public int countByNumeroFactureAndAnnee(Long numeroFacture, Integer annee);
	public int countByAnnee(Integer annee);
}
