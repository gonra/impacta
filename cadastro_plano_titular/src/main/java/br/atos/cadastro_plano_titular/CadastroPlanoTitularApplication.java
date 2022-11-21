package br.atos.cadastro_plano_titular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CadastroPlanoTitularApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPlanoTitularApplication.class, args);
		
		System.out.println(new BCryptPasswordEncoder().encode("Senha"));
	}

}
