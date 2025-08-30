package com.excelr;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
		
				
		  
		 ///insert single record 
	/* Excelr e1=new Excelr();
		
	    e1.setEmpId(104);
		e1.setEmpName("subha");
		e1.setEmpSal(10000);
		
		repo.save(e1);
		System.out.println("Data inserted successfully");*/
		
		///insert multiple records
     /*	Excelr e2=new Excelr(105,"teja",6789);
		Excelr e3=new Excelr(106,"venky",3456);
		Excelr e4=new Excelr(107,"mahesh",5689);
		
		repo.saveAll(Arrays.asList(e2,e3,e4));
		System.out.println("mulitiple records inserted successfully")*/
		
		///counting total n.o of records
		long l=repo.count();
		System.out.println("Total n.o of records "+l);
		
		///checking a record based on id
		boolean res=repo.existsById(105);
		System.out.println(res);
		
		///select a record based on id
		Optional<Excelr> s1=repo.findById(105);//Option class is used for to avoid nullpointer exception
		if(s1.isPresent()) {                   //here incase record is not there then this method gives nullpointer exception ,which is handled by option class
			System.out.println(s1.get());
		}
		
		///select a multiple recordss based on id
	Iterable<Excelr> s2=repo.findAllById(Arrays.asList(104,105,106));
	s2.forEach(emp->{
		System.out.println(emp);
	});
		
	///select all records
	Iterable<Excelr> s3=repo.findAll();
	s3.forEach(x->System.out.println(x));

	///delete a single record baesd on id
	/*repo.deleteById(107);
	System.out.println("record is deleted");*/
	
	///delete mulitiple records based on ids
/*	repo.deleteAllById(Arrays.asList(101,102));
	System.out.println("multiple records are deleted ");*/
	
	///delete all records
/*	repo.deleteAll();
	System.out.println("All records deleted");*/
	
	}

}
