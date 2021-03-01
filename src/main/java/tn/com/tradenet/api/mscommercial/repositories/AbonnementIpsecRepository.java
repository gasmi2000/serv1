package tn.com.tradenet.api.mscommercial.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.AbonnementIpsec;
import tn.com.tradenet.api.mscommercial.domain.Client;
import tn.com.tradenet.api.mscommercial.domain.Compte;
import tn.com.tradenet.api.mscommercial.domain.ContactVpn;

public interface AbonnementIpsecRepository extends JpaRepository<AbonnementIpsec, BigInteger> {
	
	List<AbonnementIpsec> findByCompte(Compte compte);
	List<AbonnementIpsec> findByClient(Client client);
	List<AbonnementIpsec> findByContactVpn(ContactVpn ContactVpn);

}
