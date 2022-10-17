package com.atos.atospet.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atos.atospet.model.Cliente;
import com.atos.atospet.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Integer>{

}
