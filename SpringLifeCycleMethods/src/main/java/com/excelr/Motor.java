package com.excelr;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Motor implements DisposableBean{
public Motor() {
	System.out.println("Motor class constructor is started");
}

@Override
public void destroy() throws Exception {

System.out.println("destroy method executed");
	
}




}

