package com.excelr.dao;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleIml implements DatabaseRepo {

	@Override
	public void getData() {

System.out.println("Data is sending from oracle");
		
	}

}
