package tn.com.tradenet.api.mscommercial.domain;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ordre {

	@Id
	private BigInteger id;
	private String type;
}
