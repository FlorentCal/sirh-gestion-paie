package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

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
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("titre", "Créer Bulletin de Salaire");
		mv.addObject("periodes", periodes.findAll());
		mv.addObject("employes", employes.findAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
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
	


}
