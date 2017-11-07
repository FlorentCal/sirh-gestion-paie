package dev.paie.entite;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** matricule : String */
	private String matricule;
	
	/** entreprise : Entreprise */
	@ManyToOne
	private Entreprise entreprise;
	
	/** profilRemuneration : ProfilRemuneration */
	@ManyToOne
	private ProfilRemuneration profilRemuneration;
	
	/** grade : Grade */
	@ManyToOne
	private Grade grade;
	
	/** dateHeureCreation : LocalDateTime */
	@Column(name = "date_heure_creation")
	private LocalDateTime dateHeureCreation;

	public RemunerationEmploye() {
		super();
	}
	
	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade, LocalDateTime dateHeureCreation) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
		this.dateHeureCreation = dateHeureCreation;
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

	/** Getter for matricule
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/** Setter for matricule
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/** Getter for entreprise
	 * @return the entreprise
	 */
	public Entreprise getEntreprise() {
		return entreprise;
	}
	/** Setter for entreprise
	 * @param entreprise the entreprise to set
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/** Getter for profilRemuneration
	 * @return the profilRemuneration
	 */
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	/** Setter for profilRemuneration
	 * @param profilRemuneration the profilRemuneration to set
	 */
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	/** Getter for grade
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}
	/** Setter for grade
	 * @param grade the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/** Getter for dateHeureCreation
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	/** Setter for dateHeureCreation
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * @return la date formattée
	 */
	public String getDateHeureCreationFormat() {
		return dateHeureCreation.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"));
	}
	
	

}
