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
import com.atos.atoszoo.model.Cuidador;
import com.atos.atoszoo.model.Jaula;
import com.atos.atoszoo.repositories.AnimalRepository;
import com.atos.atoszoo.repositories.CuidadorRepository;
import com.atos.atoszoo.repositories.JaulaRepository;

@Controller
public class JaulaController {
	
	@Autowired
	AnimalRepository animalRepo;
	
	@Autowired
	JaulaRepository jaulaRepo;
	
	@Autowired
	CuidadorRepository cuidadorRepo;
	
	@RequestMapping(value="/jaula",method=RequestMethod.GET)
	public String showJaula() {
		return "/novoJaula";
	}
	
	@RequestMapping(value="/jaula",method=RequestMethod.POST)
	public String addJaula(Jaula jaula){
		jaula.setListaAnimais(null);
		jaula.setListaCuidadores(null);
		Jaula c = jaulaRepo.save(jaula);
		return "redirect:/jaula/lista";
	}
	
	@RequestMapping(value="/jaula/lista",method=RequestMethod.GET)
	public ModelAndView listarJaula() {
		ModelAndView model = new ModelAndView("listaJaula");
		List<Jaula> lista = new ArrayList<>();
		for(Jaula cli : jaulaRepo.findAll()) {
			lista.add(cli);
		}
		
		model.addObject("listaJaula",lista);	
		return model;
	}
	
	@RequestMapping(value="/jaula/delete/{id}",method=RequestMethod.GET)
	public String deletarJaula(@PathVariable("id") Integer id) {
		Jaula jaula = jaulaRepo.findById(id).get();
		if (jaula.getListaAnimais().size() > 0) {
			return "redirect:/jaula/" + id + "/lista";
		}
		if (jaula.getListaCuidadores().size() > 0) {
			return "redirect:/jaula/" + id + "/cuidador";
		}
        jaulaRepo.deleteById(id);
		return "redirect:/jaula/lista";
	}
	
	@RequestMapping(value="/jaula/{id}",method=RequestMethod.GET)
	public ModelAndView editarJaula(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("editarJaula");
		Jaula jaula = jaulaRepo.findById(id).get();
		model.addObject("jaula",jaula);
		
		return model;
	}
	
	@RequestMapping(value="/jaula/{id}",method=RequestMethod.POST)
	public String salvarEditarJaula(Jaula jaula) {
		jaulaRepo.save(jaula);
		return "redirect:/jaula/lista";
	}
	
	@RequestMapping(value="/jaula/{id}/lista",method=RequestMethod.GET)
	public ModelAndView editarAnimalJaula(@PathVariable("id") Integer idJaula) {
		ModelAndView model = new ModelAndView("listaAnimalJaula");
		Jaula jaula = jaulaRepo.findById(idJaula).get();
		model.addObject("jaula",jaula);
		model.addObject("listaAnimal", jaula.getListaAnimais() );
		return model;
	}
	
	@RequestMapping(value="/jaula/{id}/animal/{idAnimal}/delete",method=RequestMethod.GET)
	public String deletarAnimalJaula(@PathVariable("id") Integer idJaula, @PathVariable("idAnimal") Integer idAnimal) {
		
		Jaula jaula = jaulaRepo.findById(idJaula).get();
		Animal animal = animalRepo.findById(idAnimal).get();
		
		animal.setJaula(null);
		animalRepo.save(animal);
		return "redirect:/jaula/"+idJaula+"/lista";
	}

	@RequestMapping(value="/jaula/{id}/cuidador",method=RequestMethod.GET)
	public ModelAndView editarCuidadorJaula(@PathVariable("id") Integer idJaula) {
		ModelAndView model = new ModelAndView("listaCuidadorJaula");
		Jaula jaula = jaulaRepo.findById(idJaula).get();
		model.addObject("jaula",jaula);
		
		List<Cuidador> listaCuidador = new ArrayList<>();
		for (Cuidador x : cuidadorRepo.findAll()) {
			if(jaula.getListaCuidadores().indexOf(x) < 0) {
				listaCuidador.add(x);
			}
		}
		model.addObject("listaCuidador", listaCuidador );
		return model;
	}
}
