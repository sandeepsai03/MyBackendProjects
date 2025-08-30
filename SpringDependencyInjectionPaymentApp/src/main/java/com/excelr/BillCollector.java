package com.excelr;

public class BillCollector {
	//field dependency injection
 private Ipayment ip;
 
 
	public Ipayment getIp() {
	return ip;
}

//setter dependency injection
 public void setIp(Ipayment ip) {
	this.ip = ip;
 }


	public void takePayment() {
		System.out.println("taking money from customer");
		ip.sendPayment();
	}
}
