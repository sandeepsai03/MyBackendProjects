package com.excelr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;

public class Engine {

	public Engine() {
	System.out.println("Engine class constructor is started");
	}

	@PostConstruct
	public void init() {
		System.out.println("init method called");
	}
  
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method called");
	}
}
