package dev.paie.service;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Utilisateur;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;

/**
 * @author Florent Callaou
 * Initialise la BDD grace aux fichiers XML et au code java
 */
@Service
@EnableTransactionManagement
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	GradeRepository grades;
	
	@Autowired
	EntrepriseRepository entreprises;
	
	@Autowired
	ProfilRepository profils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public void initialiser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"cotisations-imposables.xml", 
				"cotisations-non-imposables.xml",
				"entreprises.xml",
				"grades.xml", 
				"profils-remuneration.xml");

		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
		.forEach(classe -> 
		context.getBeansOfType(classe)
		.values()
		.stream()
		.forEach(object -> em.persist(object))
				);		
		
		List<Periode> periodes = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			LocalDate firstDayOfMonth = LocalDate.of(2017, i, 1);
			periodes.add(new Periode(firstDayOfMonth, firstDayOfMonth.with(lastDayOfMonth())));
		}		
		
		save(periodes);
		
		List<RemunerationEmploye> employes = new ArrayList<>();
		
		employes.add(new RemunerationEmploye(
				"M0111", 
				entreprises.findAll().get(1), 
				profils.findAll().get(2), 
				grades.findAll().get(0), 
				LocalDateTime.of(2017, 6, 1, 10, 16)));
		employes.add(new RemunerationEmploye(
				"M0112",
				entreprises.findAll().get(0), 
				profils.findAll().get(1), 
				grades.findAll().get(1), 
				LocalDateTime.of(2017, 6, 1, 10, 17)));
		employes.add(new RemunerationEmploye(
				"M0114", 
				entreprises.findAll().get(2), 
				profils.findAll().get(1), 
				grades.findAll().get(0), 
				LocalDateTime.of(2017, 6, 1, 10, 17)));
		employes.add(new RemunerationEmploye(
				"M0113", 
				entreprises.findAll().get(2), 
				profils.findAll().get(0), 
				grades.findAll().get(1), 
				LocalDateTime.of(2017, 6, 1, 10, 18)));
		
		save(employes);
		
		List<BulletinSalaire> bulletins = new ArrayList<>();
		
		bulletins.add(new BulletinSalaire(
				employes.get(0),
				periodes.get(0), 
				new BigDecimal("100"), 
				LocalDateTime.of(2017, 06, 01, 10, 16)));
		bulletins.add(new BulletinSalaire(
				employes.get(1), 
				periodes.get(0), 
				new BigDecimal("200"), 
				LocalDateTime.of(2017, 06, 01, 10, 17)));
		bulletins.add(new BulletinSalaire(
				employes.get(2), 
				periodes.get(0), 
				new BigDecimal("115"), 
				LocalDateTime.of(2017, 06, 01, 10, 17)));
		bulletins.add(new BulletinSalaire(employes.get(3), 
				periodes.get(0), 
				new BigDecimal("152"), 
				LocalDateTime.of(2017, 06, 01, 10, 18)));
		
		save(bulletins);
		
		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		utilisateurs.add(new Utilisateur(
				"root", 
				passwordEncoder.encode("root"), 
				true, 
				Utilisateur.ROLES.ROLE_ADMINISTRATEUR));
		utilisateurs.add(new Utilisateur(
				"user_w", 
				passwordEncoder.encode("admin_w"), 
				true, 
				Utilisateur.ROLES.ROLE_ADMINISTRATEUR));
		utilisateurs.add(new Utilisateur(
				"user_normal", 
				passwordEncoder.encode("user_normal"), 
				true, 
				Utilisateur.ROLES.ROLE_UTILISATEUR));
		
		save(utilisateurs);
		
		context.close();

	}
	
	private <T> void save(List<T> listToPersist){
		listToPersist.stream().forEach(object -> em.persist(object));
	}


}
