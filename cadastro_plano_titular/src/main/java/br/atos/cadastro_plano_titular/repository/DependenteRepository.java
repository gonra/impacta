package br.atos.cadastro_plano_titular.repository;

import org.springframework.data.repository.CrudRepository;

import br.atos.cadastro_plano_titular.model.Dependente;
import br.atos.cadastro_plano_titular.model.Titular;

public interface DependenteRepository extends CrudRepository<Dependente, Long> {

	Iterable<Dependente> findByTitular(Titular titular);
	Dependente findById(long id);
	
}
