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

	@Column(name="date_debut")
	private LocalDate dateDebut;
	
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
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDateDebutFormat() {
		return dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/YYY"));
	}
	
	public String getDateFinFormat() {
		return dateFin.format(DateTimeFormatter.ofPattern("dd/MM/YYY"));
	}
	
	
	
	

}
