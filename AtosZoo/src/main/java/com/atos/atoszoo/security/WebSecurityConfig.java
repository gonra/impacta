package com.atos.atoszoo.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers(HttpMethod.GET,"/").permitAll()
        	.antMatchers(HttpMethod.GET,"/cuidador/**").hasRole("ADMIN")
        	.anyRequest().authenticated()
        	.and().formLogin().defaultSuccessUrl("/jaula/lista").permitAll()
        	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		return http.build();
	}
	/*
	 * */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
