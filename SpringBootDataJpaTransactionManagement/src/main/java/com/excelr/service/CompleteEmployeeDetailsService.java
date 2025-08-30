package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Address;
import com.excelr.entity.Employee;
import com.excelr.repository.AddressRepositoy;
import com.excelr.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class CompleteEmployeeDetailsService {

	@Autowired
	private AddressRepositoy adr;
	
    @Autowired
	private EmployeeRepository empr;
	
	@Transactional(rollbackOn=Exception.class)
	public void saveData() {
		Employee e1=new Employee();
		e1.setEmpId(101);
		e1.setEmpName("saisandeep");
		
		empr.save(e1);
		
		//int a=10/0;//because of this error ,save() not saves the data into the database .This is because of @Transactional(rollbackOn=Exception.class)
		Address a1=new Address();
		a1.setAddrId(7890);
		a1.setCity("Hyd");
		a1.setEmpId(102);
		
		adr.save(a1);
	}
	
}
