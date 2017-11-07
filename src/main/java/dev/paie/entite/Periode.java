package dev.paie.entite;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Periode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** dateDebut : LocalDate */
	@Column(name="date_debut")
	private LocalDate dateDebut;
	
	/** dateFin : LocalDate */
	@Column(name="date_fin")
	private LocalDate dateFin;
		
	public Periode() {
		super();
	}
	public Periode(LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
	
	/** Getter for dateDebut
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	/** Setter for dateDebut
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	/** Getter for dateFin
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	/** Setter for dateFin
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * @return la date formattée
	 */
	public String getDateFinFormat() {
		return dateFin.format(DateTimeFormatter.ofPattern("dd/MM/YYY"));
	}
	
	
	
	

}
