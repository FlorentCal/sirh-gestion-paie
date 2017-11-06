package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesService;

@Component
public class InitialiserDonneesController {

	@Autowired
	InitialiserDonneesService initialiserDonneesService;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		initialiserDonneesService.initialiser();
	}
	
}
