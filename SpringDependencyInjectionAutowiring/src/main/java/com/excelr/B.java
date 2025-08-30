package com.excelr;

public class B {

	///field dependency injection
	private A aa;

	///setter dependency injection
	/*public void setAa(A aa) {
		this.aa = aa;
	}*/
	
	///constructor dependency injection
	public B(A aa) {
		super();
		this.aa = aa;
	}


	public void bClassMethod() {
		System.out.println("b class method executed");
		aa.aClassMethod();
	}

	
	
	
}
