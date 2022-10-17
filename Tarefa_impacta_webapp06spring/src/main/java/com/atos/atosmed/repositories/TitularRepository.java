package com.atos.atosmed.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atos.atosmed.model.Titular;

@Repository
public interface TitularRepository extends CrudRepository<Titular, Integer>  {

}
