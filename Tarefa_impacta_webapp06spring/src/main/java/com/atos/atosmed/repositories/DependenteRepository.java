package com.atos.atosmed.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atos.atosmed.model.Dependente;

@Repository
public interface DependenteRepository  extends CrudRepository<Dependente,Integer>{

}
