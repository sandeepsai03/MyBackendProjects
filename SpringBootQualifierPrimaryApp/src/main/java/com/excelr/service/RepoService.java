package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.excelr.dao.DatabaseRepo;

@Service
public class RepoService {

	@Autowired
	@Qualifier("oracle")
	private DatabaseRepo dbr;
	
	public void repoServiceMethod() {
		System.out.println("service method is executed..");
		dbr.getData();
	}
	
}
