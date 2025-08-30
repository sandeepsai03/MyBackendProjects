package com.excelr;

import org.springframework.beans.factory.InitializingBean;

public class Engine implements InitializingBean {

	public Engine() {
	System.out.println("Engine class constructor is started");
	}

	@Override
	public void afterPropertiesSet() throws Exception {

System.out.println("afterpropertiesset or init method is executed");
		
	}
}
