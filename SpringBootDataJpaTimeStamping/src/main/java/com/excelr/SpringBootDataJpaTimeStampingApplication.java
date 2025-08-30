package com.excelr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.excelr.entity.Product;
import com.excelr.repository.ProductRepository;

@SpringBootApplication
public class SpringBootDataJpaTimeStampingApplication {

	public static void main(String[] args) {
	//IOC starts
		ApplicationContext con=SpringApplication.run(SpringBootDataJpaTimeStampingApplication.class, args);
		
		//call getBean()
		ProductRepository repo=con.getBean(ProductRepository.class);
		
		Product p1=new Product();
		///insert the data
		/*p1.setPname("laptop");
		p1.setPrice(50000);
		
		repo.save(p1);*/
		
		///update the data
		p1.setPid(1);
		p1.setPname("laptop");
		p1.setPrice(60000);
		
		repo.save(p1);
	}

}
