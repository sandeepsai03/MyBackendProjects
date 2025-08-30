package com.excelr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.excelr.entity.Excelr;

public interface ExcelrRepository extends JpaRepository<Excelr,Integer>{

	///1)Native Sql query to fetch employee by name
	//Note :sql queries are based on table name and column names
	//while Hql queries are based on class name and variable names
	@Query(value="SELECT * from Excelr_Table where ename= :name",nativeQuery=true)
	List<Excelr> findEmployeeByNameNative(@Param("name") String name);//method name
	
	///1)Hql query to fetch employee by name
	@Query("From Excelr where empName= :name")
	List<Excelr> findEmployeesByNameHql(@Param("name") String name);
	
	///2)Native Sql query to count employees with salary greater than a certain amount
	@Query(value="SELECT COUNT(*) From Excelr_Table where esal> :salary",nativeQuery=true)
	long countEmployesWithSalaryGreaterThanNative(@Param("salary") int salary);
	
	///2)Hql query to count employees with salary greater than a certain amount
	@Query("select count(*) from Excelr e where e.empSal > :salary")
	long countEmployeeWithSalaryGreaterHql(@Param("salary") int salary);
	
}
