package com.atos.atoszooapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.atoszooapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
