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
	
	/** code : String */
	private String code;
	
	/** libelle : String */
	private String libelle;
	
	/** tauxSalarial : BigDecimal */
	@Column(name = "taux_salarial", precision=19, scale=6)
	private BigDecimal tauxSalarial;
	
	/** tauxPatronal : BigDecimal */
	@Column(name = "taux_patronal", precision=19, scale=6)
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

	/** Getter for id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter for id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** Getter for code
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/** Setter for code
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Getter for libelle
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/** Setter for libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Getter for tauxSalarial
	 * @return the tauxSalarial
	 */
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	/** Setter for tauxSalarial
	 * @param tauxSalarial the tauxSalarial to set
	 */
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	/** Getter for tauxPatronal
	 * @return the tauxPatronal
	 */
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	/** Setter for tauxPatronal
	 * @param tauxPatronal the tauxPatronal to set
	 */
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

}
