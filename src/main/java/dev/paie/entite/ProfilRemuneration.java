package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** code : String */
	private String code;

	/** cotisationsNonImposables : List<Cotisation> */
	@ManyToMany
	@JoinTable(name = "profilremu_cotisationNI")
	private List<Cotisation> cotisationsNonImposables;
	
	/** cotisationsImposables : List<Cotisation> */
	@ManyToMany
	@JoinTable(name = "profilremu_cotisationI")
	private List<Cotisation> cotisationsImposables;
	
	/** avantages : List<Avantage> */
	@ManyToMany
	private List<Avantage> avantages;

	public ProfilRemuneration() {
		super();
	}	

	public ProfilRemuneration(String code, List<Cotisation> cotisationsNonImposables,
			List<Cotisation> cotisationsImposables, List<Avantage> avantages) {
		super();
		this.code = code;
		this.cotisationsNonImposables = cotisationsNonImposables;
		this.cotisationsImposables = cotisationsImposables;
		this.avantages = avantages;
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

	/** Getter for cotisationsNonImposables
	 * @return the cotisationsNonImposables
	 */
	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}
	/** Setter for cotisationsNonImposables
	 * @param cotisationsNonImposables the cotisationsNonImposables to set
	 */
	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	/** Getter for cotisationsImposables
	 * @return the cotisationsImposables
	 */
	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}
	/** Setter for cotisationsImposables
	 * @param cotisationsImposables the cotisationsImposables to set
	 */
	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	/** Getter for avantages
	 * @return the avantages
	 */
	public List<Avantage> getAvantages() {
		return avantages;
	}
	/** Setter for avantages
	 * @param avantages the avantages to set
	 */
	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}
	
}
