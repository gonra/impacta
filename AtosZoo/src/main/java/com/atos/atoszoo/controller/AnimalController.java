package com.atos.atoszoo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atos.atoszoo.model.Animal;
import com.atos.atoszoo.model.Jaula;
import com.atos.atoszoo.repositories.AnimalRepository;
import com.atos.atoszoo.repositories.JaulaRepository;

@Controller
public class AnimalController {

	@Autowired
	AnimalRepository animalRepo;
	
	@Autowired
	JaulaRepository jaulaRepo;
	
	@RequestMapping(value="/animal",method=RequestMethod.GET)
	public String showAnimal() {
		return "/novoAnimal";
	}
	
	@RequestMapping(value="/animal",method=RequestMethod.POST)
	public String addAnimal(Animal animal){
		animal.setJaula(null);
		Animal c = animalRepo.save(animal);
		return "redirect:/animal/lista";
	}
	
	@RequestMapping(value="/animal/lista",method=RequestMethod.GET)
	public ModelAndView listarAnimal() {
		ModelAndView model = new ModelAndView("listaAnimal");
		List<Animal> lista = new ArrayList<>();
		List<String> numeroJaula = new ArrayList<>();
		for(Animal cli : animalRepo.findAll()) {
			lista.add(cli);
			Jaula jaula = cli.getJaula();
			String jaulaId="";
			if (jaula != null) {
				jaulaId = jaula.getNumeroJaula().toString();
			}
			numeroJaula.add(jaulaId);
		}
		
		model.addObject("listaAnimal",lista);
		model.addObject("listaJaula",numeroJaula);
		return model;
	}
	
	@RequestMapping(value="/animal/delete/{id}",method=RequestMethod.GET)
	public String deletarAnimal(@PathVariable("id") Integer id) {

        animalRepo.deleteById(id);
		return "redirect:/animal/lista";
	}
	
	@RequestMapping(value="/animal/{id}",method=RequestMethod.GET)
	public ModelAndView editarAnimal(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("editarAnimal");
		Animal animal = animalRepo.findById(id).get();
		model.addObject("animal", animal);
		Jaula jaula = animal.getJaula();
		Integer jaulaId = null; 
		if(jaula != null) {
			jaulaId = jaula.getId();
		}
		model.addObject("jaulaId", jaulaId);
		model.addObject("listaJaula",jaulaRepo.findAll());
		
		return model;
	}
	
	@RequestMapping(value="/animal/{id}",method=RequestMethod.POST)
	public String salvarEditarAnimal(Animal animal, Integer jaulaId) {
		if (jaulaId != null) {
			Jaula jaula = jaulaRepo.findById(jaulaId).get();
			animal.setJaula(jaula);
			animalRepo.save(animal);
		}
		return "redirect:/animal/lista";
	}
}
