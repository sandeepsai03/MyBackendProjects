package com.excelr;

public class Employee {

	//dyanamic data
	
	private Integer empNo;
	private String empName;
	private Integer empSal;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empNo, String empName, Integer empSal) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empSal = empSal;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
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
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", empSal=" + empSal + ", getEmpNo()=" + getEmpNo()
				+ ", getEmpName()=" + getEmpName() + ", getEmpSal()=" + getEmpSal() + "]";
	}
	
	
}
