package com.excelr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Annotationconfig")
public class Car {
    
	@Value("200000")
	private Integer carPrice;
	
	@Value("Audi")
	private String carName;
	public Car() {
		super();
	}
	public Car(Integer carPrice, String carName) {
		super();
		this.carPrice = carPrice;
		this.carName = carName;
	}
	public Integer getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(Integer carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	@Override
	public String toString() {
		return "Car [carPrice=" + carPrice + ", carName=" + carName + ", getCarPrice()=" + getCarPrice()
				+ ", getCarName()=" + getCarName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
