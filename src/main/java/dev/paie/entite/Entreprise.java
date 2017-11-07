package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entreprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** siret : String */
	private String siret;
	
	/** denomination : String */
	private String denomination;
	
	/** adresse : String */
	private String adresse;
	
	/** urssaf : String */
	private String urssaf;
	
	/** codeNaf : String */
	private String codeNaf;
		
	public Entreprise() {
		super();
	}
	public Entreprise(String siret, String denomination, String adresse, String urssaf, String codeNaf) {
		super();
		this.siret = siret;
		this.denomination = denomination;
		this.adresse = adresse;
		this.urssaf = urssaf;
		this.codeNaf = codeNaf;
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
	
	/** Getter for siret
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}
	/** Setter for siret
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	/** Getter for denomination
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}
	/** Setter for denomination
	 * @param denomination the denomination to set
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	/** Getter for adresse
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/** Setter for adresse
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/** Getter for urssaf
	 * @return the urssaf
	 */
	public String getUrssaf() {
		return urssaf;
	}
	/** Setter for urssaf
	 * @param urssaf the urssaf to set
	 */
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}
	
	/** Getter for codeNaf
	 * @return the codeNaf
	 */
	public String getCodeNaf() {
		return codeNaf;
	}
	/** Setter for codeNaf
	 * @param codeNaf the codeNaf to set
	 */
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}
		
}
