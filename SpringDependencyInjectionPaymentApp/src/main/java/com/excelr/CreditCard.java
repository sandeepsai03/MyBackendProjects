package com.excelr;

public class CreditCard implements Ipayment{

	@Override
	public void sendPayment() {
		
		System.out.println("sending money from  credit card");
		
	}
 
}
