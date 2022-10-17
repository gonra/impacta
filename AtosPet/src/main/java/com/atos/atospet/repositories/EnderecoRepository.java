package com.atos.atospet.repositories;

import org.springframework.data.repository.CrudRepository;

import com.atos.atospet.model.Cliente;
import com.atos.atospet.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco,Integer>{

}
