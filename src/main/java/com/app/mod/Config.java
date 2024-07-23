package com.app.mod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@ComponentScan(basePackages = "com.app.mod")
public class Config {

	@Bean
	public EntityManager getEntityManager() {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("dev");
		return factory.createEntityManager();
		}

	@Bean
	public EntityTransaction getTransaction() {
		return getEntityManager().getTransaction();
	}

	@Bean
	public ModelAndView getMV() {
		return new ModelAndView();
	}
}