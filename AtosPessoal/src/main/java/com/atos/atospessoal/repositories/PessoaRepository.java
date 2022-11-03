package com.atos.atospessoal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.atospessoal.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
