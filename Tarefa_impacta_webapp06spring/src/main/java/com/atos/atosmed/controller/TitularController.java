package com.atos.atosmed.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atos.atosmed.model.Dependente;
import com.atos.atosmed.model.Titular;
import com.atos.atosmed.repositories.DependenteRepository;
import com.atos.atosmed.repositories.TitularRepository;

@Controller
public class TitularController {

	@Autowired
	TitularRepository titularRepo;
	
	@Autowired
	DependenteRepository dependenteRepo;
	
	@RequestMapping(value="/titular",method=RequestMethod.GET)
	public String showTitular() {
		return "titular";
	}
	
	@RequestMapping(value="/titular",method=RequestMethod.POST)
	public String addTitular(Titular titular){
		titularRepo.save(titular);
		
		return "titular";
	}
	
	@RequestMapping(value="/titular/lista",method=RequestMethod.GET)
	public ModelAndView listarTitular() {
		ModelAndView model = new ModelAndView("listatitular");
		Iterable<Titular> lista = titularRepo.findAll();
		model.addObject("titulares",lista);
		
		return model;
		
	}
	
	@RequestMapping(value="/titular/delete/{id}",method=RequestMethod.GET)
	public String deletarTitular(@PathVariable("id") Integer id) {

        titularRepo.deleteById(id);
		
		return "redirect:/titular/lista";
		
	}
	
	@RequestMapping(value="/titular/{id}",method=RequestMethod.GET)
	public ModelAndView editarTitular(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("editarTitular");
		Optional<Titular> titular = titularRepo.findById(id);
		model.addObject("titular",titular.get());
		
		return model;
	}
	
	@RequestMapping(value="/titular/{id}",method=RequestMethod.POST)
	public String salvarEditarTitular(Titular titular) {
		titularRepo.save(titular);
		return "redirect:/titular/lista";
	}

	@RequestMapping(value="/titular/{id}/dependente",method=RequestMethod.GET)
	public String addDependenteTitular(@PathVariable("id") Integer id) {	
		return "dependente";
	}
	
	@RequestMapping(value="/titular/{id}/dependente",method=RequestMethod.POST)
	public String salvarDependenteTitular(@PathVariable("id") Integer id,
			Dependente dependente) {
		Titular titular = titularRepo.findById(id).get();
		dependente.setTitular(titular);
		dependenteRepo.save(dependente);
		return "redirect:/titular/" + titular.getId() + "/dependente";
	}
	
	@RequestMapping(value="/titular/{id}/dependente/lista",method=RequestMethod.GET)
	public ModelAndView listaDependenteTitular(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("listaDependenteTitular");
		Optional<Titular> titular = titularRepo.findById(id);
		model.addObject("titular",titular.get());
		
		return model;
	}
}
