package com.kozmoz.Kozmoz_CH61_equipo_2_backend;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KozmozCh61Equipo2BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KozmozCh61Equipo2BackendApplication.class, args);
	} // main
	
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<JwtFilter>();
		registrationBean.setFilter(new JwtFilter());
		
		registrationBean.addUrlPatterns("/api/productos/*");
		registrationBean.addUrlPatterns("/api/usuarios/*");
		return registrationBean;
	}//jwtFilter - despues del token
	
}//  KozmozCh61Equipo2BackendApplication
