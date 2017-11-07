package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dev.paie.util.PaieUtils;

/**
 * @author Florent Callaou
 *
 */
@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** code : String */
	private String code;

	/** nbHeuresBase : BigDecimal */
	@Column(name = "nb_heures_base")
	private BigDecimal nbHeuresBase;

	/** tauxBase : BigDecimal */
	@Column(name = "taux_base", precision=19, scale=6)
	private BigDecimal tauxBase;

	public Grade() {
		super();
	}

	public Grade(Integer id, String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		super();
		this.id = id;
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}	

	public Grade(String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		super();
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
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

	/** Getter for nbHeuresBase
	 * @return the nbHeuresBase
	 */
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	/** Setter for nbHeuresBase
	 * @param nbHeuresBase the nbHeuresBase to set
	 */
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	/** Getter for tauxBase
	 * @return the tauxBase
	 */
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	/** Setter for tauxBase
	 * @param tauxBase the tauxBase to set
	 */
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}

	/**
	 * @return le salaire annuel (ex : 35h * 9.5 € * 12 mois)
	 */
	public String getSalaireAnnuel(){
		return new PaieUtils().formaterBigDecimal(this.nbHeuresBase.multiply(this.tauxBase).multiply(new BigDecimal("12")));
	}



}
