package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.repository.EmployeRepository;
import dev.paie.repository.PeriodeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {
		
	@Autowired
	private PeriodeRepository periodes;
	
	@Autowired
	private EmployeRepository employes;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("titre", "Créer Bulletin de Salaire");
		mv.addObject("periodes", periodes.findAll());
		mv.addObject("employes", employes.findAll());
		
		return mv;
	}


}
