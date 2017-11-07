package dev.paie.service;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author Florent Callaou
 * Calcul des rémunérations affectée au bulletin de salaire
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		Grade grade = bulletin.getRemunerationEmploye().getGrade();

		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();

		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(grade.getNbHeuresBase().multiply(grade.getTauxBase())));

		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getSalaireDeBase()).add(bulletin.getPrimeExceptionnelle())));

		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.stream()
				.filter(cotisation -> cotisation.getTauxSalarial() != null)
				.map(cotisation -> cotisation.getTauxSalarial().multiply(new BigDecimal(resultat.getSalaireBrut())))
				.collect(Collectors.reducing(BigDecimal::add))
				.orElse(BigDecimal.ZERO)				
				));

		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(
				bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
				.stream()
				.filter(cotisation -> cotisation.getTauxPatronal() != null)
				.map(cotisation -> cotisation.getTauxPatronal().multiply(new BigDecimal(resultat.getSalaireBrut())))
				.collect(Collectors.reducing(BigDecimal::add))
				.orElse(BigDecimal.ZERO))
				);

		resultat.setNetImposable(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getSalaireBrut())
				.subtract(new BigDecimal(resultat.getTotalRetenueSalarial()))));

		resultat.setNetAPayer(paieUtils.formaterBigDecimal(new BigDecimal(resultat.getNetImposable())
				.subtract(bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().stream()
						.filter(cotisation -> cotisation.getTauxSalarial() != null)
						.map(cotisation -> cotisation.getTauxSalarial().multiply(new BigDecimal(resultat.getSalaireBrut())))
						.collect(Collectors.reducing(BigDecimal::add))
						.orElse(BigDecimal.ZERO))
				));

		return resultat;
	}

}
