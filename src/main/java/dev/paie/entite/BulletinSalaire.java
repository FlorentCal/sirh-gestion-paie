package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Florent Callaou
 *
 */
@Entity
public class BulletinSalaire implements Comparable<BulletinSalaire> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** remunerationEmploye : RemunerationEmploye */
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	
	/** periode : Periode */
	@ManyToOne
	private Periode periode;
	
	/** primeExceptionnelle : BigDecimal */
	@Column(name = "prime_exceptionnelle")
	private BigDecimal primeExceptionnelle;
	
	/** dateHeureCreation : LocalDateTime */
	@Column(name = "date_heure_creation")
	private LocalDateTime dateHeureCreation;
	
	public BulletinSalaire() {
		super();
	}

	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle, LocalDateTime dateHeureCreation) {
		super();
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
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

	/** Getter for remunerationEmploye
	 * @return the remunerationEmploye
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	/** Setter for remunerationEmploye
	 * @param remunerationEmploye the remunerationEmploye to set
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	/** Getter for periode
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}
	/** Setter for periode
	 * @param periode the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	/** Getter for primeExceptionnelle
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	/** Setter for primeExceptionnelle
	 * @param primeExceptionnelle the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(BulletinSalaire bulletinSalaire) {
		
		if(this.dateHeureCreation.compareTo(bulletinSalaire.dateHeureCreation) == 0){
			if (this.id == bulletinSalaire.id){
		    	return 0;
		    }
		    else if (this.id > bulletinSalaire.id){
		    	return 1;
		    }
		    else {
		    	return -1;
		    }
		}
	
	    return this.dateHeureCreation.compareTo(bulletinSalaire.dateHeureCreation);
	}

	



}
