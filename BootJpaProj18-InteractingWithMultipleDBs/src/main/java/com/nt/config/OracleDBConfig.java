package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.prod",
                                                entityManagerFactoryRef = "oraEMF",
                                                transactionManagerRef = "oraTxMgmr")

public class OracleDBConfig {

	
	@Bean(name="oraDS")
	@ConfigurationProperties(prefix = "ora.ds")
	@Primary
	public   DataSource  createOraDs() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="oraEMF")
	@Primary
	public   LocalContainerEntityManagerFactoryBean  createOraEMF(EntityManagerFactoryBuilder builder) {
		// prepare hibenrate-jpa properties
		 Map<String,Object>  map=new HashMap<String, Object>();
		 map.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		 map.put("hibernate.hbm2ddl.auto", "update");
		 //use builder  to  create and return LocalContainerEntityManagerFactoryBean object(Indirectly EMF)
		 return  builder.dataSource(createOraDs())
				                    .packages("com.nt.entity.prod")
				                    .properties(map)
				                    .build();
		 
	}
	
	@Bean(name="oraTxMgmr")
	@Primary
	public   JpaTransactionManager   createOraTxMgmr(@Qualifier("oraEMF") EntityManagerFactory factory ) {
		return  new JpaTransactionManager(factory);
	}
}
