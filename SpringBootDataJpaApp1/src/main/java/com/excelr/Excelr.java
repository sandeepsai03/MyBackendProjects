package com.excelr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="excelr_table")
public class Excelr {

	@Column(name="emp_id")
	@Id
	private Integer empId;
	@Column(name="empName")
	private String empName;
	@Column(name="emp_sal")
	private Integer empSal;
	public Excelr() {
		// TODO Auto-generated constructor stub
	}
	public Excelr(Integer empId, String empName, Integer empSal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Integer empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return "Excelr [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", getEmpId()=" + getEmpId()
				+ ", getEmpName()=" + getEmpName() + ", getEmpSal()=" + getEmpSal() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
