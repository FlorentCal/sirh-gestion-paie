package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

/**
 * @author Florent Callaou
 *	Controller de gestion des pages liées aux bulletins
 */
@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private PeriodeRepository periodes;

	@Autowired
	private EmployeRepository employes;

	@Autowired
	private BulletinSalaireRepository bulletins;

	@Autowired
	CalculerRemunerationServiceSimple calculerRemunerationServiceSimple;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("titre", "Créer Bulletin de Salaire");
		mv.addObject("periodes", periodes.findAll());
		mv.addObject("employes", employes.findAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public String creerBulletin(
			@RequestParam("periode") Integer idPeriode,
			@RequestParam("employe") Integer idEmploye,
			@RequestParam("primeExceptionnelle") String primeExceptionnelle) {

		BulletinSalaire bulletinSalaire = new BulletinSalaire();

		bulletinSalaire.setPeriode(periodes.findOne(idPeriode));
		bulletinSalaire.setRemunerationEmploye(employes.findOne(idEmploye));
		bulletinSalaire.setPrimeExceptionnelle(new BigDecimal(primeExceptionnelle));
		bulletinSalaire.setDateHeureCreation(LocalDateTime.now());

		bulletins.save(bulletinSalaire);

		return "redirect:/mvc/bulletins/lister";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	public ModelAndView listerBulletins() {

		ModelAndView mv = new ModelAndView();

		Map<BulletinSalaire, ResultatCalculRemuneration> bulletinsCalcul = new TreeMap<>();

		mv.setViewName("bulletins/listerBulletins");

		mv.addObject("titre", "Liste des bulletins");

		bulletins.findAll()
		.forEach(bulletin -> bulletinsCalcul.put(bulletin, calculerRemunerationServiceSimple.calculer(bulletin)));

		mv.addObject("bulletins", bulletinsCalcul);	

		return mv;
	}

	@RequestMapping(method=RequestMethod.GET, path = "/visualiser/{id}")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	public String visualiserBulletin(
			@PathVariable Integer id, 
			Model m){

		BulletinSalaire bulletin = bulletins.findOne(id);

		ResultatCalculRemuneration resultatCalculRemuneration = calculerRemunerationServiceSimple.calculer(bulletin);

		List<Cotisation> cotisationsNonImposables = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		
		List<Cotisation> cotisationsImposables = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		
		m.addAttribute("titre", "Bulletin de salaire");
	
		m.addAttribute("bulletin", bulletin);
		m.addAttribute("resultatCalculRemuneration", resultatCalculRemuneration);
		m.addAttribute("cotisationsNonImposables", cotisationsNonImposables);
		m.addAttribute("cotisationsImposables", cotisationsImposables);

		return "bulletins/visualiserBulletin";
	}


}
