package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.paie.entite.Grade;

/**
 * @author Florent Callaou
 * Persistence JDBC des grades
 */
@Repository
public class GradeServiceJdbcTemplate implements GradeService {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO GRADE (CODE, NB_HEURES_BASE, TAUX_BASE) VALUES(?, ?, ?)";
		
		this.jdbcTemplate.update(sql, 
				nouveauGrade.getCode(), 
				nouveauGrade.getNbHeuresBase(), 
				nouveauGrade.getTauxBase());
		
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE GRADE SET CODE = ?, NB_HEURES_BASE = ?, TAUX_BASE = ?  WHERE ID = ? ";
		
		this.jdbcTemplate.update(sql, 
				grade.getCode(), 
				grade.getNbHeuresBase(), 
				grade.getTauxBase(),
				grade.getId());
	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM grade";
		
		return this.jdbcTemplate.query(sql, (rs, rowNum) -> new Grade(rs.getInt("ID"), rs.getString("CODE"), rs.getBigDecimal("NB_HEURES_BASE"), rs.getBigDecimal("TAUX_BASE")));
	}

}