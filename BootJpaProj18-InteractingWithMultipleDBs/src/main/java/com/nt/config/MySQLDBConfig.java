package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repository.offers",
                                                entityManagerFactoryRef = "mysqlEMF",
                                                transactionManagerRef = "mysqlTxMgmr")
public class MySQLDBConfig {

	
	@Bean(name="mysqlDS")
	@ConfigurationProperties(prefix = "msql.ds")
	public   DataSource  createOraDs() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlEMF")
	public   LocalContainerEntityManagerFactoryBean  createMySQLEMF(EntityManagerFactoryBuilder builder) {
		// prepare hibenrate-jpa properties
		 Map<String,Object>  map=new HashMap<String, Object>();
		 map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		 map.put("hibernate.hbm2ddl.auto", "update");
		 //use builder  to  create and return LocalContainerEntityManagerFactoryBean object(Indirectly EMF)
		 return  builder.dataSource(createOraDs())
				                    .packages("com.nt.entity.offers")
				                    .properties(map)
				                    .build();
		 
	}
	
	@Bean(name="mysqlTxMgmr")
	public   JpaTransactionManager   createOraTxMgmr(@Qualifier("mysqlEMF") EntityManagerFactory factory ) {
		return  new JpaTransactionManager(factory);
	}
}
