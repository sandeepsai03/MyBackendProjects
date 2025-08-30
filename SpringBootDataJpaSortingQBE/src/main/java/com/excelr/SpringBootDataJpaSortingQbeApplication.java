package com.excelr;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.excelr.entity.Excelr;
import com.excelr.repository.ExcelrRepository;

@SpringBootApplication
public class SpringBootDataJpaSortingQbeApplication {

	public static void main(String[] args) {
	ApplicationContext con=SpringApplication.run(SpringBootDataJpaSortingQbeApplication.class, args);
	
	//getBean
	ExcelrRepository repo=con.getBean(ExcelrRepository.class);
/*	Excelr e1=new Excelr();
	e1.setEmpId(101);
	e1.setEmpName("saisandeep");
	e1.setEmpSal(50000);
	
 repo.save(e1);
	System.out.println("one record data is inserted");
	
	//inserting multiple records
	Excelr e3=new Excelr(102,"ravi",4000);
	Excelr e4=new Excelr(103,"sai",6000);
	Excelr e5=new Excelr(104,"venky",9000);
	 
	repo.saveAll(Arrays.asList(e3,e4,e5));*/
	
	///selecting a record based on asc sorting by esal
	List<Excelr> res=repo.findAll(Sort.by("empSal"));
	res.forEach(x->System.out.println(x));
	
	///selecting  a record baesd on desc sorting by esal
	List<Excelr> aaa=repo.findAll(Sort.by("empSal").descending());
	aaa.forEach(y->System.out.println(y));
	
	///selecting dynamically like filter by using QBE
	//QBE:It is used to create queries dynamically by using probe(i.e sample entity object) in Example.of()
	//instead of writing this
	//List<Excelr> findByEmpIdAndEmpName(Integer empId, String empName);
	//we can write below code
	 Excelr e2=new Excelr();
	 e2.setEmpId(101);
	 e2.setEmpName("saisandeep");
	 
	 Example<Excelr> res1=Example.of(e2);
	 List<Excelr> ss=repo.findAll(res1);
	 ss.forEach(x->System.out.println(x));
	 ///the above code dynamically generate a query like:
	 ///SELECT * FROM emp_table WHERE eid = 101 AND ename = 'saisandeep';
	}

}
