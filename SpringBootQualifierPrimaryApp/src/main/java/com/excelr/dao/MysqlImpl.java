package com.excelr.dao;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MysqlImpl implements DatabaseRepo{

	@Override
	public void getData() {

System.out.println("data sending from mysql ");
		
	}

}
