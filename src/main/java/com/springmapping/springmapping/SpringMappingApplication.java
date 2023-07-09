package com.springmapping.springmapping;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringMappingApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringMappingApplication.class, args);
	}
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}


}
