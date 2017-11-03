package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;


@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
@EnableTransactionManagement
@Transactional
public class CotisationServiceJpaTest {
	
	@PersistenceContext private EntityManager em;
	
	@Autowired private CotisationService cotisationService;
	
	
	@Before
	public void setUp(){
		em.createNativeQuery("TRUNCATE TABLE Cotisation").executeUpdate();
	}
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		//TODO sauvegarder une nouvelle cotisation
		cotisationService.sauvegarder(new Cotisation(
				"CodeCot", 
				"LibCot", 
				new BigDecimal("22.62"), 
				new BigDecimal("15.5")));
		
		//TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
		assertThat(cotisationService.lister().size()).isEqualTo(1);
		
		Cotisation cotisation = cotisationService.lister().get(0);
		// TODO modifier une cotisation
		cotisation.setCode("NewCodeCot");
		cotisation.setLibelle("NewLibCot");
		cotisation.setTauxSalarial(new BigDecimal(26));
		cotisation.setTauxPatronal(new BigDecimal(32));
		cotisationService.mettreAJour(cotisation);
		
		//TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		assertThat(cotisation.getCode()).isEqualTo("NewCodeCot");
		assertThat(cotisation.getLibelle()).isEqualTo("NewLibCot");
		assertThat(cotisation.getTauxSalarial()).isEqualTo(new BigDecimal(26));
		assertThat(cotisation.getTauxPatronal()).isEqualTo(new BigDecimal(32));
	}

}
