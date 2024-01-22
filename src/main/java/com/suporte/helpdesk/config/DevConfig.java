package com.suporte.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.suporte.helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	public String instanciaDB() {
		if (value.equals("create")) {
			this.dbService.instanciaDB();
			
//		}
	return "Adicionando carga de dados!"; 

	}
}
