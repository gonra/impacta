package com.atos.atoszoo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.atoszoo.model.UserModel;
import com.atos.atoszoo.repositories.UserRepository;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	final UserRepository userRepo;
	
	public UserDetailServiceImpl(UserRepository userRep) {
		this.userRepo = userRep;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	UserModel userModel = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado" + username));                       
		
		return new User(userModel.getUsername(), userModel.getPassword(),true,true,true,true, userModel.getAuthorities() );
	}
	
}
