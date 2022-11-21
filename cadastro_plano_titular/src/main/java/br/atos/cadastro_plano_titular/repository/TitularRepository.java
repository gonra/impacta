package br.atos.cadastro_plano_titular.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_plano_titular.model.Titular;
//Implementa os metodos do crdu(create, read, update, delete)

// Interface que implementa os metodos de salvar, alterar, ler  e deletar (CRUD) - Herda os metodos da classe CrudRepository 
public interface TitularRepository extends CrudRepository<Titular, Long> {
	Titular findById(long id);
}
