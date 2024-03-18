package com.suporte.helpdesk.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.suporte.helpdesk.security.JWTAuthenticationFilter;
import com.suporte.helpdesk.security.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final String[] PUBLIC_MATCHERS = { "/h2-console/**" };
	
	@Autowired
	private Environment env;
	@Autowired
	private JWTUtil jwtUtil;
	

	 @Bean
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 
		 if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
		       http.headers(heafers -> heafers.frameOptions().disable());
		       http.addFilter(new JWTAuthenticationFilter(AuthenticationManager, jwtUtil));

		 }
	        return http
	        .authorizeHttpRequests(
	            autoconfigure -> {
	                autoconfigure.requestMatchers("/chamados").permitAll();
	                autoconfigure.requestMatchers("/clientes").permitAll();
	                autoconfigure.requestMatchers("/tecnicos").permitAll();
	                autoconfigure.requestMatchers(PUBLIC_MATCHERS).permitAll();
	                autoconfigure.anyRequest().authenticated();
	            })
	        .csrf(csrf -> csrf.ignoringRequestMatchers(PUBLIC_MATCHERS))
	        .formLogin(Customizer.withDefaults())
	        .build();
	    }
	
	 
	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	
}
