package tn.com.tradenet.api.mscommercial.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.CommandeLicence;

public interface CommandeLicenceRepository extends JpaRepository<CommandeLicence, BigInteger> {

}
