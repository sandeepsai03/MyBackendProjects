package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.excelr.service.CompleteEmployeeDetailsService;

@SpringBootApplication
public class SpringBootDataJpaTransactionManagementApplication {

	public static void main(String[] args) {
	
		//IOC starts
		ApplicationContext	con=SpringApplication.run(SpringBootDataJpaTransactionManagementApplication.class, args);
		
		CompleteEmployeeDetailsService cr=con.getBean(CompleteEmployeeDetailsService.class);
		
		cr.saveData();
	}

}
