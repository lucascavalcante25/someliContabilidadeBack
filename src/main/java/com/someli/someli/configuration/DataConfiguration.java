package com.someli.someli.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/SomeliApp");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("postgres");
//		return dataSource;
	}

	  @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
	        dataSource.setUsername(System.getenv("SPRING_DATASOURCE_USERNAME"));
	        dataSource.setPassword(System.getenv("SPRING_DATASOURCE_PASSWORD"));
	        return dataSource;
	    }

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		return adapter;
	}
}