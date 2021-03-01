package tn.com.tradenet.api.mscommercial.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.Compte;
import tn.com.tradenet.api.mscommercial.domain.CompteEmail;

public interface CompteEmailRepository extends JpaRepository<CompteEmail, BigInteger> {

	List<CompteEmail> findByCompte(Compte compte);
}
