package com.app.customermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		  http
	        .cors(Customizer.withDefaults()) // ✅ Bật CORS
	        .csrf(csrf -> csrf.disable())    // ✅ Disable CSRF cho REST API
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // ✅ Cho phép OPTIONS
	            .requestMatchers(HttpMethod.POST,"/oauth2/exchange-token").permitAll()
	            .requestMatchers(HttpMethod.POST,"/oauth2/exchange-token","/oauth2/refresh-token").permitAll()
	            .anyRequest().authenticated()
	        )
	        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
		return http.build();
	}
	
}
