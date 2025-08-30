package com.excelr;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.excelr.entity.Excelr;
import com.excelr.repository.ExcelrRepository;

@SpringBootApplication
public class SpringBootDataJpaApp1Application {

    private final ExcelrRepository excelrRepository;

    SpringBootDataJpaApp1Application(ExcelrRepository excelrRepository) {
        this.excelrRepository = excelrRepository;
    }

	public static void main(String[] args) {
		//IOC container
		ApplicationContext con=SpringApplication.run(SpringBootDataJpaApp1Application.class, args);
		
		ExcelrRepository repo=con.getBean(ExcelrRepository.class);
		
		///select a record based on empName
		List<Excelr> res=repo.findByEmpName("subha");
		res.forEach(x->System.out.println(x));
			
		List<Excelr> res2=repo.findByEmpNameAndEmpId("subha",104);
		res2.forEach(y->System.out.println(y));
		
		List<Excelr> res3=repo.findByEmpSalGreaterThanEqual(3000);
		res3.forEach(z->System.out.println(z));
		
		List<Excelr> res4=repo.findByEmpSalIn(Arrays.asList(4000));
		res4.forEach(p->System.out.println(p));
	
	
	}

}
