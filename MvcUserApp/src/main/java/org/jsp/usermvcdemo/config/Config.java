package org.jsp.usermvcdemo.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = {"org.jsp.usermvcdemo"} )
public class Config {
	@Bean
   public EntityManager getEntityManager() {
	   return Persistence.createEntityManagerFactory("dev").createEntityManager();
   }
}
