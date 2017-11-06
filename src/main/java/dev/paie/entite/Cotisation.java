package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="listerCotisations", query="SELECT c FROM Cotisation c")
public class Cotisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	private String libelle;
	
	@Column(name = "taux_salarial")
	private BigDecimal tauxSalarial;
	
	@Column(name = "taux_patronal")
	private BigDecimal tauxPatronal;

	public Cotisation() {
		super();
	}

	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}





}
