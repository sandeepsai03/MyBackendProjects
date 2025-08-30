package com.excelr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	private Integer addrId;
	
	private String city;
	
	private Integer empId;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Integer addrId, String city, Integer empId) {
		super();
		this.addrId = addrId;
		this.city = city;
		this.empId = empId;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", city=" + city + ", empId=" + empId + ", getAddrId()=" + getAddrId()
				+ ", getCity()=" + getCity() + ", getEmpId()=" + getEmpId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
