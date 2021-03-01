package tn.com.tradenet.api.mscommercial.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.ContactVpn;

public interface ContactVpnRepository extends JpaRepository<ContactVpn, BigInteger> {

}
