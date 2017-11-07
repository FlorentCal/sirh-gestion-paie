package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired 
	private GradeService gradeService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		gradeService.sauvegarder(new Grade(
				1, 
				"CID", 
				new BigDecimal("35"), 
				new BigDecimal("13.5")));

		assertThat(gradeService.lister().size()).isEqualTo(1);

		gradeService.mettreAJour(new Grade(
				1, 
				"PDG", 
				new BigDecimal("60"), 
				new BigDecimal("20")));
	
		Grade grade = gradeService.lister().get(0);
		assertThat(grade.getCode()).isEqualTo("PDG");
		assertThat(grade.getNbHeuresBase()).isEqualTo("60.00");
		//20.000000 because of @Column(precision=19, scale = 6)
		assertThat(grade.getTauxBase()).isEqualTo("20.000000");
	}

}
