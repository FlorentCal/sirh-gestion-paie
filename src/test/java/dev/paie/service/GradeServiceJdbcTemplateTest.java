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

import dev.paie.config.DataSourceMySQLConfig;
import dev.paie.entite.Grade;

@ContextConfiguration(classes = { DataSourceMySQLConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired 
	private GradeService gradeService;
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	@Before
	public void setUp(){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "TRUNCATE TABLE GRADE";
		this.jdbcTemplate.execute(sql);
	}

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		gradeService.sauvegarder(new Grade(1, "CID", new BigDecimal("35"), new BigDecimal("13.5")));

		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		assertThat(gradeService.lister().size()).isEqualTo(1);

		// TODO modifier un grade
		gradeService.mettreAJour(new Grade(1, "PDG", new BigDecimal("60"), new BigDecimal("20")));

		// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(gradeService.lister().get(0).getCode()).isEqualTo("PDG");
		assertThat(gradeService.lister().get(0).getNbHeuresBase()).isEqualTo("60.00");
		assertThat(gradeService.lister().get(0).getTauxBase()).isEqualTo("20.00");
	}

}
