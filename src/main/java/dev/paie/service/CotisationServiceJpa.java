package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

/**
 * @author Florent Callaou
 * Persistence JPA des cotisations
 */
@Repository
public class CotisationServiceJpa implements CotisationService {
	
	@PersistenceContext private EntityManager em;

	@Transactional
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
		em.persist(nouvelleCotisation);		
	}

	@Transactional
	@Override
	public void mettreAJour(Cotisation cotisation) {
		em.merge(cotisation);		
	}

	@Override
	public List<Cotisation> lister() {
		return em.createNamedQuery("listerCotisations", Cotisation.class).getResultList();	
	}

}
