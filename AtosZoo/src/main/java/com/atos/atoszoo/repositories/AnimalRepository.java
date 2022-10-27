package com.atos.atoszoo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.atos.atoszoo.model.Animal;

public interface AnimalRepository  extends CrudRepository<Animal,Integer>{

}
