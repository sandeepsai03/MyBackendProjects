package com.excelr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

	///Field dependency injection
//	@Autowired
	private A a1;

	///setter dependency injection
//	@Autowired
	/*public void setA1(A a1) {
		this.a1 = a1;
	}*/
	
	///constructor dependency injection
//	@Autowired  //Note:@Autowired annotation is optional in springBoot level in constructor type
	public B(A a1) {
		super();
		this.a1 = a1;
	}
	
	public void bClassMethod() {
		a1.aClassMethod();
		System.out.println("B class method executed");
	}
	
}
