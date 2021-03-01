package tn.com.tradenet.api.mscommercial.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.CertificatVpn;

public interface CertificatVpnRepository extends JpaRepository<CertificatVpn, BigInteger> {

}
