package br.atos.cadastro_plano_titular.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.atos.cadastro_plano_titular.model.UserModel;
import br.atos.cadastro_plano_titular.repository.UserRepository;



@Service // Indicar que uma classe de serviço
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	final UserRepository userRepository;
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	UserModel userModel = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado" + username));                       
		
		return new User(userModel.getUsername(), userModel.getPassword(),true,true,true,true, userModel.getAuthorities() );
	}
	


}
