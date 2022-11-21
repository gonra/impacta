package com.atos.atoszooapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.atoszooapi.model.Pessoa;
import com.atos.atoszooapi.repositories.PessoaRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepo;
	
	@GetMapping("/pessoa")
	public List<Pessoa> getAllPessoa(){
		return pessoaRepo.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
		Optional<Pessoa> p=pessoaRepo.findById(id);
		if (p.isPresent()) { 
			return ResponseEntity.ok(p.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/pessoa")
	public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa) {
		Pessoa p = pessoaRepo.save(pessoa);
		return  ResponseEntity.ok(p);
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<?> deletePessoa(@PathVariable Long id) {
		Optional<Pessoa> p = pessoaRepo.findById(id);
		if (p.isPresent()) {
			pessoaRepo.delete(p.get());
		} else {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}
}
