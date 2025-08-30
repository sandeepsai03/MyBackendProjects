package com.excelr.repository;

import org.springframework.data.repository.CrudRepository;

import com.excelr.entity.Excelr;
import java.util.List;



public interface ExcelrRepository extends CrudRepository<Excelr,Integer>{

	public List<Excelr> findByEmpName(String empName);
	
	public List<Excelr> findByEmpNameAndEmpId(String empName,Integer empId);
	
	public List<Excelr> findByEmpSalGreaterThanEqual(Integer empSal);
	
	public List<Excelr> findByEmpSalIn(List<Integer> empSal);
}
