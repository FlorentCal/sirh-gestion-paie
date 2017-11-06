package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne
	private Periode periode;
	
	private BigDecimal primeExceptionnelle;
	
	private LocalDateTime dateHeureCreation;
	
	public BulletinSalaire() {
		super();
	}
	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle) {
		super();
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
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
	



}
