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

@Entity
public class BulletinSalaire implements Comparable<BulletinSalaire> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne
	private Periode periode;
	
	@Column(name = "prime_exceptionnelle")
	private BigDecimal primeExceptionnelle;
	
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
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public String getDateHeureCreationFormat() {
		return dateHeureCreation.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"));
	}
	
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
