package com.grego.MasterClass_Javier_Integrative_Class;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MasterClassJavierIntegrativeClassApplication {

	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(MasterClassJavierIntegrativeClassApplication.class, args);
	}

}
