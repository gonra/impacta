package br.atos.cadastro_plano_titular.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.atos.cadastro_plano_titular.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
	Optional<UserModel> findByUserName(String userName);
	
	
}
