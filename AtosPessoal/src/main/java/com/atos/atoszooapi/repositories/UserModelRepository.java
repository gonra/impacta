package com.atos.atoszooapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atos.atoszooapi.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel,Long>{
	Optional<UserModel> findByUsername(String username);
}
