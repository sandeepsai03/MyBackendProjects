package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.excelr.service.RepoService;

@SpringBootApplication
public class SpringBootQualifierPrimaryAppApplication {

	public static void main(String[] args) {
		
		ApplicationContext con=SpringApplication.run(SpringBootQualifierPrimaryAppApplication.class, args);
		
		RepoService rs=con.getBean(RepoService.class);
		rs.repoServiceMethod();
	}

}
