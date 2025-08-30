package com.excelr;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.excelr.entity.Excelr;
import com.excelr.repository.ExcelrRepository;


@SpringBootApplication
public class SpringBootDataJpaCustomQueriesApplication {

    private final ExcelrRepository excelrRepository;

    SpringBootDataJpaCustomQueriesApplication(ExcelrRepository excelrRepository) {
        this.excelrRepository = excelrRepository;
    }

	public static void main(String[] args) {
    
		//IOC starts
		ApplicationContext con=SpringApplication.run(SpringBootDataJpaCustomQueriesApplication.class, args);
		
		//call getBean()
		ExcelrRepository repo=con.getBean(ExcelrRepository.class);
		
		Excelr e1=new Excelr(101,"saisandeep",50000);
		Excelr e2=new Excelr(102,"venky",40000);
		Excelr e3=new Excelr(103,"sandeep",20000);
		Excelr e4=new Excelr(104,"ravi",30000);
		
		repo.saveAll(Arrays.asList(e1,e2,e3,e4));
		
		///Native sql query
		List<Excelr> res=repo.findEmployeeByNameNative("venky");
		res.forEach(x->System.out.println(x));
		
		///Hql query
		List<Excelr> res1=repo.findEmployeesByNameHql("venky");
		res1.forEach(x->System.out.println(x));
		
		///Native sql query
		long res2=repo.countEmployesWithSalaryGreaterThanNative(20000);
		System.out.println(res2);
		
		///Hql query
		long res3=repo.countEmployeeWithSalaryGreaterHql(20000);
		System.out.println(res3);
		
	}

}
