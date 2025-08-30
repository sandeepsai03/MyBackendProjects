package com.excelr;

public class DebitCard implements Ipayment{

	@Override
	public void sendPayment() {
		
		System.out.println("sending money from Debitcard");
	}

}
