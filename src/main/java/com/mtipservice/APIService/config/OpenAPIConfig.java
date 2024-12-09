package com.mtipservice.APIService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	
	@Autowired
	private BuildProperties buildProperties;
	
	@Bean
	public OpenAPI apiDocConfig() {
		return new OpenAPI().info(new Info().title("API Service").description("API Service")
				.version(buildProperties.getVersion())
				.contact(new Contact().name("MTIP Team").email("rohitmunny@gmail.com")));
	}
	
	/*@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.cors(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.authorizeHttpRequests((requests) -> requests
				.requestMatchers(new AntPathRequestMatcher("/actuator/**")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/v2/api-docs")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/swagger-resources")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/APIService/**")).permitAll()
				.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		//http.authorizeHttpRequests().anyRequest().permitAll();
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails admin = User.builder()
				.username("root")
				.password(passwordEncoder().encode("root"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public HttpFirewall cinfigureFirewall() {
		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
		strictHttpFirewall.setAllowedHttpMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE", "OPTIONS", "HEAD"));
		return strictHttpFirewall;
	}*/
	
	/*@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().anyRequest().permitAll();
		return http.build();
	}*/
}
