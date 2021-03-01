package tn.com.tradenet.api.mscommercial.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.com.tradenet.api.mscommercial.domain.Facture;
import tn.com.tradenet.api.mscommercial.domain.pk.FactureId;

@Repository
public interface FactureRepository extends JpaRepository<Facture, FactureId>{

	Page<Facture> findByCodeCompte(String codeCompte, Pageable pageable);
	Page<Facture> findByAnnee(Integer annee, Pageable pageable);
	List<Facture> findByCodeCompte(String codeCompte);
	Long countByCodeCompte(String codeCompte);
	int countByAnnee(Integer annee);
}
