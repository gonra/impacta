package br.atos.cadastro_plano_titular.data;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration// Indica que é uma classe de configuração
public class DataConfiguration {

	@Bean // Conexão com o banco de dados
	public DataSource dataSource() {
		
		DriverManagerDataSource driveBanco = new DriverManagerDataSource();
		driveBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driveBanco.setUrl("jdbc:mysql://bu75kyusmkci93tgxxay-mysql.services.clever-cloud.com/bu75kyusmkci93tgxxay");
		driveBanco.setUsername("upw16xohyco3yj3z");
		driveBanco.setPassword("xfmVyi3wlguAqM9mY8hc");
		return driveBanco;
	
	}
	@Bean // Parametros do Hibernate
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
		adapter.setPrepareConnection(true);
		
		
		return adapter;
		
	}
	
	
	
}
