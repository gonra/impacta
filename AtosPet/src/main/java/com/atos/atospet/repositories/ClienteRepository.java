package com.atos.atospet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.atos.atospet.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

}
