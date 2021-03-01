package tn.com.tradenet.api.mscommercial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.AbonnementSsl;
import tn.com.tradenet.api.mscommercial.domain.Compte;

public interface AbonnementSslRepository extends JpaRepository<AbonnementSsl, Integer> {
	public List<AbonnementSsl> findByCompte(Compte compte);
}
