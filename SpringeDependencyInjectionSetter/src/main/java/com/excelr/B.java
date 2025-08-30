package com.excelr;

public class B {

	///field dependency injection
	private A aa;

	///setter dependency injection
	//if incase manual autowiring not do then it is called partialdependency then we will get NullPointerException
	public void setAa(A aa) {
		this.aa = aa;
	}


	public void bClassMethod() {
		System.out.println("b class method executed");
		aa.aClassMethod();
	}
}
