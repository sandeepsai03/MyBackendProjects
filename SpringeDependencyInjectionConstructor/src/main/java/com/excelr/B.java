package com.excelr;

public class B {

	///field dependency injection
	private A aa;

	///Constructor dependency injection
	//if incase manual autowiring not do then it is called partialdependency then we will get complietime error
	public B(A aa) {
		super();
		this.aa = aa;
	}


	public void bClassMethod() {
		System.out.println("b class method executed");
		aa.aClassMethod();
	}

	
}
