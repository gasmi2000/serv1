package tn.com.tradenet.api.mscommercial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.com.tradenet.api.mscommercial.domain.Teif;
import tn.com.tradenet.api.mscommercial.domain.pk.TeifId;

public interface TeifRepository extends JpaRepository<Teif, TeifId>{
}
