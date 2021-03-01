package tn.com.tradenet.api.mscommercial.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.Licence;

public interface LicenceRepository extends JpaRepository<Licence, BigDecimal> {

	public List<Licence> findByCodeCompte(String codeCompte);
}
