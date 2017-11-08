package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_utilisateur")
	private String nomUtilisateur;
	
	@Column(name = "mot_de_passe")
	private String motDePasse;
	
	private Boolean actif;
	
	@Enumerated(EnumType.STRING)
	private ROLES role;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nomUtilisateur, String motDePasse, Boolean actif, ROLES role) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.actif = actif;
		this.role = role;
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

	/** Getter for nomUtilisateur
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	/** Setter for nomUtilisateur
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	/** Getter for motDePasse
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/** Setter for motDePasse
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/** Getter for actif
	 * @return the actif
	 */
	public Boolean getActif() {
		return actif;
	}
	/** Setter for actif
	 * @param actif the actif to set
	 */
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	/** Getter for role
	 * @return the role
	 */
	public ROLES getRole() {
		return role;
	}
	/** Setter for role
	 * @param role the role to set
	 */
	public void setRole(ROLES role) {
		this.role = role;
	}	

}
