package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.service.InitialiserDonneesService;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired private AvantageRepository avantageRepository;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		avantageRepository.save(new Avantage("codeAvantage", "nomAvantage", new BigDecimal("10")));

		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
		Avantage avantage = avantageRepository.findAll().get(0);
		assertThat(avantage.getCode()).isEqualTo("codeAvantage");

		// TODO modifier un avantage
		avantage.setCode("codeAvantage2");
		avantage.setNom("nomAvantage2");
		avantage.setMontant(new BigDecimal("100"));
		avantageRepository.save(avantage);

		// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
		assertThat(avantage.getCode()).isEqualTo("codeAvantage2");
		assertThat(avantage.getNom()).isEqualTo("nomAvantage2");
		assertThat(avantage.getMontant()).isEqualTo(new BigDecimal("100"));
	
	}
}