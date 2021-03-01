package tn.com.tradenet.api.mscommercial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.com.tradenet.api.mscommercial.domain.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, String>{
	
	List<Client> findByIdentifiantDouane(String identifiantDouane);
	Optional<Client> findByCodeClient(String codeClient);
	
}
