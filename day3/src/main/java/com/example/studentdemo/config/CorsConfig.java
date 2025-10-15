package com.example.studentdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	@Bean
	public WebMvcConfigurer CorsConfigurer() {
	   return new WebMvcConfigurer() {
		 @Override
		 public  void  addCorsMappings(CorsRegistry registy)
		 {
			 registy.addMapping("/**").allowedOrigins("*")
			 .allowedMethods("GET","POST","PUT","DELETE")
			      .allowedHeaders("*");
			 
		 }
	 };
	}
    
}