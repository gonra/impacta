package com.atos.atoszoo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atos.atoszoo.model.Cuidador;
import com.atos.atoszoo.model.Jaula;
import com.atos.atoszoo.repositories.CuidadorRepository;
import com.atos.atoszoo.repositories.JaulaRepository;

@Controller
public class CuidadorController {

	@Autowired
	CuidadorRepository cuidadorRepo;
	
	@Autowired
	JaulaRepository jaulaRepo;
	
	@RequestMapping(value="/cuidador",method=RequestMethod.GET)
	public String showCuidador() {
		return "/novoCuidador";
	}
	
	@RequestMapping(value="/cuidador",method=RequestMethod.POST)
	public String addCuidador(Cuidador cuidador){
		cuidador.setListaJaulas(null);
		Cuidador c = cuidadorRepo.save(cuidador);
		
		return "redirect:/cuidador/lista";
	}
	
	@RequestMapping(value="/cuidador/lista",method=RequestMethod.GET)
	public ModelAndView listarCuidador() {
		ModelAndView model = new ModelAndView("listaCuidador");
		List<Cuidador> lista = new ArrayList<>();
		for(Cuidador cli : cuidadorRepo.findAll()) {
			lista.add(cli);
		}
		
		model.addObject("cuidadores",lista);	
		return model;
	}
	
	@RequestMapping(value="/cuidador/delete/{id}",method=RequestMethod.GET)
	public String deletarCuidador(@PathVariable("id") Integer id) {

        cuidadorRepo.deleteById(id);
		return "redirect:/cuidador/lista";
	}
	
	@RequestMapping(value="/cuidador/{id}",method=RequestMethod.GET)
	public ModelAndView editarCuidador(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("editarCuidador");
		Cuidador cuidador = cuidadorRepo.findById(id).get();
		model.addObject("cuidador",cuidador);
		model.addObject("jaulas", cuidador.getListaJaulas());
		
		return model;
	}
	
	@RequestMapping(value="/cuidador/{id}",method=RequestMethod.POST)
	public String salvarEditarCuidador(Cuidador cuidador) {
		cuidadorRepo.save(cuidador);
		return "redirect:/cuidador/lista";
	}
	
	@RequestMapping(value="/cuidador/{id}/jaula",method=RequestMethod.GET)
	public ModelAndView addJaulaCuidador(@PathVariable("id") Integer id) {	
		ModelAndView model = new ModelAndView("listaJaulaCuidador");
		Cuidador cuidador = cuidadorRepo.findById(id).get();
		model.addObject("cuidador",cuidador);		
		List<Jaula> listaJaula = new ArrayList<>();
		for (Jaula x : jaulaRepo.findAll()) {
			if(cuidador.getListaJaulas().indexOf(x) < 0) {
				listaJaula.add(x);
			}
		}
		model.addObject("listaJaula",listaJaula);
		
		return model;
	}
	
	@RequestMapping(value="/cuidador/{id}/jaula",method=RequestMethod.POST)
	public String salvarJaulaCuidador(@PathVariable("id") Integer id, Integer idJaula) {
		Jaula jaula = jaulaRepo.findById(idJaula).get();
		Cuidador cuidador = cuidadorRepo.findById(id).get();
		jaula.getListaCuidadores().add(cuidador);
		jaulaRepo.save(jaula);
		cuidador.getListaJaulas().add(jaula);
		cuidadorRepo.save(cuidador);
		return "redirect:/cuidador/" + id + "/jaula";
	}
	
	@RequestMapping(value="/cuidador/{id}/jaula/{idJaula}/delete",method=RequestMethod.GET)
	public String deletarJaulaCuidador(@PathVariable("id") Integer id, @PathVariable("idJaula") Integer idJaula) {
		Jaula jaula = jaulaRepo.findById(idJaula).get();
		Cuidador cuidador = cuidadorRepo.findById(id).get();
		jaula.getListaCuidadores().remove(cuidador);
		jaulaRepo.save(jaula);
		cuidador.getListaJaulas().remove(jaula);
		cuidadorRepo.save(cuidador);
		return "redirect:/cuidador/" + id + "/jaula";
	}
	
}
