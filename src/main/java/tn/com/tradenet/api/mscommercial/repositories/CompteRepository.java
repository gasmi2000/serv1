package tn.com.tradenet.api.mscommercial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.com.tradenet.api.mscommercial.domain.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
	
	List<Compte> findByCodeClient(String codeClient);

}
