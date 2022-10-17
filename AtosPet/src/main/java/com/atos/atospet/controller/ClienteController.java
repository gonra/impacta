package com.atos.atospet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atos.atospet.model.Pet;
import com.atos.atospet.model.Cliente;
import com.atos.atospet.model.Endereco;
import com.atos.atospet.repositories.PetRepository;
import com.atos.atospet.repositories.ClienteRepository;
import com.atos.atospet.repositories.EnderecoRepository;

@Controller
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	EnderecoRepository enderecoRepo;
		
	@Autowired
	PetRepository petRepo;
	
	@RequestMapping("/")
	public String showIndex() {
		return "redirect:/cliente/lista";
	}
	
	@RequestMapping(value="/cliente",method=RequestMethod.GET)
	public String showCliente() {
		return "/cliente";
	}
	
	@RequestMapping(value="/cliente",method=RequestMethod.POST)
	public String addCliente(Cliente cliente){
		Cliente c = clienteRepo.save(cliente);
		Endereco e = cliente.getEndereco();
		e.setCliente(c);
		enderecoRepo.save(e);
		return "redirect:/cliente/lista";
	}
	
	@RequestMapping(value="/cliente/lista",method=RequestMethod.GET)
	public ModelAndView listarCliente() {
		ModelAndView model = new ModelAndView("listacliente");
//		Iterable<Cliente> lista = clienteRepo.findAll();
		List<Cliente> lista = new ArrayList<>();
		for(Cliente cli : clienteRepo.findAll()) {
			Cliente c = cli;
			//Endereco e = enderecoRepo.findByCliente(cli);
			//c.setEndereco(e);
			lista.add(c);
		}
		
		model.addObject("clientes",lista);
		
		return model;
		
	}
	
	@RequestMapping(value="/cliente/delete/{id}",method=RequestMethod.GET)
	public String deletarCliente(@PathVariable("id") Integer id) {

        clienteRepo.deleteById(id);
		
		return "redirect:/cliente/lista";
		
	}
	
	@RequestMapping(value="/cliente/{id}",method=RequestMethod.GET)
	public ModelAndView editarCliente(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("editarCliente");
		Optional<Cliente> cliente = clienteRepo.findById(id);
		model.addObject("cliente",cliente.get());
		model.addObject("endereco", cliente.get().getEndereco());
		
		return model;
	}
	
	@RequestMapping(value="/cliente/{id}",method=RequestMethod.POST)
	public String salvarEditarCliente(Cliente cliente, Endereco endereco) {
		cliente.getEndereco().setCliente(cliente);
		clienteRepo.save(cliente);
		return "redirect:/cliente/lista";
	}

	@RequestMapping(value="/cliente/{id}/pet",method=RequestMethod.GET)
	public ModelAndView addPetCliente(@PathVariable("id") Integer id) {	
		ModelAndView model = new ModelAndView("pet");
		Cliente cliente = clienteRepo.findById(id).get();
		model.addObject("idcliente",id);
		model.addObject("nomecliente",cliente.getNome());
		
		return model;
	}
	
	@RequestMapping(value="/cliente/{id}/pet",method=RequestMethod.POST)
	public String salvarPetCliente(@PathVariable("id") Integer id, Pet pet) {
		pet.setId(null);
		Cliente cliente = clienteRepo.findById(id).get();
		pet.setCliente(cliente);
		Pet p = petRepo.save(pet);
		cliente.getListaPet().add(p);
		Cliente c=clienteRepo.save(cliente);		
		return "redirect:/cliente/" + cliente.getId() + "/pet/lista";
	}
	
	@RequestMapping(value="/cliente/{id}/pet/lista",method=RequestMethod.GET)
	public ModelAndView listaPetCliente(@PathVariable("id") Integer id) {
		ModelAndView model = new ModelAndView("listaPetCliente");
		Cliente cliente = clienteRepo.findById(id).get();
		model.addObject("cliente",cliente);
		return model;
	}
	
	@RequestMapping(value="/cliente/{id}/pet/delete/{petid}",method=RequestMethod.GET)
	public String deletarPetCliente(@PathVariable("id") Integer id,
									@PathVariable("petid") Integer petId) {

        petRepo.deleteById(petId);
		
		return "redirect:/cliente/lista";
		
	}

	@RequestMapping(value="/cliente/{id}/pet/{petid}",method=RequestMethod.GET)
	public ModelAndView editarPetCliente(@PathVariable("id") Integer id,
			                             @PathVariable("petid") Integer petId) {	
		ModelAndView model = new ModelAndView("editarPet");
		Cliente cliente = clienteRepo.findById(id).get();
		model.addObject("idcliente",id);
		model.addObject("nomecliente",cliente.getNome());
		Pet pet = petRepo.findById(petId).get();
		model.addObject("pet",pet);
		
		return model;
	}

	@RequestMapping(value="/cliente/{id}/pet/{petid}",method=RequestMethod.POST)
	public String salvarPetCliente(@PathVariable("id") Integer id,
			                             @PathVariable("petid") Integer petId,
			                             Pet pet) {			
		pet.setId(petId);
		Cliente cliente = clienteRepo.findById(id).get();
		pet.setCliente(cliente);
		Pet p = petRepo.save(pet);
		
		return "redirect:/cliente/" + id + "/pet/lista";
	}
	
	@RequestMapping(value="/pet/lista",method=RequestMethod.GET)
	public String listaPet() {
		
		for(Pet p: petRepo.findAll()) {
			System.out.println(p.toString());
			System.out.println(p.getCliente());
		}
		return "redirect:/cliente/lista";
	}
}
