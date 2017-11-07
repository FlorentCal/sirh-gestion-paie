package dev.paie.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	private EmployeRepository employes;

	@Autowired
	private EntrepriseRepository entreprises;

	@Autowired
	private ProfilRepository profils;

	@Autowired
	private GradeRepository grades;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("employes/creerEmploye");
		
		mv.addObject("titre", "Ajouter un employé");
		
		mv.addObject("entreprises", entreprises.findAll());
		mv.addObject("profils", profils.findAll());
		mv.addObject("grades", grades.findAll());
		
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmploye(
			@RequestParam("matricule") String matricule,
			@RequestParam("profil") Integer profil,
			@RequestParam("grade") Integer grade,
			@RequestParam("entreprise") Integer entreprise) {

		RemunerationEmploye remunerationEmploye= new RemunerationEmploye();
		
		remunerationEmploye.setMatricule(matricule);
		remunerationEmploye.setEntreprise(entreprises.findOne(entreprise));
		remunerationEmploye.setProfilRemuneration(profils.findOne(profil));
		remunerationEmploye.setGrade(grades.findOne(grade));
		remunerationEmploye.setDateHeureCreation(LocalDateTime.now());

		employes.save(remunerationEmploye);

		return "redirect:/mvc/employes/lister";
	}
	

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployes() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("employes/listerEmployes");
		
		mv.addObject("titre", "Liste des employés");
		mv.addObject("employes", employes.findAll());
		
		return mv;
	}

}
