package br.atos.cadastro_plano_titular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro_plano_titular.model.Dependente;
import br.atos.cadastro_plano_titular.model.Titular;
import br.atos.cadastro_plano_titular.repository.DependenteRepository;
import br.atos.cadastro_plano_titular.repository.TitularRepository;

@Controller // Indica que a classe é do tipo controlador
public class TitularController {

	@Autowired // Inicializa a classe TitularRepository em todas as chamadas 
	TitularRepository titularRepository;
	
	@Autowired// Inicializa a classe DependenteRepository  em todas as chamadas 
	DependenteRepository dependenteRepository;
	
	
	//Acessa a pagina de cadastrar o Titular
	@RequestMapping(value = "/cadastrarTitular", method=RequestMethod.GET) // Direciona o usuario para a pagina cadastroTitularHtml.html
	public String cadastroTitular() {
		
		return"cadastroTitularHtml";
	}
	
	// Metodo POST acionado pelo formulario de cadastrar um novo titular
	@RequestMapping(value = "/cadastrarTitular", method=RequestMethod.POST)//Metodo post que recebe a entidade
	public String cadastroTitular(Titular titular) {
		titularRepository.save(titular);
		return "redirect:/titularesTabela";
	}
	
	//Responsavel por direcionar e listar todos os titulares que foram encontrados no banco de dados
	@RequestMapping("/titularesTabela")// Metodo get que envia a lista de titulares
	public ModelAndView listarTitulares() {
		ModelAndView titularModelAndView = new ModelAndView("listarTitularesHtml"); // Objeto que recebe o "endereço de uma pagina HTML" e um ou mais objetos que também podem ser uma lista.
		Iterable<Titular> titulares= titularRepository.findAll(); // Busca todos titulares no banco de dados
		titularModelAndView.addObject("titulares", titulares);// Adiciona a lista de titulares no objeto "ModelAndView";
		
		
		return titularModelAndView;
		
	}
	
	// Responsavel por deletar um titular com base no ID que está sendo enviado no PATH (URL)
	@RequestMapping(value = "/deletarTitular/{id}", method = RequestMethod.GET)
	public String deletarTitularMetodo(@PathVariable ("id") long idReq) {
		Titular titular = titularRepository.findById(idReq); // Buscar o titular pelo ID
		titularRepository.delete(titular); // Acionar o metodo de deletar da classe CRUD REPOSITORY
		
		return "redirect:/titularesTabela";
	}
	
	//Responsavel por direcionar o usuario para o formulario de edição que já esta preenchido com os dados do titular selecionado
	@RequestMapping(value = "/editarTitular/{id}", method = RequestMethod.GET)
	public ModelAndView editarTitularMetodo(@PathVariable ("id") long idReq) {
		Titular titular = titularRepository.findById(idReq);
		
		ModelAndView titularAndView = new ModelAndView("editarTitular");
		titularAndView.addObject("titular", titular);
		
		
		
		return titularAndView;
	}
	
	//Metodo post responsavel por realizar a alteração do titular e o mesmo é acionado no action do formumlario da pagina editar.
	@PostMapping(value = "/editar")
	public String atualizarTitular(Titular titular) {
		long id = titular.getId();
		titularRepository.save(titular);
		
		
		
		return "redirect:/titularesTabela";
		
		
	}
	
	// Responsavel por direcionar o usuario para a pagina de adiciona um novo dependente para o titular selecionado, enviado todos o dependentes já registrados e o titular selecionado
	@RequestMapping(value = "/adicionarDependente/{id}", method = RequestMethod.GET)
	public ModelAndView adicionatDependenteMetodo(@PathVariable("id") long idReq) {
		Titular titular = titularRepository.findById(idReq);
		ModelAndView titularAndView = new ModelAndView("adicionarDependente");
		titularAndView.addObject("titular", titular);
		
		Iterable<Dependente> dependentes = dependenteRepository.findByTitular(titular); // Busca todos os dependentes referentes ao titular selecionado.
		titularAndView.addObject("dependentes", dependentes);
		
		return titularAndView;
		
	}
	
	//Adiciona o dependente ao titular selecionado - O mesmo é acionado no metodo post do formulario da pagina adicionar dependente
	@RequestMapping(value = "/adicionarDependente/{id}", method = RequestMethod.POST)
	public String adicionaDependente(@PathVariable("id") long idReq, Dependente dependente) {
		
		Titular titular = titularRepository.findById(idReq);
		dependente.setTitular(titular);
		dependenteRepository.save(dependente);
		
		return "redirect:/adicionarDependente/{id}";
		
	}
	
	
}
